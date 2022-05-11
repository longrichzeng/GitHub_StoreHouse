<template>
    <div>
        <div class="first_table_style" id="firstChart"></div>
        <el-row>
            <el-col :span="8">
                <div class="second_table_style" id="secondChart"></div>
            </el-col>
            <el-col :span="8">
                <div class="third_table_style" id="thirdChart"></div>
            </el-col>
            <el-col :span="8">
                <div class="fourth_table_style" id="fourthChart"></div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
export default({
    inject: ['reload'],
    data(){
        return{

        }
    },    
    mounted(){
		this.firstChartWay()
        this.secondChartWay()
        this.thirdChartWay()
        this.fourthChartWay()
	},
    created(){    

    },
    methods:{
        //已完成
        firstChartWay(){
            this.axios({
                method: 'post',
                url: '/administrator/getAnalysisDataBeforeSevenDay',
            }).then(response=>{
                let totalData = response.data
                console.log(totalData)
                this.$echarts.init(document.getElementById('firstChart')).setOption({
                    title: {
                        text: 'Anime网站数据展示'
                    },
                    color: ['#ee3f4d', '#346c9c'],
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data: ['日注册量', '日登陆量']
                    },
                    grid: {
                        left: '3%',
                        right: '3%',
                        bottom: '3%',
                        containLabel: true
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {}
                        }
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: ["月曜日", '火耀日', '水曜日', '木曜日', '金曜日', '土曜日', '日曜日']
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [
                        {
                            name: '用户日登陆量',
                            type: 'line',    
                            data: [
                                totalData[0].dailyLoginOfUsers,
                                totalData[1].dailyLoginOfUsers,
                                totalData[2].dailyLoginOfUsers,
                                totalData[3].dailyLoginOfUsers,
                                totalData[4].dailyLoginOfUsers,
                                totalData[5].dailyLoginOfUsers,
                                totalData[6].dailyLoginOfUsers,
                            ]
                        },
                        {
                            name: '用户日注册量',
                            type: 'line',
                            data: [
                                totalData[0].userDailyRegis,
                                totalData[1].userDailyRegis,
                                totalData[2].userDailyRegis,
                                totalData[3].userDailyRegis,
                                totalData[4].userDailyRegis,
                                totalData[5].userDailyRegis,
                                totalData[6].userDailyRegis,
                            ]
                        }
                    ]
                })


            }).catch(error=>{
                console.log(error)
            })
        },

        //已完成
        secondChartWay(){
            this.axios({
                method: 'post',
                url: '/administrator/getTotalData',
            }).then(response=>{
                let totalData = response.data
                this.$echarts.init(document.getElementById('secondChart')).setOption({
                    title: {
                        text: '数据总量',
                        subtext: 'Data Total',
                        left: 'center'
                    },
                    tooltip: {
                        trigger: 'item'
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                    },
                    series: [
                        {
                        name: 'Data Total',
                        type: 'pie',
                        radius: '50%',
                        data: [
                            { value: totalData[0], name: '番剧总数' },
                            { value: totalData[1], name: '音乐总数' },
                            { value: totalData[2], name: '景品总数' },
                            { value: totalData[3], name: '笔记总数' },
                            { value: totalData[4], name: '用户总数' }
                        ],
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                        }
                    ]
                })


            }).catch(error=>{
                console.log(error)
            })
        },

        //已完成
        thirdChartWay(){

            this.axios({
                method: 'post',
                url: '/administrator/getAnalysisDataBeforeSevenDay',
            }).then(response=>{
                let totalData = response.data
                this.$echarts.init(document.getElementById('thirdChart')).setOption({
                    xAxis: {
                        type: 'category',
                        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [
                        {
                        data: [
                            {
                                value: totalData[0].dailyPurchasesOfJinpin,
                                itemStyle: {
                                    color: '#4A708B'
                                }
                            }, 
                            {
                                value: totalData[1].dailyPurchasesOfJinpin,
                                itemStyle: {
                                    color: '#346c9c'
                                }
                            }, 
                            {
                                value: totalData[2].dailyPurchasesOfJinpin,
                                itemStyle: {
                                    color: '#104E8B'
                                }
                            }, 
                            {
                                value: totalData[3].dailyPurchasesOfJinpin,
                                itemStyle: {
                                    color: '#104E8B'
                                }
                            }, 
                            {
                                value: totalData[4].dailyPurchasesOfJinpin,
                                itemStyle: {
                                    color: '#5bc2e7'
                                }
                            }, 
                            {
                                value: totalData[5].dailyPurchasesOfJinpin,
                                itemStyle: {
                                    color: '#4682B4'
                                }
                            }, 
                            {
                                value: totalData[6].dailyPurchasesOfJinpin,
                                itemStyle: {
                                    color: '#1E90FF'
                                }
                            },            
                        ],
                        
                        type: 'bar',
                        showBackground: true,
                        backgroundStyle: {
                            color: 'rgba(180, 180, 180, 0.2)'
                        },
                        itemStyle: {
							normal: {
								label: {
									show: true, //开启显示
									position: 'top', //在上方显示
									textStyle: { //数值样式
										color: 'black',
										fontSize: 10
									}
								}
							}
                        }
                        }
                    ]
                })
            }).catch(error=>{
                console.log(error)
            })
        },

        fourthChartWay(){
            this.$echarts.init(document.getElementById('fourthChart')).setOption({
                title: {
                    text: 'Anime_Web_technology_dependent',
                    bottom: 0,
                    textStyle:{
                        fontSize: 12,
                    }
                },
                legend: {
                    data: ['前端技术', '后端技术']
                },
                radar: {
                    // shape: 'circle',
                    indicator: [
                        { name: 'SpringBoot/ Vue', max: 100 },
                        { name: 'SpringMVC/ ElementsUI', max: 100 },
                        { name: 'MyBatis/ ECharts', max: 100 },
                        { name: 'Java/ Axios', max: 100 },
                        { name: 'Shiro/ Cookie', max: 100 },
                        { name: 'Radis/ JavaScript', max: 100 }
                    ],
                },
                series: [
                    {
                    name: 'technology depend',
                    type: 'radar',
                    data: [
                        {
                            value: [90, 85, 65, 50, 45, 75],
                            name: '前端技术'
                        },
                        {
                            value: [60, 80, 85, 90, 50, 30],
                            name: '后端技术'
                        },
                    ],
                    // label: {
                    //     normal: {
                    //         show: true,
                    //         formatter:function(params) {
                    //             return params.value;
                    //         }
                    //     }
                    // }
                    }
                ]
            })
        },
    }
})
</script>

<style scoped>
.first_table_style{
    border: black 1px solid;
    border-radius: 15px;
    margin-top: 1%;
    margin-left: 1%;
    margin-right: 1%;
    width: auto;
    height: 300px;
    background-color: rgb(255, 255, 255);
}
.second_table_style{
    border: black 1px solid;
    border-radius: 15px;
    margin-top: 1%;
    margin-left: 1%;
    margin-right: 1%;
    width: auto;
    height: 300px;
    background-color: rgb(255, 255, 255);
}
.third_table_style{
    border: black 1px solid;
    border-radius: 15px;
    margin-top: 1%;
    margin-left: 1%;
    margin-right: 1%;
    width: auto;
    height: 300px;
    background-color: rgb(255, 255, 255);
}
.fourth_table_style{
    border: black 1px solid;
    border-radius: 15px;
    margin-top: 1%;
    margin-left: 1%;
    margin-right: 1%;
    width: auto;
    height: 300px;
    background-color: rgb(255, 255, 255);
}
</style>
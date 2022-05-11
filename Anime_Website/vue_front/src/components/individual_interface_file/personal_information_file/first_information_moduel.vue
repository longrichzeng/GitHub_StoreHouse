<template>
    <div>
        <div v-if="judge">
            <div class="first_table_style" id="first_charts" @click="dialogVisibleOne = true"></div>
        <!-- **************************************************************************************************************** -->
            <el-dialog title="提示" :visible.sync="dialogVisibleOne" width="35%" :before-close="handleClose">
                <div style="font-family: STFangsong; font-size: 25px; font-weight: 500;">
                    项目名称一:&emsp;&emsp;<input id="all_input_style" type="text" v-model="modifyTableData[0].firstItemName" /><br>
                    项目数据一:&emsp;&emsp;<input id="all_input_style" type="text" v-model="modifyTableData[0].firstItemData" /><br>
                    项目名称二:&emsp;&emsp;<input id="all_input_style" type="text" v-model="modifyTableData[0].secondItemName" /><br>
                    项目数据二:&emsp;&emsp;<input id="all_input_style" type="text" v-model="modifyTableData[0].secondItemData" /><br>
                    项目名称三:&emsp;&emsp;<input id="all_input_style" type="text" v-model="modifyTableData[0].thirtItemName" /><br>
                    项目数据三:&emsp;&emsp;<input id="all_input_style" type="text" v-model="modifyTableData[0].thirtItemData" /><br>
                    项目名称四:&emsp;&emsp;<input id="all_input_style" type="text" v-model="modifyTableData[0].fourthItemName" /><br>
                    项目数据四:&emsp;&emsp;<input id="all_input_style" type="text" v-model="modifyTableData[0].fourthItemData" /><br>
                    项目名称五:&emsp;&emsp;<input id="all_input_style" type="text" v-model="modifyTableData[0].fifthItemName" /><br>
                    项目数据五:&emsp;&emsp;<input id="all_input_style" type="text" v-model="modifyTableData[0].fifthItemData" /><br>
                </div>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="dialogVisibleOne = false">取 消</el-button>
                    <el-button type="primary" @click="modifyData">确 定</el-button>
                </span>
            </el-dialog>              
        </div>
        <div class="first_table_style" v-if="!judge">
            <el-button id="no_data_style" type="text" class="el-icon-edit-outline" @click="dialogVisible = true"></el-button>
            <p id="tip_sentence_style">你还未添加表格一数据！</p>
            <!-- <el-alert title="成功提示的文案" type="success" show-icon></el-alert> -->
            <!-- ************************************************************************************************************* -->
            <el-dialog title="提示" :visible.sync="dialogVisible" width="35%" :before-close="handleClose">
                <div style="font-family: STFangsong; font-size: 25px; font-weight: 500;">
                    项目名称一:&emsp;&emsp;<input id="all_input_style" placeholder="请输入表格项目一的名称" type="text" v-model="tableData[0].firstItemName" /><br>
                    项目数据一:&emsp;&emsp;<input id="all_input_style" placeholder="请用英文逗号将七个数据隔开" type="text" v-model="tableData[0].firstItemData" /><br>
                    项目名称二:&emsp;&emsp;<input id="all_input_style" placeholder="请输入表格项目一的名称" type="text" v-model="tableData[0].secondItemName" /><br>
                    项目数据二:&emsp;&emsp;<input id="all_input_style" placeholder="请用英文逗号将七个数据隔开" type="text" v-model="tableData[0].secondItemData" /><br>
                    项目名称三:&emsp;&emsp;<input id="all_input_style" placeholder="请输入表格项目一的名称" type="text" v-model="tableData[0].thirtItemName" /><br>
                    项目数据三:&emsp;&emsp;<input id="all_input_style" placeholder="请用英文逗号将七个数据隔开" type="text" v-model="tableData[0].thirtItemData" /><br>
                    项目名称四:&emsp;&emsp;<input id="all_input_style" placeholder="请输入表格项目一的名称" type="text" v-model="tableData[0].fourthItemName" /><br>
                    项目数据四:&emsp;&emsp;<input id="all_input_style" placeholder="请用英文逗号将七个数据隔开" type="text" v-model="tableData[0].fourthItemData" /><br>
                    项目名称五:&emsp;&emsp;<input id="all_input_style" placeholder="请输入表格项目一的名称" type="text" v-model="tableData[0].fifthItemName" /><br>
                    项目数据五:&emsp;&emsp;<input id="all_input_style" placeholder="请用英文逗号将七个数据隔开" type="text" v-model="tableData[0].fifthItemData" /><br>
                </div>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="dialogVisible = false">取 消</el-button>
                    <el-button type="primary" @click="submitTableData">确 定</el-button>
                </span>
            </el-dialog>            
        </div>  
    </div>
</template>

<script>
import VueCookies from 'vue-cookies';
export default({
    inject: ['reload'],
    data(){
        return{
            judge: true,
            dialogVisible: false,
            dialogVisibleOne: false,
            tableData: [{
                firstItemName: null,
                firstItemData: null,
                secondItemName: null,
                secondItemData: null,
                thirtItemName: null,
                thirtItemData: null,
                fourthItemName: null,
                fourthItemData: null,
                fifthItemName: null,
                fifthItemData: null,
            }],
            modifyTableData: ''
        }
    },    
    mounted(){
		this.charts()
	},
    created(){
        let postData = this.qs.stringify({
            userName: VueCookies.get("username"),
            location: "1",
        });
        this.axios({
            method: 'post',
            url: '/individual/getPersonalInformationData',
            data: postData,
        }).then(response=>{
            if(response.data.length == 0){
                this.judge = false
            }else{
                this.modifyTableData = response.data
                this.judge = true
            }
        }).catch(error=>{
            console.log(error)
        })
    },
    methods:{
        charts(){
            let postData = this.qs.stringify({
                userName: VueCookies.get("username"),
                location: "1",
            });
            this.axios({
                method: 'post',
                url: '/individual/getPersonalInformationData',
                data: postData,
            }).then(response=>{
                if(response.data.length != 0){
                    let tableInfor = response.data;
                    var firstData = tableInfor[0].firstItemData.split(",");
                    var secondData = tableInfor[0].secondItemData.split(",");
                    var thirtData = tableInfor[0].thirtItemData.split(",");
                    var fourthData = tableInfor[0].fourthItemData.split(",");
                    var fifthData = tableInfor[0].fifthItemData.split(",");
                
                    var firstName = tableInfor[0].firstItemName;
                    var secondName = tableInfor[0].secondItemName;
                    var thirtName = tableInfor[0].thirtItemName;
                    var fourthName = tableInfor[0].fourthItemName;
                    var fifthName = tableInfor[0].fifthItemName;
                    this.$echarts.init(document.getElementById('first_charts')).setOption({
                        //表格标题
                        title: {
                            text: 'Stacked Line'
                        },
                        color: ['#ee3f4d', '#346c9c', '#12aa9c', '#fed71a', '#b5aa90'],
                        //
                        tooltip: {
                            trigger: 'axis'
                        },
                        //hovor显示数据集
                        legend: {
                            data: [
                                firstName, 
                                secondName,
                                thirtName, 
                                fourthName, 
                                fifthName],
                        },
                        grid: {
                            left: '3%',
                            right: '3%',
                            bottom: '3%',
                            containLabel: true
                        },
                        //是否保存表格为图片
                        toolbox: {
                        feature: {
                            saveAsImage: {}
                        }
                        },
                        //X轴坐标
                        xAxis: {
                            type: 'category',
                            boundaryGap: false,
                            data: ["月曜日", '火耀日', '水曜日', '木曜日', '金曜日', '土曜日', '日曜日']
                        },
                        //Y轴坐标
                        yAxis: {
                            type: 'value',
                        },
                        //数据集
                        series: [
                            {
                                name: firstName,
                                type: 'line',
                                stack: 'Total',
                                data: [firstData[0], firstData[1], firstData[2], firstData[3], firstData[4], firstData[5], firstData[6]]
                            },
                            {
                                name: secondName,
                                type: 'line',
                                stack: 'Total',
                                data: [secondData[0], secondData[1], secondData[2], secondData[3], secondData[4], secondData[5], secondData[6]]
                            },
                            {
                                name: thirtName,
                                type: 'line',
                                stack: 'Total',
                                data: [thirtData[0], thirtData[1], thirtData[2], thirtData[3], thirtData[4], thirtData[5], thirtData[6]]
                            },
                            {
                                name: fourthName,
                                type: 'line',
                                stack: 'Total',
                                data: [fourthData[0], fourthData[1], fourthData[2], fourthData[3], fourthData[4], fourthData[5], fourthData[6]]
                            },
                            {
                                name: fifthName,
                                type: 'line',
                                stack: 'Total',
                                data: [fifthData[0], fifthData[1], fifthData[2], fifthData[3], fifthData[4], fifthData[5], fifthData[6]]
                            }]
                        })
                    }
            }).catch(error=>{
                console.log(error)
            })  
        },
        submitTableData(){
            console.log(this.tableData[0])
        //     if(this.tableData[0].firstItemName != ""){}
            let postData = this.qs.stringify({
                userName: VueCookies.get("username"),
                location: "1",
                firstItemName: this.tableData[0].firstItemName,
                firstItemData: this.tableData[0].firstItemData,
                secondItemName: this.tableData[0].secondItemName,
                secondItemData: this.tableData[0].secondItemData,
                thirtItemName: this.tableData[0].thirtItemName,
                thirtItemData: this.tableData[0].thirtItemData,
                fourthItemName: this.tableData[0].fourthItemName,
                fourthItemData: this.tableData[0].fourthItemData,
                fifthItemName: this.tableData[0].fifthItemName,
                fifthItemData: this.tableData[0].fifthItemData,
            });
            this.axios({
                method: 'post',
                url: '/individual/addPersonalInformationData',
                data: postData,
            }).then(response=>{
                if(response.data.length != 0){                
                    this.$message({
                        type: 'success',
                        message: "数据添加成功！"
                    })
                    this.reload()
                    this.dialogVisible = false
                    this.tableData = null
                }else{
                    this.$message({
                        type: 'error',
                        message: "数据添加失败！"
                    })
                }
            }).catch(error=>{
                console.log(error)
            })
        },
        modifyData(){
            if(this.modifyTableData.length != 0){
                let postData = this.qs.stringify({
                    userName: VueCookies.get("username"),
                    location: "1",
                    firstItemName: this.modifyTableData[0].firstItemName,
                    firstItemData: this.modifyTableData[0].firstItemData,
                    secondItemName: this.modifyTableData[0].secondItemName,
                    secondItemData: this.modifyTableData[0].secondItemData,
                    thirtItemName: this.modifyTableData[0].thirtItemName,
                    thirtItemData: this.modifyTableData[0].thirtItemData,
                    fourthItemName: this.modifyTableData[0].fourthItemName,
                    fourthItemData: this.modifyTableData[0].fourthItemData,
                    fifthItemName: this.modifyTableData[0].fifthItemName,
                    fifthItemData: this.modifyTableData[0].fifthItemData,
                });
                this.axios({
                    method: 'post',
                    url: '/individual/modifyPersonalInformationData',
                    data: postData,
                }).then(response=>{
                    if(response.data.length != 0){                
                        this.$message({
                            type: 'success',
                            message: "数据添加成功！"
                        })
                        this.reload()
                        this.dialogVisibleOne = false
                        this.modifyTableData = null
                    }else{
                        this.$message({
                            type: 'error',
                            message: "数据添加失败！"
                        })
                    }
                }).catch(error=>{
                    console.log(error)
                })
            }
        },
        handleClose(done) {
            this.$confirm('确认关闭？').then(_ => {
                done();
            }).catch(_ => {});
        },
    }
})
</script>

<style scoped>
.first_table_style{
    border-radius: 15px;
    margin-top: 1%;
    margin-left: 1%;
    margin-right: 1%;
    width: auto;
    height: 400px;
    background-color: rgb(255, 255, 255);
}
#no_data_style{
    border-radius: 15px;
    margin-left: 46%;
    font-size: 5vw;
}
#tip_sentence_style{
    font-size: 2vw;
    font-weight: 900;
    font-family: STFangsong;
    text-align: center;
}
#all_input_style{
    color: rgb(104, 110, 110);
    width: 60%; 
    font-weight: 900;
    height: 26px; 
    font-size: 20px; 
    font-family: STFangsong;
}
</style>
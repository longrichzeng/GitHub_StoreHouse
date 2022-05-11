<template>
    <div>
        <div v-if="judge">
            <div class="first_table_style" id="second_charts"></div>
        </div>
        <div class="first_table_style" v-if="!judge">
            <el-button id="no_data_style" type="text" class="el-icon-edit-outline" @click="get"></el-button>
            <p id="tip_sentence_style">你还未添加表格二数据！</p>
        </div>
        <el-dialog title="提示" :visible.sync="dialogVisible" width="35%" :before-close="handleClose">
            <div style="font-family: STFangsong; font-size: 25px; font-weight: 500;">
                项目名称一:&emsp;&emsp;<input id="all_input_style" type="text" v-model="tableData[0].firstItemName" /><br>
                项目数据一:&emsp;&emsp;<input id="all_input_style" type="text" v-model="tableData[0].firstItemData" /><br>
                项目名称二:&emsp;&emsp;<input id="all_input_style" type="text" v-model="tableData[0].secondItemName" /><br>
                项目数据二:&emsp;&emsp;<input id="all_input_style" type="text" v-model="tableData[0].secondItemData" /><br>
                项目名称三:&emsp;&emsp;<input id="all_input_style" type="text" v-model="tableData[0].thirtItemName" /><br>
                项目数据三:&emsp;&emsp;<input id="all_input_style" type="text" v-model="tableData[0].thirtItemData" /><br>
                项目名称四:&emsp;&emsp;<input id="all_input_style" type="text" v-model="tableData[0].fourthItemName" /><br>
                项目数据四:&emsp;&emsp;<input id="all_input_style" type="text" v-model="tableData[0].fourthItemData" /><br>
                项目名称五:&emsp;&emsp;<input id="all_input_style" type="text" v-model="tableData[0].fifthItemName" /><br>
                项目数据五:&emsp;&emsp;<input id="all_input_style" type="text" v-model="tableData[0].fifthItemData" /><br>
                项目名称六:&emsp;&emsp;<input id="all_input_style" type="text" v-model="tableData[0].sixthItemName" /><br>
                项目数据六:&emsp;&emsp;<input id="all_input_style" type="text" v-model="tableData[0].sixthItemData" /><br>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="submitTableData">确 定</el-button>
            </span>
        </el-dialog>          
    </div>
</template>

<script>
import VueCookies from 'vue-cookies';
export default({
    inject: ['reload'],
    data(){
        return{
            infor: {},
            judge: true,
            dialogVisible: false,
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
                sixthItemName: null,
                sixthItemData: null,
            }]
        }
    },    
    mounted(){
		this.charts()
	},
    created(){
        let postData = this.qs.stringify({
            userName: VueCookies.get("username"),
            location: "2"
        });
        this.axios({
            method: 'post',
            url: '/individual/getProfessionalSkillData',
            data: postData,
        }).then(response=>{
            if(response.data.length == 0){
                this.judge = false
            }else{
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
                location: "2"
            });
            this.axios({
                method: 'post',
                url: '/individual/getProfessionalSkillData',
                data: postData,
            }).then(response=>{
                if(response.data.length != 0){
                let tableInfor = response.data;
                var firstName = tableInfor[0].firstItemName;
                var secondName = tableInfor[0].secondItemName;
                var thirtName = tableInfor[0].thirtItemName;
                var fourthName = tableInfor[0].fourthItemName;
                var fifthName = tableInfor[0].fifthItemName;
                var sixthName = tableInfor[0].sixthItemName;

                var firstData = tableInfor[0].firstItemData;
                var secondData = tableInfor[0].secondItemData;
                var thirtData = tableInfor[0].thirtItemData;
                var fourthData = tableInfor[0].fourthItemData;
                var fifthData = tableInfor[0].fifthItemData;
                var sixthData = tableInfor[0].sixthItemData;
                this.$echarts.init(document.getElementById('second_charts')).setOption({
                    tooltip: {
                        trigger: 'item'
                    },
                    legend: {
                        top: '5%',
                        left: 'center'
                    },
                    series: [{
                        name: 'Access From',
                        type: 'pie',
                        radius: ['40%', '70%'],
                        avoidLabelOverlap: false,
                        itemStyle: {
                            borderRadius: 10,
                            borderColor: '#fff',
                            borderWidth: 2
                        },
                        label: {
                            show: false,
                            position: 'center'
                        },
                        emphasis: {
                            label: {
                                show: true,
                                fontSize: '40',
                                fontWeight: 'bold'
                            }
                        },
                        labelLine: {
                            show: false
                        },
                        data: [
                            { value: firstData , name: firstName },
                            { value: secondData , name: secondName },
                            { value: thirtData , name: thirtName },
                            { value: fourthData , name: fourthName },
                            { value: fifthData , name: fifthName },
                            { value: sixthData , name: sixthName }
                        ]
                    }]
                })
                }
            }).catch(error=>{
                console.log(error)
            })  
        },
        get(){
            this.dialogVisible = true
        },
        submitTableData(){
            let postData = this.qs.stringify({
                userName: VueCookies.get("username"),
                location: "2",
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
                sixthItemName: this.tableData[0].sixthItemName,
                sixthItemData: this.tableData[0].sixthItemData,
            });
            this.axios({
                method: 'post',
                url: '/individual/addProfessionalSkillData',
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
    margin-left: 43%;
    font-size: 5vw;
    text-align: center;
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
    font-size: 25px; 
    font-family: STFangsong;
}
</style>    
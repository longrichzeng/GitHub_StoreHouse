<template>
    <div>
        <div v-if="judge">
            <div class="first_table_style" id="second_charts" @click="dialogVisibleOne = true"></div>
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
            <p id="tip_sentence_style">你还未添加表格二数据！</p>
            <!-- <el-alert title="成功提示的文案" type="success" show-icon></el-alert> -->
            <!-- ************************************************************************************************************* -->
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
            location: "2"
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
                location: "2"
            });
            this.axios({
                method: 'post',
                url: '/individual/getPersonalInformationData',
                data: postData,
            }).then(response=>{
                if(response.data.length != 0){
                    let tableInfor = response.data;
                    var first = tableInfor[0].firstItemName;
                    var second = tableInfor[0].secondItemName;
                    var thirt = tableInfor[0].thirtItemName;
                    var fourth = tableInfor[0].fourthItemName;
                    var fifth = tableInfor[0].fifthItemName;

                    this.$echarts.init(document.getElementById('second_charts')).setOption({
                        xAxis: {
                            type: 'category',
                            data: [first, second, thirt, fourth, fifth]
                        },
                        yAxis: {
                            type: 'value'
                        },
                        series: [
                            {
                                data: [                                
                                    {
                                        value: tableInfor[0].firstItemData,
                                        itemStyle: {
                                            color: '#5bc2e7'
                                        }
                                    },                                
                                    {
                                        value: tableInfor[0].secondItemData,
                                        itemStyle: {
                                            color: '#6980cs'
                                        }
                                    },
                                    {
                                        value: tableInfor[0].thirtItemData,
                                        itemStyle: {
                                            color: '#70dfdf'
                                        }
                                    },                                
                                    {
                                        value: tableInfor[0].fourthItemData,
                                        itemStyle: {
                                            color: '#0eb0c9'
                                        }
                                    },
                                    {
                                        value: tableInfor[0].fifthItemData,
                                        itemStyle: {
                                            color: '#385466'
                                        }
                                    },                                                                                                 
                                ],
                                type: 'bar',
                                showBackground: true,
                                backgroundStyle: {
                                    color: 'rgba(180, 180, 180, 0.2)'
                                }
                            }
                        ]
                    })
                }
            }).catch(error=>{
                console.log(error)
            })  
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
            let postData = this.qs.stringify({
                userName: VueCookies.get("username"),
                location: "2",
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
                        message: "数据修改成功！"
                    })
                    this.reload()
                    this.dialogVisibleOne = false
                    this.modifyTableData = null
                }else{
                    this.$message({
                        type: 'error',
                        message: "数据修改失败！"
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
<template>
    <div>
        <el-button style="position: absolute; margin-top: -3.5%; font-size: 1.5vw" type="text" class="el-icon-edit-outline" @click="dialogVisible = true">添加计划</el-button>
        <div id="main_background_style">
            <el-table :row-style="{height: '0'}" :cell-style="{padding: '10px'}" :data="infor">
                <el-table-column prop="userName" label="计划制定者" width="180"></el-table-column>
                <el-table-column prop="location" label="计划循序编号" width="180"></el-table-column>
                <el-table-column prop="planContent" label="计划内容" width="200"></el-table-column>
                <el-table-column prop="planNotes" label="计划备注" width="200"></el-table-column>
                <el-table-column prop="planGenerateDate" label="计划生成时间" width="200"></el-table-column>
                <el-table-column label="删除" width="100">
                    <template slot-scope="scope">                        
                        <el-button style="font-size: 2vw" type="text" class="el-icon-delete" @click="deletePlanInfor(scope.row.location)"></el-button>                        
                    </template>
                </el-table-column>
                <el-table-column label="修改" width="100">
                    <template slot-scope="scope">                        
                        <el-button style="font-size: 2vw" type="text" class="el-icon-edit" @click="getPlanInfor(scope.row)"></el-button>                        
                    </template>
                </el-table-column>                
            </el-table>            
        </div>

        <!-- **************************************************************************************************************** -->
        <el-dialog title="提示" :visible.sync="dialogVisible" width="35%" :before-close="handleClose">
            <div style="font-family: STFangsong; font-size: 25px; font-weight: 500;">
                计划编号:&emsp;&emsp;<input id="all_input_style" type="text" v-model="tableData[0].location" /><br>
                计划内容:&emsp;&emsp;<input id="all_input_style" type="text" v-model="tableData[0].planContent" /><br>
                计划备注:&emsp;&emsp;<input id="all_input_style" type="text" v-model="tableData[0].planNotes" /><br>
                生成时间:&emsp;&emsp;<el-date-picker v-model="tableData[0].planGenerateDate" 
                                                    style="width: 61%"                                                     
                                                    type="date" 
                                                    placeholder="选择日期" 
                                                    size="large"
                                                    value-format="yyyy-MM-dd"></el-date-picker>                
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="submitTableData">确 定</el-button>
            </span>
        </el-dialog>              
        <!-- ************************************************************************************************************* -->
        <el-dialog title="提示" :visible.sync="dialogVisibleOne" width="35%" :before-close="handleClose">
            <div style="font-family: STFangsong; font-size: 25px; font-weight: 500;">
                <!-- 计划编号:&emsp;&emsp;<input id="all_input_style" type="text" v-model="tempData.location" /><br> -->
                计划内容:&emsp;&emsp;<input id="all_input_style" type="text" v-model="tempData.planContent" /><br>
                计划备注:&emsp;&emsp;<input id="all_input_style" type="text" v-model="tempData.planNotes" /><br>
                生成时间:&emsp;&emsp;<el-date-picker v-model="tempData.planGenerateDate" 
                                                    style="width: 61%"                                                     
                                                    type="date" 
                                                    placeholder="选择日期" 
                                                    size="large"
                                                    value-format="yyyy-MM-dd"></el-date-picker>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisibleOne = false">取 消</el-button>
                <el-button type="primary" @click="modifyData">确 定</el-button>
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
            infor: '',
            judge: true,
            dialogVisible: false,
            dialogVisibleOne: false,
            tableData: [{
                location: null,
                planContent: null,
                planNotes: null,
                planGenerateDate: null,
            }],
            tempData: [{
                location: null,
                planContent: null,
                planNotes: null,
                planGenerateDate: null,
            }],
        }
    },
    created(){
        let postData = this.qs.stringify({
            userName: VueCookies.get("username"),
        });
        this.axios({
            method: 'post',
            url: '/individual/getAnnualPlanData',
            data: postData,
        }).then(response=>{
            this.infor = response.data
        }).catch(error=>{
            console.log(error)
        })
    },
    methods:{     
        deletePlanInfor(number){
            let postData = this.qs.stringify({
                userName: VueCookies.get("username"),
                location: number
            });
            this.axios({
                method: 'post',
                url: '/individual/deleteAnnualPlanData',
                data: postData,
            }).then(response=>{
                if(response.data.length != 0){
                    this.$message({
                        type: "success",
                        message: "数据删除成功！"
                    })
                    this.reload()
                }else{
                    this.$message({
                        type: 'error',
                        message: '数据删除失败！!',                    
                    }); 
                }
            }).catch(error=>{
                console.log(error)
            })
        },
        submitTableData(){
            let postData = this.qs.stringify({
                userName: VueCookies.get("username"),
                location: this.tableData[0].location,
                planContent: this.tableData[0].planContent,
                planNotes: this.tableData[0].planNotes,
                planGenerateDate: this.tableData[0].planGenerateDate
            });
            console.log(postData)
            this.axios({
                method: 'post',
                url: '/individual/addAnnualPlanData',
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
        getPlanInfor(infor){
            this.tempData.location = infor.location
            this.tempData.planContent = infor.planContent
            this.tempData.planNotes = infor.planNotes
            this.tempData.planGenerateDate = infor.planGenerateDate
            this.dialogVisibleOne = true
        },
        modifyData(){
            let postData = this.qs.stringify({
                userName: VueCookies.get("username"),
                location: this.tempData.location,
                planContent: this.tempData.planContent,
                planNotes: this.tempData.planNotes,
                planGenerateDate: this.tempData.planGenerateDate
            });
            this.axios({
                method: 'post',
                url: '/individual/modifyAnnualPlanData',
                data: postData,
            }).then(response=>{
                if(response.data.length != 0){                
                    this.$message({
                        type: 'success',
                        message: "数据修改成功！"
                    })
                    this.reload()
                    this.dialogVisibleOne = false
                    this.tempData = null
                }else{
                    this.$message({
                        type: 'error',
                        message: "数据修改失败！"
                    })
                    this.tempData = null
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
#main_background_style{
    position: absolute;
    background-color: rgba(100, 149, 237, 0.3);
    width: 100%;
    height: auto;
    border-radius: 15px;
}
.el-table{
    font-size: 1.5vw;
    font-family: STFangsong;
    font-weight: 900;
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
<template>
    <div>
        <!-- 左边的导航栏部分 -->
        <div id="operationButton_style">
            <el-button id="singel_operationButton_style" class="el-icon-search" type="success" @click="searchByNameWindow = true">通过用户名查找日志</el-button>
            <el-button id="singel_operationButton_style" class="el-icon-search" type="primary" @click="searchByTimeWindow = true">通过时间查找日志</el-button>
            <!-- <el-button id="singel_operationButton_style" class="el-icon-search" type="danger" @click="">清除一周前的数据</el-button> -->
        </div>   
        <!-- ---------------------------------------------------------------------------------------------------------------------- -->
        <el-dialog title="根据用户名查找日志信息" :visible.sync="searchByNameWindow" width="93%" height="50%" :before-close="handleClose" :append-to-body="true">
            <p style="font-size: 1.5vw; font-family: STFangsong; font-weight: 900;" v-if="countTip != 0">查询到了{{countTip}}条相关数据！</p>
            <p style="font-size: 1.5vw; font-family: STFangsong; font-weight: 900;" v-if="countTip == 0">查不到相关数据！</p>
            <el-row>
                <el-col :span="20">
                    <el-input id="all_input_style" placeholder="请输入需要查找的用户名" v-model="executor"></el-input>
                </el-col>
                <el-col :span="2" :offset="1">
                    <el-button type="primary" class="el-icon-search" @click="searchNotesDataByName">查找</el-button>
                </el-col>
            </el-row>
            <el-table id="anime_table_style" :header-cell-style="{background:'#e9e7ef',color:'#555'}"
                        :cell-style="{background:'#F3F4F7',color:'#343536'}" 
                        :row-style="{height: '0', padding: '50px'}" size="mini" :data="perPage">
                <el-table-column label="日志编号" prop="logNumber" width="180"></el-table-column>
                <el-table-column label="执行者" prop="executor" width="130"></el-table-column>
                <el-table-column label="执行事务" prop="executeEvent" width="265"></el-table-column>
                <el-table-column label="访问接口" prop="accessInterface" width="365"></el-table-column>
                <el-table-column label="备注" prop="remark" width="165"></el-table-column>
                <el-table-column label="编辑时间" prop="executionTime" width="250"></el-table-column>
            </el-table>  
            <span slot="footer" class="dialog-footer">
                <el-button @click="closeWindow">取 消</el-button>
                <el-button type="primary" @click="closeWindow">确 定</el-button>
            </span>
        </el-dialog>   
        <!-- ---------------------------------------------------------------------------------------------------------------------- -->
        <el-dialog title="根据日期查找日志信息" :visible.sync="searchByTimeWindow" width="93%" height="50%" :before-close="handleClose" :append-to-body="true">
            <p style="font-size: 1.5vw; font-family: STFangsong; font-weight: 900;" v-if="countTip != 0">查询到了{{countTip}}条相关数据！</p>
            <p style="font-size: 1.5vw; font-family: STFangsong; font-weight: 900;" v-if="countTip == 0">查不到相关数据！</p>
            <el-row>
                <el-col :span="4">
                    <el-date-picker style="width: 100%; font-size: 1vw;" type="date" placeholder="选择日期" 
                                        size="large" value-format="yyyy-MM-dd" v-model="executionTime">
                    </el-date-picker><br>
                </el-col>
                <el-col :span="2" :offset="1">
                    <el-button type="primary" class="el-icon-search" @click="searchNotesDataByTime">查找</el-button>
                </el-col>
            </el-row>            
            <el-table id="anime_table_style" :header-cell-style="{background:'#e9e7ef',color:'#555'}"
                        :cell-style="{background:'#F3F4F7',color:'#343536'}" 
                        :row-style="{height: '0', padding: '50px'}" size="mini" :data="perPage">
                <el-table-column label="日志编号" prop="logNumber" width="180"></el-table-column>
                <el-table-column label="执行者" prop="executor" width="130"></el-table-column>
                <el-table-column label="执行事务" prop="executeEvent" width="265"></el-table-column>
                <el-table-column label="访问接口" prop="accessInterface" width="365"></el-table-column>
                <el-table-column label="备注" prop="remark" width="165"></el-table-column>
                <el-table-column label="编辑时间" prop="executionTime" width="250"></el-table-column>
            </el-table>  
            <span slot="footer" class="dialog-footer">
                <el-button @click="closeWindow">取 消</el-button>
                <el-button type="primary" @click="closeWindow">确 定</el-button>
            </span>
        </el-dialog>   
    </div>    
</template>

<script>
export default({
    inject: ['reload'],
    data(){
        return{
            perPage: new Array(),
            searchByNameWindow: false, 
            searchByTimeWindow: false,  
            deleteWindow: false, 
            countTip: 0,
            executor: '',
            executionTime: '',
            notesData: {
                logNumber: '',
                executor: '',
                executeEvent: '',
                accessInterface: '',
                remark: '',
                executionTime: '',
            }
        }
    },
    created(){
        
    },
    methods:{
        searchTableSingleData(){
            let postData = this.qs.stringify({
                musicName: this.musicName,
            });
            this.axios({
                method: 'post',
                url: '/administrator/getMusicDataByName',
                data: postData
            }).then(response =>{
                if(response.data.length != 0){
                    this.perPage = response.data   
                    // this.reload()
                }else{
                    this.$message({
                        type: 'warning',
                        message: "查不到相关数据！"
                    })
                }
            }).catch(error => {
                console.log(error)
            })
        },

        getByMusicIndex(command){
            let postData = this.qs.stringify({
                musicRecommendIndex: command,
            });
            this.axios({
                method: 'post',
                url: '/administrator/getMusicDataByIndex',
                data: postData
            }).then(response =>{
                if(response.data.length != 0){
                    this.perPage = response.data
                    this.countTip = response.data.length
                }else{
                    this.$message({
                        type: 'warning',
                        message: "查不到相关数据！"
                    })
                }
            }).catch(error => {
                console.log(error)
            })
        },

        handleClose(done) {
            this.$confirm('确认关闭？').then(_ => {
                done();
            }).catch(_ => {});
        },  

        searchNotesDataByName(){
            let postData = this.qs.stringify({
                executor: this.executor,
            });
            this.axios({
                method: 'post',
                url: '/administrator/getLogBoardByUsername',
                data: postData
            }).then(response =>{
                if(response.data.length != 0){
                    this.perPage = response.data
                    this.countTip = response.data.length
                }else{
                    this.$message({
                        type: 'warning',
                        message: "查不到相关数据！"
                    })
                }
            }).catch(error => {
                console.log(error)
            })
        },

        searchNotesDataByTime(){
            let postData = this.qs.stringify({
                executionTime: this.executionTime,
            });
            this.axios({
                method: 'post',
                url: '/administrator/getLogBoardByTime',
                data: postData
            }).then(response =>{
                if(response.data.length != 0){
                    this.perPage = response.data
                    this.countTip = response.data.length
                }else{
                    this.$message({
                        type: 'warning',
                        message: "查不到相关数据！"
                    })
                }
            }).catch(error => {
                console.log(error)
            })
        },

        deleteNotesData(){
            let postData = this.qs.stringify({
                executionTime: this.executionTime,
            });
            this.axios({
                method: 'post',
                url: '/administrator/deleteLogBoardData',
                data: postData
            }).then(response =>{
                if(response.data.length != 0){
                    this.$message({
                        type: 'success',
                        message: "数据删除成功！"
                    })
                }else{
                    this.$message({
                        type: 'error',
                        message: "数据删除失败！"
                    })
                }
            }).catch(error => {
                console.log(error)
            })            
        },

        closeWindow(){
            this.perPage = []
            this.searchByNameWindow = false, 
            this.searchByTimeWindow = false,  
            this.deleteWindow = false, 
            this.countTip = 0,
            this.userName = '',
            this.executionTime = ''
        }
    }
})
</script>

<style scoped>
#anime_table_style{
    top: 5%;
    left: 0%;
    width: 98%;
    font-size: 0.9vw;
    border-radius: 15px;
}
#operationButton_style{
    position: absolute;
    margin-top: 0.1%;
    margin-left: 1%;
}
#singel_operationButton_style{
    font-size: 1vw;
    font-weight: 900;
    font-family: STFangsong;
}
#dropdown_style{
    font-weight: 900;
    font-size: 1.7vw; 
    font-family: STFangsong;
    border: black 1px solid;
    border-radius: 5px;
}
#all_input_style{
    color: rgb(104, 110, 110);
    width: 60%; 
    font-weight: 900;
    height: 26px; 
    font-size: 1.5vw;
    border: black 1px solid;
    font-family: STFangsong;
    border-radius: 8px;
}
#upload_style{
    color: rgb(95, 95, 95); 
    font-weight: 900; 
    font-size: 1.5vw; 
    border: black 1px solid; 
    font-family: STFangsong;
    border-radius: 8px;
}
</style>
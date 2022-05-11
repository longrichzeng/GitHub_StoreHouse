<template>
    <div>
        <!-- 左边的导航栏部分 -->
        <div id="operationButton_style">
            <el-button id="singel_operationButton_style" class="el-icon-circle-plus-outline" type="success" @click="addWindow = true">添加笔记</el-button>
            <el-button id="singel_operationButton_style" class="el-icon-edit" type="primary" @click="sortWindow = true">笔记分类</el-button>
            <el-button id="singel_operationButton_style" class="el-icon-search" type="danger" @click="searchWindow = true">查找笔记</el-button>
        </div>   
        <!-- ********************************************************************************************************************* -->
        <el-dialog title="提示" :visible.sync="addWindow" width="35%" :before-close="handleClose" :append-to-body="true">
            <div style="font-family: STFangsong; font-size: 25px; font-weight: 500;">
                日志标题:&emsp;<input id="all_input_style" type="text" v-model="addNotesData.notesTitle"></input><br>
                日志内容:&emsp;<el-input id="all_input_style" type="textarea" v-model="addNotesData.notesContent"></el-input><br>
                生产时间:&emsp;<el-date-picker style="width: 61%; font-size: 1vw;" type="date" placeholder="选择日期" 
                                size="large" value-format="yyyy-MM-dd" v-model="formationTime"></el-date-picker><br>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="addWindow = false">取 消</el-button>
                <el-button type="primary" @click="addTableSingleData">确 定</el-button>
            </span>
        </el-dialog>
        <!-- ---------------------------------------------------------------------------------------------------------------------- -->
        <el-dialog title="根据类别查找笔记信息" :visible.sync="sortWindow" width="85%" height="50%" :before-close="handleClose" :append-to-body="true">
            <p style="font-size: 1.5vw; font-family: STFangsong; font-weight: 900;" v-if="countTip != 0">查询到了{{countTip}}条相关数据！</p>
            <p style="font-size: 1.5vw; font-family: STFangsong; font-weight: 900;" v-if="countTip == 0">查不到相关数据！</p>
            <el-row>
                <el-col :span="20">
                    &emsp;<el-date-picker style="width: 61%; font-size: 1vw;" type="date" placeholder="选择日期" 
                    size="large" value-format="yyyy-MM-dd" v-model="formationTime"></el-date-picker><br>
                </el-col>
                <el-col :span="2" :offset="1">
                    <el-button type="primary" class="el-icon-search" @click="searchTableSingleData">查找</el-button>
                </el-col>
            </el-row>                            
            <el-table id="anime_table_style" :header-cell-style="{background:'#e9e7ef',color:'#555'}"
                        :cell-style="{background:'#F3F4F7',color:'#343536'}" 
                        :row-style="{height: '0', padding: '50px'}" size="mini" :data="perPage">
                <el-table-column label="笔记编号" prop="notesId" width="180"></el-table-column>
                <el-table-column label="笔记标题" prop="notesTitle" width="160"></el-table-column>
                <el-table-column label="笔记内容" prop="notesContent" width="750"></el-table-column>
                <el-table-column label="编辑时间" prop="formationTime" width="145"></el-table-column>            
            </el-table>  
            <span slot="footer" class="dialog-footer">
                <el-button @click="closeWindow">取 消</el-button>
                <el-button type="primary" @click="closeWindow">确 定</el-button>
            </span>
        </el-dialog>   
        <!-- ---------------------------------------------------------------------------------------------------------------------- -->
        <el-dialog title="提示" :visible.sync="searchWindow" width="85%" :before-close="handleClose" :append-to-body="true">
            <el-row>
                <el-col :span="20">
                    <el-input id="all_input_style" placeholder="请输入需要查找的笔记名称" v-model="notesTitle"></el-input>
                </el-col>
                <el-col :span="2" :offset="1">
                    <el-button type="primary" class="el-icon-search" @click="getNotesInforDataByTitle">查找</el-button>
                </el-col>
            </el-row>
            <el-table id="anime_table_style" :header-cell-style="{background:'#e9e7ef',color:'#555'}"
                        :cell-style="{background:'#F3F4F7',color:'#343536'}" 
                        :row-style="{height: '0', padding: '50px'}" size="mini" :data="perPage">
                <el-table-column label="笔记编号" prop="notesId" width="180"></el-table-column>
                <el-table-column label="笔记标题" prop="notesTitle" width="160"></el-table-column>
                <el-table-column label="笔记内容" prop="notesContent" width="750"></el-table-column>
                <el-table-column label="编辑时间" prop="formationTime" width="145"></el-table-column>           
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
            addWindow: false, 
            sortWindow: false,
            searchWindow: false, 
            textarea: '',
            notesTitle: '',
            formationTime: '',
            countTip: 0,
            addNotesData: {
                notesId: '',
                notesTitle: '',
                notesContent: '',
                formationTime: '',
            }
        }
    },
    created(){
        
    },
    methods:{
        addTableSingleData(){
            if(this.addNotesData.notesTitle != "" && 
            this.addNotesData.notesContent != "" && this.addNotesData.formationTime != ""){
                let postData = this.qs.stringify({
                    notesId: null,
                    notesTitle: this.addNotesData.notesTitle,
                    notesContent: this.addNotesData.notesContent,
                    formationTime: this.addNotesData.formationTime,
                });
                this.axios({
                    method: 'post',
                    url: '/administrator/addNotesInforData',
                    data: postData
                }).then(response =>{
                    if(response.data != ""){
                        this.$message({
                            type: 'success',
                            message: "数据添加成功！"
                        })
                        this.reload()
                        this.addNotesData = ""
                        this.addWindow = false
                    }else{
                        this.$message({
                            type: 'warning',
                            message: "数据添加失败！"
                        })
                    }
                }).catch(error => {
                    console.log(error)
                })
            }else{
                this.$message({
                    type: 'warning',
                    message: "相关数据不能为空！"
                })
            }
        },

        searchTableSingleData(){
            let postData = this.qs.stringify({
                formationTime: this.formationTime,
            });
            this.axios({
                method: 'post',
                url: '/administrator/getNotesInforDataByTime',
                data: postData
            }).then(response =>{
                this.countTip = response.data.length
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

        getNotesInforDataByTitle(){
            let postData = this.qs.stringify({
                notesTitle: this.notesTitle,
            });
            this.axios({
                method: 'post',
                url: '/administrator/getNotesInforDataByTitle',
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

        handleClose(done) {
            this.$confirm('确认关闭？').then(_ => {
                done();
            }).catch(_ => {});
        },  

        closeWindow(){
            this.perPage = []
            this.sortWindow =  false
            this.searchWindow =  false
            this.notesTitle = ""
            this.countTip = 0
            this.formationTime = ""
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
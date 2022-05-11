<template>
    <div>
        <v-notesOperationButton></v-notesOperationButton>
        <el-table id="anime_table_style" :header-cell-style="{background:'#e9e7ef',color:'#555'}"
                    :cell-style="{background:'#F3F4F7',color:'#343536'}" 
                    :row-style="{height: '0', padding: '50px'}" size="mini" :data="perPage">
            <el-table-column label="笔记编号" prop="notesId" width="180"></el-table-column>
            <el-table-column label="笔记标题" prop="notesTitle" width="160"></el-table-column>
            <el-table-column label="笔记内容" prop="notesContent" width="750"></el-table-column>
            <el-table-column label="编辑时间" prop="formationTime" width="145"></el-table-column>
            <el-table-column label="删除" width="60">
                <template slot-scope="scope">                        
                    <el-button style="font-size: 1.5vw" type="text" class="el-icon-delete" @click="deleteTableSingleData(scope.row.animeNumber)"></el-button>                        
                </template>
            </el-table-column>
            <el-table-column label="修改" width="60">
                <template slot-scope="scope">                        
                    <el-button style="font-size: 1.5vw" type="text" class="el-icon-edit" @click="dataTransferStation(scope.row)"></el-button>                        
                </template>
            </el-table-column>              
        </el-table>          
        <!-- ********************************************************************************************************************* -->
        <div id="pagination_style">
            <el-pagination
            @current-change="handleCurrentChange"
            :page-size="9"
            layout="prev, pager, next, jumper, total"
            :total=totalData>
            </el-pagination>
        </div>
        <!-- ********************************************************************************************************************* -->
        <!-- 修改数据的弹出框 -->
        <el-dialog title="提示" :visible.sync="modifyWindow" width="35%" :before-close="handleClose" :append-to-body="true">
            <div style="font-family: STFangsong; font-size: 25px; font-weight: 500;">
                日志标题:&emsp;<input id="all_input_style" type="text" v-model="needModifyNotesData.notesTitle"></input><br>
                日志内容:&emsp;<el-input id="all_input_style" type="textarea" v-model="needModifyNotesData.notesContent"></el-input><br>
                生产时间:&emsp;<el-date-picker style="width: 61%; font-size: 1vw;" type="date" placeholder="选择日期" 
                                size="large" value-format="yyyy-MM-dd" v-model="needModifyNotesData.formationTime"></el-date-picker><br>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="modifyWindow = false">取 消</el-button>
                <el-button type="primary" @click="modifyTableSingleData">确 定</el-button>
            </span>
        </el-dialog>   
    </div>    
</template>

<script>
import notesOperationButton from '../data_management_file/notes_operation_button.vue'
export default({
    inject: ['reload'],
    data(){
        return{
            totalData: 0,
            modifyWindow: false,
            perPage: new Array(),
            textarea: '',
            needModifyNotesData: {
                notesId: '',
                notesTitle: '',
                notesContent: '',
                formationTime: '',
            },
        }
    },
    created(){
        this.axios({
            method: 'post',
            url: '/administrator/getNotesInforData'
        }).then(response =>{
            this.totalData = response.data.length
            this.perPage = response.data.slice(0,9)
        }).catch(error => {
            console.log(error)
        })
    },
    methods:{
        handleCurrentChange(val) {
            this.axios({
                method: 'post',
                url: '/administrator/getNotesInforData'
            }).then(response =>{
                let head = (val-1)*9
                let end = val*9
                this.perPage = response.data.slice(head, end)
            }).catch(error => {
                console.log(error)
            })
        },

        dataTransferStation(notesData){
            this.needModifyNotesData.notesId = notesData.notesId,
            this.needModifyNotesData.notesTitle = notesData.notesTitle,
            this.needModifyNotesData.notesContent = notesData.notesContent,
            this.needModifyNotesData.formationTime = notesData.formationTime
            this.modifyWindow = true
        },

        deleteTableSingleData(notesId){            
            let postData = this.qs.stringify({
                notesId: notesId,
            });
            this.axios({
                method: 'post',
                url: '/administrator/deleteNotesInforData',
                data: postData
            }).then(response =>{
                if(response.data != ""){
                    this.$message({
                        type: 'success',
                        message: '数据删除成功！'
                    })
                    this.reload()
                }else{
                    this.$message({
                        type: 'error',
                        message: '数据删除失败！'
                    })
                }
            }).catch(error => {
                console.log(error)
            })
        },

        modifyTableSingleData(){
            if(this.needModifyNotesData.notesId != "" && this.needModifyNotesData.notesTitle != "" && 
            this.needModifyNotesData.notesContent != "" && this.needModifyNotesData.formationTime != ""){
                let postData = this.qs.stringify({
                    notesId: this.needModifyNotesData.notesId,
                    notesTitle: this.needModifyNotesData.notesTitle,
                    notesContent: this.needModifyNotesData.notesContent,
                    formationTime: this.needModifyNotesData.formationTime,
                });
                this.axios({
                    method: 'post',
                    url: '/administrator/modifyNotesInforData',
                    data: postData
                }).then(response =>{
                    if(response.data != ""){
                        this.$message({
                            type: 'success',
                            message: '数据修改成功！'
                        })
                        this.reload()
                    }else{
                        this.$message({
                            type: 'error',
                            message: '数据修改失败！'
                        })
                        this.reload()
                    }
                }).catch(error => {
                    console.log(error)
                })
            }else{
                this.$message({
                    type: 'error',
                    message: '数据必须填写齐全！'
                })
            }
        },  
    },
    components:{
        'v-notesOperationButton': notesOperationButton,
    },
})
</script>

<style scoped>
#anime_table_style{
    position: absolute;
    top: 7%;
    left: 1%;
    width: 98%;
    font-size: 0.9vw;
    border-radius: 15px;
}
#pagination_style{
    position: fixed;
    background-color: cornflowerblue;
    border-radius: 8px;
    top: 15%;
    left: 75%;
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
#dropdown_style{
    font-weight: 900;
    font-size: 1.5vw; 
    font-family: STFangsong;
    border: black 1px solid;
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
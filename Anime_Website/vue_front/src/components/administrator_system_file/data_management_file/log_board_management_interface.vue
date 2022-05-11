<template>
    <div>
        <v-logBoardOperationButton></v-logBoardOperationButton>
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
        <!-- ********************************************************************************************************************* -->
        <div id="pagination_style">
            <el-pagination
            @current-change="handleCurrentChange"
            :page-size="15"
            layout="prev, pager, next, jumper, total"
            :total=totalData>
            </el-pagination>
        </div>
        <!-- ********************************************************************************************************************* -->
        <!-- 修改数据的弹出框 -->
        <!-- <el-dialog title="提示" :visible.sync="modifyWindow" width="35%" :before-close="handleClose" :append-to-body="true">
            <div style="font-family: STFangsong; font-size: 25px; font-weight: 500;">
                音乐名称:&emsp;<input id="all_input_style" type="text" v-model="needModifyMusicData.musicName"></input><br>
                音乐类型:&emsp;<input id="all_input_style" type="text" v-model="needModifyMusicData.musicType"></input><br>
                &emsp;演唱者:&emsp;<input id="all_input_style" type="text" v-model="needModifyMusicData.musicSinger"></input><br>
                推荐指数:&emsp;<el-date-picker style="width: 61%; font-size: 1vw;" type="date" placeholder="选择日期" 
                                size="large" value-format="yyyy-MM-dd" v-model="needModifyAnimeData.animePublishTime"></el-date-picker><br>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="modifyWindow = false">取 消</el-button>
                <el-button type="primary" @click="modifyTableSingleData">确 定</el-button>
            </span>
        </el-dialog>            -->
    </div>    
</template>

<script>
import logBoardOperationButton from '../data_management_file/log_board_operation_button.vue'
export default({
    inject: ['reload'],
    data(){
        return{
            totalData: 0,
            modifyWindow: '',
            perPage: new Array(),
        }
    },
    created(){
        this.axios({
            method: 'post',
            url: '/administrator/getLogBoardData'
        }).then(response =>{
            this.totalData = response.data.length
            this.perPage = response.data.slice(0,15)
        }).catch(error => {
            console.log(error)
        })
    },
    methods:{
        handleCurrentChange(val) {
            this.axios({
                method: 'post',
                url: '/administrator/getLogBoardData'
            }).then(response =>{
                let head = (val-1)*15
                let end = val*15
                this.perPage = response.data.slice(head, end)
            }).catch(error => {
                console.log(error)
            })
        },
    },
    components:{
        'v-logBoardOperationButton': logBoardOperationButton,
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
    left: 63%;
}
</style>
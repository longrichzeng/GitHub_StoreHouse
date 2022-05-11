<template>
    <div>
        <!-- 调用了anime_music_management_interface这个组件，减少了这个文件组件的代码量，便于维护 -->
        <v-animeMusicOperationButton></v-animeMusicOperationButton>
        <!-- ********************************************************************************************************************* -->
        <!-- 展示的数据表格 -->
        <el-table id="anime_table_style" :header-cell-style="{background:'#e9e7ef',color:'#555'}"
                    :cell-style="{background:'#F3F4F7',color:'#343536'}" 
                    :row-style="{height: '0px', padding: '0px'}" size="mini" :data="perPage">
            <el-table-column label="音乐编号" prop="musicNumber" width="220"></el-table-column>
            <el-table-column label="音乐名称" prop="musicName" width="370"></el-table-column>
            <el-table-column label="音乐类型" prop="musicType" width="170"></el-table-column>
            <el-table-column label="演唱者" prop="musicSinger" width="180"></el-table-column>
            <el-table-column label="推荐指数" prop="musicRecommendIndex" width="170"></el-table-column>

            <el-table-column label="删除" width="122">
                <template slot-scope="scope">                        
                    <el-button style="font-size: 2vw" type="text" class="el-icon-delete" @click="deleteTableSingleData(scope.row.musicNumber)"></el-button>                        
                </template>
            </el-table-column>
            <el-table-column label="修改" width="122">
                <template slot-scope="scope">                        
                    <el-button style="font-size: 2vw" type="text" class="el-icon-edit" @click="modifyDataTransferStation(scope.row)"></el-button>                        
                </template>
            </el-table-column>    
        </el-table>  
        <!-- ********************************************************************************************************************* -->
        <!-- 控制分页 -->
        <div id="pagination_style">
            <el-pagination
            @current-change="handleCurrentChange"
            :page-size="8"
            layout="prev, pager, next, jumper, total"
            :total=totalData>
            </el-pagination>
        </div>
        <!-- ********************************************************************************************************************* -->
        <!-- 修改数据的弹出框 -->
        <el-dialog title="提示" :visible.sync="modifyWindow" width="35%" :before-close="handleClose" :append-to-body="true">
            <div style="font-family: STFangsong; font-size: 25px; font-weight: 500;">
                音乐名称:&emsp;<input id="all_input_style" type="text" v-model="needModifyMusicData.musicName"></input><br>
                音乐类型:&emsp;<input id="all_input_style" type="text" v-model="needModifyMusicData.musicType"></input><br>
                &emsp;演唱者:&emsp;<input id="all_input_style" type="text" v-model="needModifyMusicData.musicSinger"></input><br>
                推荐指数:&emsp;<el-dropdown id="dropdown_style" @command="getRecommendIndexToChange">
                            <span class="el-dropdown-link">
                                推荐指数<i class="el-icon-arrow-down el-icon--right"></i>
                            </span>
                            <el-dropdown-menu slot="dropdown">
                                <el-dropdown-item command="1星">1星</el-dropdown-item>
                                <el-dropdown-item command="2星">2星</el-dropdown-item>
                                <el-dropdown-item command="3星">3星</el-dropdown-item>
                                <el-dropdown-item command="4星">4星</el-dropdown-item>
                                <el-dropdown-item command="5星">5星</el-dropdown-item>
                            </el-dropdown-menu>
                        </el-dropdown>{{needModifyMusicData.musicRecommendIndex}}<br>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="modifyWindow = false">取 消</el-button>
                <el-button type="primary" @click="modifyTableSingleData">确 定</el-button>
            </span>
        </el-dialog>      
    </div>    
</template>

<script>
import animeMusicOperationButton from '../anime_management_file/anime_music_operation_button.vue'
export default({
    inject: ['reload'],
    data(){
        return{
            totalData: 0,//anime数据的数量，由此来确定分页的数量
            perPage: new Array(),//定义一个名称为perPage的数组
            modifyWindow: false,//修改弹窗
            needModifyMusicData: {//需要修改的音乐数据
                musicName: '',
                musicType: '',
                musicAuthor: '',
                musicSinger: '',
                musicRecommendIndex: '',
            }            
        }
    },
    created(){
        //通用数据获取，先获取动漫数据，然后截取前五条数据展示到页面
        this.axios({
            method: 'post',
            url: '/administrator/getAnimeMusicData'
        }).then(response =>{
            //把获取到的数据对象长度赋给totalData
            this.totalData = response.data.length
            //把获取到的数据截取前八条数据赋给perPage
            this.perPage = response.data.slice(0,8)
        }).catch(error => {
            console.log(error)
        })
    },
    methods:{
        /**
         * 根据页数找到页数对应的八条数据(已完成)
         */
        handleCurrentChange(val){
            this.axios({
                method: 'post',
                url: '/administrator/getAnimeMusicData'
            }).then(response =>{
                let head = (val-1)*8
                let end = val*8
                this.perPage = response.data.slice(head, end)
            }).catch(error => {
                console.log(error)
            })
        },

        /**
         * 删除一条新的动漫数据(已完成)
         */
        deleteTableSingleData(musicNumber){
            let postData = this.qs.stringify({
                musicNumber: musicNumber,
            });
            this.axios({
                method: 'post',
                url: '/administrator/deleteAnimeMusicData',
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
                    this.reload()
                }
            }).catch(error => {
                console.log(error)
            })            
        },
        
        //将下拉菜单选择的音乐推荐指数数据选项赋值到修改窗口对应的音乐推荐指数上(已完成)
        getRecommendIndexToChange(musicRecommendIndex){
            this.needModifyMusicData.musicRecommendIndex = musicRecommendIndex
        },

        /**
         * 修改一条的音乐数据(已完成)
         */
        modifyTableSingleData(){
            if(this.needModifyMusicData.musicNumber != "" && this.needModifyMusicData.musicName != "" && 
            this.needModifyMusicData.musicType != "" && this.needModifyMusicData.musicSinger != "" && 
            this.needModifyMusicData.musicRecommendIndex != ""){
                let postData = this.qs.stringify({
                    musicNumber: this.needModifyMusicData.musicNumber,
                    musicName: this.needModifyMusicData.musicName,
                    musicType: this.needModifyMusicData.musicType,
                    musicSinger: this.needModifyMusicData.musicSinger,
                    musicRecommendIndex: this.needModifyMusicData.musicRecommendIndex,
                });
                this.axios({
                    method: 'post',
                    url: '/administrator/modifyAnimeMusicData',
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

        /**
         * 作为中转站，将表格现有的数据通过转接的方式呈现在修改窗口上(已完成)
         */
        modifyDataTransferStation(Data){
            this.needModifyMusicData.musicNumber = Data.musicNumber,
            this.needModifyMusicData.musicName = Data.musicName,
            this.needModifyMusicData.musicType = Data.musicType,
            this.needModifyMusicData.musicSinger = Data.musicSinger,
            this.needModifyMusicData.musicRecommendIndex = Data.musicRecommendIndex,
            this.modifyWindow = true
        },
        
        /**
         * 对话框关闭时候的提示(已完成)
         */
        handleClose(done) {
            this.$confirm('确认关闭？').then(_ => {
                done();
            }).catch(_ => {});
        }, 

    },
    components:{
        'v-animeMusicOperationButton': animeMusicOperationButton,
    },
})
</script>

<style scoped>
#anime_table_style{
    position: absolute;
    top: 6.5%;
    left: 1%;
    width: 98%;
    font-size: 1.2vw;
    border-radius: 15px;
}
#pagination_style{
    position: fixed;
    background-color: cornflowerblue;
    border-radius: 8px;
    top: 15%;
    right: 2%;
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
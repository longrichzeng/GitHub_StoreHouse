<template>
    <div>
        <!-- 左边的导航栏部分 -->
        <div id="operationButton_style">
            <el-button id="singel_operationButton_style" class="el-icon-circle-plus-outline" type="success" @click="addWindow = true">添加音乐</el-button>
            <el-button id="singel_operationButton_style" class="el-icon-edit" type="primary" @click="sortWindow = true">音乐分类</el-button>
            <el-button id="singel_operationButton_style" class="el-icon-search" type="danger" @click="searchWindow = true">查找音乐</el-button>
        </div>   
        <!-- ********************************************************************************************************************* -->
        <!-- 添加音乐数据的弹窗 -->
        <el-dialog title="提示" :visible.sync="addWindow" width="35%" :before-close="handleClose" :append-to-body="true">
            <div style="font-family: STFangsong; font-size: 25px; font-weight: 500;">
                音乐名称:&emsp;<input id="all_input_style" type="text" v-model="addMusicData.musicName"></input><br>
                音乐类型:&emsp;<input id="all_input_style" type="text" v-model="addMusicData.musicType"></input><br>
                &emsp;演唱者:&emsp;<input id="all_input_style" type="text" v-model="addMusicData.musicSinger"></input><br>
                推荐指数:&emsp;<el-dropdown id="dropdown_style" @command="getMusicRecommendIndex">
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
                </el-dropdown>&emsp;&emsp;{{addMusicData.musicRecommendIndex}}<br>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="addWindow = false">取 消</el-button>
                <el-button type="primary" @click="addTableSingleData">确 定</el-button>
            </span>
        </el-dialog>
        <!-- ---------------------------------------------------------------------------------------------------------------------- -->
        <!-- 音乐分类的弹窗 -->
        <el-dialog title="根据类别查找音乐信息" :visible.sync="sortWindow" width="49%" height="50%" :before-close="handleClose" :append-to-body="true">
            <p style="font-size: 1.5vw; font-family: STFangsong; font-weight: 900;" v-if="countTip != 0">查询到了{{countTip}}条相关数据！</p>
            <p style="font-size: 1.5vw; font-family: STFangsong; font-weight: 900;" v-if="countTip == 0">查不到相关数据！</p>
            &emsp;<el-dropdown id="dropdown_style" @command="getByMusicIndex" trigger="click">
                <span class="el-dropdown-link">
                    &nbsp;推荐指数<i class="el-icon-arrow-down"></i>&nbsp;
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item command="1星">1星</el-dropdown-item>
                    <el-dropdown-item command="2星">2星</el-dropdown-item>
                    <el-dropdown-item command="3星">3星</el-dropdown-item>
                    <el-dropdown-item command="4星">4星</el-dropdown-item>
                    <el-dropdown-item command="5星">5星</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
            <el-table id="anime_table_style" :header-cell-style="{background:'#e9e7ef',color:'#555'}"
                        :cell-style="{background:'#F3F4F7',color:'#343536'}" 
                        :row-style="{height: '0px', padding: '0px'}" size="mini" :data="perPage">
                <el-table-column label="音乐编号" prop="musicNumber" width="125"></el-table-column>
                <el-table-column label="音乐名称" prop="musicName" width="210"></el-table-column>
                <el-table-column label="音乐类型" prop="musicType" width="90"></el-table-column>
                <el-table-column label="演唱者" prop="musicSinger" width="180"></el-table-column>
                <el-table-column label="推荐指数" prop="musicRecommendIndex" width="80"></el-table-column> 
            </el-table>  
            <span slot="footer" class="dialog-footer">
                <el-button @click="closeWindow">取 消</el-button>
                <el-button type="primary" @click="closeWindow">确 定</el-button>
            </span>
        </el-dialog>   
        <!-- ---------------------------------------------------------------------------------------------------------------------- -->
        <!-- 通过音乐名称查找音乐的弹窗 -->
        <el-dialog title="提示" :visible.sync="searchWindow" width="49%" :before-close="handleClose" :append-to-body="true">
            <el-row>
                <el-col :span="20">
                    <el-input id="all_input_style" placeholder="请输入需要查找的音乐名称" v-model="musicName"></el-input>
                </el-col>
                <el-col :span="2" :offset="1">
                    <el-button type="primary" class="el-icon-search" @click="searchTableSingleData">查找</el-button>
                </el-col>
            </el-row>
            <el-table id="anime_table_style" :header-cell-style="{background:'#e9e7ef',color:'#555'}"
                        :cell-style="{background:'#F3F4F7',color:'#343536'}" 
                        :row-style="{height: '0px', padding: '0px'}" size="mini" :data="perPage">
                <el-table-column label="音乐编号" prop="musicNumber" width="125"></el-table-column>
                <el-table-column label="音乐名称" prop="musicName" width="210"></el-table-column>
                <el-table-column label="音乐类型" prop="musicType" width="90"></el-table-column>
                <el-table-column label="演唱者" prop="musicSinger" width="180"></el-table-column>
                <el-table-column label="推荐指数" prop="musicRecommendIndex" width="80"></el-table-column> 
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
            perPage: new Array(),//定义一个名称为perPage的数组
            addWindow: false,    //添加音乐窗口
            sortWindow: false,   //编辑音乐窗口
            searchWindow: false, //查找音乐窗口
            countTip: 0,//用来接收查询到的数据的数量
            musicName: '',//音乐名称
            addMusicData: {//添加数据的对象
                musicName: '',
                musicType: '',
                musicSinger: '',
                musicRecommendIndex: '',
            }
        }
    },
    created(){
        
    },
    methods:{
        /**
         * 增加一条新的音乐数据(已完成)
         */
        addTableSingleData(){
            if(this.addMusicData.musicName != "" && this.addMusicData.usicType != "" && this.addMusicData.musicSinger != "" &&
                this.addMusicData.musicRecommendIndex != ""){
                let postData = this.qs.stringify({
                    musicNumber: null,
                    musicName: this.addMusicData.musicName,
                    musicType: this.addMusicData.musicType,
                    musicSinger: this.addMusicData.musicSinger,
                    musicRecommendIndex: this.addMusicData.musicRecommendIndex
                });
                this.axios({
                    method: 'post',
                    url: '/administrator/addAnimeMusicData',
                    data: postData
                }).then(response =>{
                    if(response.data != ""){
                        this.$message({
                            type: 'success',
                            message: "数据添加成功！"
                        })
                        this.reload()
                        this.addMusicData = ""
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

        /**
         * 通过音乐名称查找相关对应的音乐数据(已完成)
         */
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

        /** 
         * 通过下拉框选择的音乐推荐指数查找对应的音乐数据(已完成)
        */
        getByMusicIndex(command){
            let postData = this.qs.stringify({
                musicRecommendIndex: command,
            });
            this.axios({
                method: 'post',
                url: '/administrator/getMusicDataByIndex',
                data: postData
            }).then(response =>{
                this.perPage = response.data
                this.countTip = response.data.length
            }).catch(error => {
                console.log(error)
            })
        },

        //通过该方法作为数据中转站
        getMusicRecommendIndex(index){
            this.addMusicData.musicRecommendIndex = index
        },

        //已完成
        handleClose(done) {
            this.$confirm('确认关闭？').then(_ => {
                done();
            }).catch(_ => {});
        },  

        /**
         * 再关闭弹窗后，会将相关的信息清空，弹窗赋值为false从而关闭弹窗(已完成)
         */
        closeWindow(){
            this.perPage = []
            this.sortWindow =  false
            this.searchWindow =  false
            this.musicName = ""
            this.countTip = 0
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
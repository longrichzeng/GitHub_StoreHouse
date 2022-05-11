<template>
    <div>
        <!-- 左边的导航栏部分 -->
        <div id="operationButton_style">
            <el-button id="singel_operationButton_style" class="el-icon-circle-plus-outline" type="success" @click="addWindow = true">添加动漫</el-button>
            <el-button id="singel_operationButton_style" class="el-icon-edit" type="primary" @click="sortWindow = true">动漫分类</el-button>
            <el-button id="singel_operationButton_style" class="el-icon-search" type="danger" @click="searchWindow = true">查找动漫</el-button>
        </div>   
        <!-- ********************************************************************************************************************* -->
        <!-- 添加动漫数据的弹窗 -->
        <el-dialog title="提示" :visible.sync="addWindow" width="35%" :before-close="handleClose" :append-to-body="true">
            <div style="font-family: STFangsong; font-size: 25px; font-weight: 500;">
                动漫名称:&emsp;<input id="all_input_style" type="text" v-model="addAnimeData.animeName"></input><br>
                动漫类型:&emsp;<el-dropdown id="dropdown_style" @command="getAnimeTypeToChange">
                            <span class="el-dropdown-link">
                                动漫类型<i class="el-icon-arrow-down el-icon--right"></i>
                            </span>
                            <el-dropdown-menu slot="dropdown">
                                <el-dropdown-item command="人生感悟">人生感悟</el-dropdown-item>
                                <el-dropdown-item command="魔法世界">魔法世界</el-dropdown-item>
                                <el-dropdown-item command="萝莉废萌">萝莉废萌</el-dropdown-item>
                                <el-dropdown-item command="青春校园">青春校园</el-dropdown-item>
                                <el-dropdown-item command="热血战斗">热血战斗</el-dropdown-item>
                                <el-dropdown-item command="日常搞笑">日常搞笑</el-dropdown-item>
                                <el-dropdown-item command="催泪治愈">催泪治愈</el-dropdown-item>
                            </el-dropdown-menu>
                        </el-dropdown>&emsp;&emsp;{{addAnimeData.animeType}}<br>
                出版作者:&emsp;<input id="all_input_style" type="text" v-model="addAnimeData.animeAuthor"></input><br>
                出版时间:&emsp;<el-date-picker style="width: 61%; font-size: 1vw;" type="date" placeholder="选择日期" 
                                                    size="large" value-format="yyyy-MM-dd" 
                                                    v-model="addAnimeData.animePublishTime"></el-date-picker><br>
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
                        </el-dropdown>&emsp;&emsp;{{addAnimeData.animeRecommendIndex}}<br>
                <el-upload action="" accept="image/*" :on-change="onUploadChange" :auto-upload="false" :show-file-list="true">
                    <el-button id="upload_style" slot="trigger" size="small">动漫封面:&emsp;动漫封面选择</el-button>
                </el-upload>
                动漫介绍:&emsp;<el-input id="all_input_style" type="textarea" v-model="addAnimeData.animeIntroduction"></el-input>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="addWindow = false">取 消</el-button>
                <el-button type="primary" @click="addTableSingleData">确 定</el-button>
            </span>
        </el-dialog>
        <!-- ---------------------------------------------------------------------------------------------------------------------- -->
        <!-- 动漫分类的弹窗，有两个查询条件 -->
        <el-dialog title="根据类别查找动漫信息" :visible.sync="sortWindow" width="90%" height="50%" :before-close="handleClose" :append-to-body="true">
            <p style="font-size: 1.5vw; font-family: STFangsong; font-weight: 900;" v-if="countTip != 0">查询到了{{countTip}}条相关数据！</p>
            <p style="font-size: 1.5vw; font-family: STFangsong; font-weight: 900;" v-if="countTip == 0">查不到相关数据！</p>
            &emsp;<el-dropdown id="dropdown_style" @command="getByAnimeType" trigger="click">
                <span class="el-dropdown-link">
                    &nbsp;动漫类型<i class="el-icon-arrow-down"></i>&nbsp;
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item command="人生感悟">人生感悟</el-dropdown-item>
                    <el-dropdown-item command="魔法世界">魔法世界</el-dropdown-item>
                    <el-dropdown-item command="萝莉废萌">萝莉废萌</el-dropdown-item>
                    <el-dropdown-item command="青春校园">青春校园</el-dropdown-item>
                    <el-dropdown-item command="热血战斗">热血战斗</el-dropdown-item>
                    <el-dropdown-item command="日常搞笑">日常搞笑</el-dropdown-item>
                    <el-dropdown-item command="催泪治愈">催泪治愈</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
            &emsp;<el-dropdown id="dropdown_style" @command="getAnimeRecommendIndex" trigger="click">
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
            <!-- ---------------------------- -->
            <el-table id="anime_table_style" :header-cell-style="{background:'#e9e7ef',color:'#555'}"
                    :cell-style="{background:'#F3F4F7',color:'#343536'}" 
                    :row-style="{height: '', padding: ''}" size="mini" :data="perPage">
                <el-table-column label="动漫编号" prop="animeNumber" width="120"></el-table-column>
                <el-table-column label="动漫名称" prop="animeName" width="160"></el-table-column>
                <el-table-column label="动漫类型" prop="animeType" width="80"></el-table-column>
                <el-table-column label="出版会社" prop="animeAuthor" width="180"></el-table-column>
                <el-table-column label="出版时间" prop="animePublishTime" width="100"></el-table-column>
                <el-table-column label="推荐指数" prop="animeRecommendIndex" width="80"></el-table-column>
                <el-table-column label="动漫介绍" width="580">
                    <template slot-scope="scope">
                        <el-popover :open-delay="500" width="300" size="mini" trigger="hover" placement="top">
                            <p>动漫介绍: {{ scope.row.animeIntroduction }}</p>
                            <div slot="reference" class="name-wrapper">
                                <el-button style="color: black" type="text">{{ scope.row.animeIntroduction }}</el-button>
                            </div>
                        </el-popover>
                    </template>   
                </el-table-column>  
            </el-table>
            <!-- ---------------------------- -->
            <span slot="footer" class="dialog-footer">
                <el-button @click="closeWindow">取 消</el-button>
                <el-button type="primary" @click="closeWindow">确 定</el-button>
            </span>
        </el-dialog>   
        <!-- ---------------------------------------------------------------------------------------------------------------------- -->
        <!-- 通过动漫名称查找动漫的弹窗 -->
        <el-dialog title="提示" :visible.sync="searchWindow" width="90%" :before-close="handleClose" :append-to-body="true">
            <el-row>
                <el-col :span="21">
                    <el-input id="all_input_style" placeholder="请输入需要查找的动漫名称" v-model="animeName"></el-input>
                </el-col>
                <el-col :span="2" :offset="1">
                    <el-button type="primary" class="el-icon-search" @click="searchTableSingleData">查找</el-button>
                </el-col>
            </el-row>
            <el-table id="anime_table_style" :header-cell-style="{background:'#e9e7ef',color:'#555'}"
                    :cell-style="{background:'#F3F4F7',color:'#343536'}" 
                    :row-style="{height: '', padding: ''}" size="mini" :data="perPage">
                <el-table-column label="动漫编号" prop="animeNumber" width="120"></el-table-column>
                <el-table-column label="动漫名称" prop="animeName" width="160"></el-table-column>
                <el-table-column label="动漫类型" prop="animeType" width="80"></el-table-column>
                <el-table-column label="出版会社" prop="animeAuthor" width="180"></el-table-column>
                <el-table-column label="出版时间" prop="animePublishTime" width="100"></el-table-column>
                <el-table-column label="推荐指数" prop="animeRecommendIndex" width="80"></el-table-column>
                <el-table-column label="动漫介绍" width="595">
                    <template slot-scope="scope">
                        <el-popover :open-delay="500" width="300" size="mini" trigger="hover" placement="top">
                            <p>动漫介绍: {{ scope.row.animeIntroduction }}</p>
                            <div slot="reference" class="name-wrapper">
                                <el-button style="color: black" type="text">{{ scope.row.animeIntroduction }}</el-button>
                            </div>
                        </el-popover>
                    </template>   
                </el-table-column>  
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
            addWindow: false,    //添加动漫窗口
            sortWindow: false,   //编辑动漫窗口
            searchWindow: false, //查找动漫窗口
            countTip: 0,  //用来接收查询到的数据的数量
            file: [],//空文件
            animeName: '',   //动漫名称
            addAnimeData: {  //添加数据的对象
                animeNumber: '',
                animeName: '',
                animeType: '',
                animeAuthor: '',
                animePublishTime: '',
                animeRecommendIndex: '',
                animeIntroduction: '',
            }
        }
    },
    created(){
        
    },
    methods:{
        /**
         * 判断待上传的图片大小是否超过1MB(已完成)
         */
        onUploadChange(file) {
            this.file[0] = file;
            const isIMAGE = file.raw.type === "image/png" || file.raw.type === "image/jpg" || file.raw.type === "image/jpeg";
            const isLt1M = file.size / 1024 / 1024 / 1024 < 1;//大小要小于1MB

            if (!isIMAGE) {
                this.$message.error("上传文件只能是图片格式!");
                return false;
            }
            if (!isLt1M) {
                this.$message.error("上传文件大小不能超过 1MB!");
                return false;
            }
        },

        /**
         * 增加一条新的动漫数据(已完成)
         */
        addTableSingleData(){
            if(this.addAnimeData.animeName != "" && this.addAnimeData.animeType != "" && this.addAnimeData.animeAuthor != "" && 
                this.addAnimeData.animePublishTime != "" && this.addAnimeData.animeRecommendIndex != "" && this.addAnimeData.animeIntroduction != ""){
                if (this.file.length == 0) {
                    this.$message({
                        type: "error",
                        message: "您还未选取图片文件！",
                    });
                    return;
                }
                let formData = new FormData();
                formData.append("file", this.file[0].raw);
                formData.append("animeNumber", "");
                formData.append("animeName", this.addAnimeData.animeName);
                formData.append("animeType", this.addAnimeData.animeType);
                formData.append("animeAuthor", this.addAnimeData.animeAuthor);
                formData.append("animePublishTime", this.addAnimeData.animePublishTime);
                formData.append("animeRecommendIndex", this.addAnimeData.animeRecommendIndex);
                formData.append("animeImage", "");
                formData.append("animeIntroduction", this.addAnimeData.animeIntroduction);
                //请求头
                let config = {
                    headers: {
                        "Content-Type": "multipart/form-data",
                    },
                };
                let url = "/administrator/addAnimeDrameData";

                this.axios.post(url, formData, config).
                then((response) => {
                    if(response.data != ""){
                        this.$message({
                            type: "success",
                            message: "动漫数据添加成功！"
                        })
                        this.reload()
                        this.addAnimeData = ""
                    }else{
                        this.$message({
                            type: "error",
                            message: "动漫数据添加失败！"
                        })
                    }
                }).catch((res) => {
                    this.$message({
                        type: "error",
                        message: res
                    })
                });  
            }else{
                this.$message({
                    type: "error",
                    message: "数据必须填写齐全！"
                })
            }        
        },

        /**
         * 通过动漫名称查找相关对应的动漫数据(已完成)
         */
        searchTableSingleData(){
            let postData = this.qs.stringify({
                animeName: this.animeName,
            });
            this.axios({
                method: 'post',
                url: '/administrator/getAnimeAboutName',
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
         * 通过下拉框选择的动漫推荐指数查找对应的动漫数据(已完成)
        */
        getAnimeRecommendIndex(command){
            let postData = this.qs.stringify({
                animeRecommendIndex: command,
            });
            this.axios({
                method: 'post',
                url: '/administrator/getAnimeAboutIndex',
                data: postData
            }).then(response =>{
                this.perPage = response.data
                this.countTip = response.data.length
            }).catch(error => {
                console.log(error)
            })
        },
        
        /**
         * 通过下拉框选择的动漫类型查找对应的动漫数据(已完成)
         */
        getByAnimeType(command){
            let postData = this.qs.stringify({
                animeType: command,
            });
            this.axios({
                method: 'post',
                url: '/administrator/getAnimeAboutType',
                data: postData
            }).then(response =>{
                this.perPage = response.data
                this.countTip = response.data.length
            }).catch(error => {
                console.log(error)
            })
        },

        //数据中转站
        getAnimeTypeToChange(animeType){
            this.addAnimeData.animeType = animeType
        },
        
        //数据中转站
        getRecommendIndexToChange(animeRecommendIndex){
            this.addAnimeData.animeRecommendIndex = animeRecommendIndex
        },

        /**
         * 对话框关闭时候的提示(已完成)
         */
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
            this.animeName = ""
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
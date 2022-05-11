<template>
    <div>
        <div id="operationButton_style">
            <el-button id="singel_operationButton_style" class="el-icon-circle-plus-outline" type="success" @click="addWindow = true">添加景品</el-button>
            <el-button id="singel_operationButton_style" class="el-icon-edit" type="primary" @click="sortWindow = true">景品分类</el-button>
            <el-button id="singel_operationButton_style" class="el-icon-search" type="danger" @click="searchWindow = true">查找景品</el-button>
        </div>   
        <!-- ********************************************************************************************************************* -->
        <el-dialog title="提示" :visible.sync="addWindow" width="35%" :before-close="handleClose" :append-to-body="true">
            <div style="font-family: STFangsong; font-size: 25px; font-weight: 500;">
                景品名称:&emsp;<input id="all_input_style" type="text" v-model="addJinpinData.jinPinName"></input><br>
                景品类型:&emsp;<input id="all_input_style" type="text" v-model="addJinpinData.jinPinType"></input><br>
                制作会社:&emsp;<input id="all_input_style" type="text" v-model="addJinpinData.jinPinManufacturer"></input><br>
                景品价格:&emsp;<input id="all_input_style" type="text" v-model="addJinpinData.jinPinPrice"></input><br>
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
                        </el-dropdown>&emsp;{{addJinpinData.jinPinRecommendIndex}}<br>
                <el-upload action="" accept="image/*" :on-change="onUploadChange" :auto-upload="false" :show-file-list="true">
                    <el-button id="upload_style" slot="trigger" size="small">景品图片:&emsp;景品图片选择</el-button>
                </el-upload>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="addWindow = false">取 消</el-button>
                <el-button type="primary" @click="addTableSingleData">确 定</el-button>
            </span>
        </el-dialog>   
        <!-- ---------------------------------------------------------------------------------------------------------------------- -->
        <el-dialog title="根据类别查找景品信息" :visible.sync="sortWindow" width="70%" height="50%" :before-close="handleClose" :append-to-body="true">
            <p style="font-size: 1.5vw; font-family: STFangsong; font-weight: 900;" v-if="countTip != 0">查询到了{{countTip}}条相关数据！</p>
            <p style="font-size: 1.5vw; font-family: STFangsong; font-weight: 900;" v-if="countTip == 0">查不到相关数据！</p>
            &emsp;<el-dropdown id="dropdown_style" @command="getJinpinRecommendIndex" trigger="click">
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
                    :row-style="{height: '', padding: ''}" size="mini" :data="perPage">
                <el-table-column label="景品编号" prop="jinPinNumber" width="180"></el-table-column>
                <el-table-column label="景品名称" prop="jinPinName" width="160"></el-table-column>
                <el-table-column label="景品类型" prop="jinPinType" width="180"></el-table-column>
                <el-table-column label="制作会社" prop="jinPinManufacturer" width="180"></el-table-column>
                <el-table-column label="景品价格" prop="jinPinPrice" width="150"></el-table-column>
                <el-table-column label="推荐指数" prop="jinPinRecommendIndex" width="150"></el-table-column>
            </el-table>
            <span slot="footer" class="dialog-footer">
                <el-button @click="closeWindow">取 消</el-button>
                <el-button type="primary" @click="closeWindow">确 定</el-button>
            </span>
        </el-dialog>   
        <!-- ---------------------------------------------------------------------------------------------------------------------- -->
        <el-dialog title="提示" :visible.sync="searchWindow" width="70%" :before-close="handleClose" :append-to-body="true">
            <el-row>
                <el-col :span="21">
                    <el-input id="all_input_style" placeholder="请输入需要查找的景品名称" v-model="jinpinName"></el-input>
                </el-col>
                <el-col :span="2" :offset="1">
                    <el-button type="primary" class="el-icon-search" @click="searchTableSingleData">查找</el-button>
                </el-col>
            </el-row>
            <el-table id="anime_table_style" :header-cell-style="{background:'#e9e7ef',color:'#555'}"
                    :cell-style="{background:'#F3F4F7',color:'#343536'}" 
                    :row-style="{height: '', padding: ''}" size="mini" :data="perPage">
                <el-table-column label="景品编号" prop="jinPinNumber" width="180"></el-table-column>
                <el-table-column label="景品名称" prop="jinPinName" width="160"></el-table-column>
                <el-table-column label="景品类型" prop="jinPinType" width="180"></el-table-column>
                <el-table-column label="制作会社" prop="jinPinManufacturer" width="180"></el-table-column>
                <el-table-column label="景品价格" prop="jinPinPrice" width="150"></el-table-column>
                <el-table-column label="推荐指数" prop="jinPinRecommendIndex" width="150"></el-table-column>
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
            addWindow: false,    //添加动漫窗口
            sortWindow: false,   //编辑动漫窗口
            searchWindow: false, //查找动漫窗口
            countTip: 0,
            file: [],
            jinpinName: '',
            addJinpinData: {
                jinPinNumber: '',
                jinPinName: '',
                jinPinType: '',
                jinPinManufacturer: '',
                jinPinPrice: '',
                jinPinRecommendIndex: '',
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

        //已完成
        getJinpinRecommendIndex(command){
            this.addJinpinData.jinPinRecommendIndex = command
        },

        /**
         * 增加一条新的动漫数据(已完成)
         */
        addTableSingleData(){
            if(this.addJinpinData.jinPinName != "" && this.addJinpinData.jinPinType != "" && 
            this.addJinpinData.jinPinManufacturer != "" && this.addJinpinData.jinPinPrice != "" && 
            this.addJinpinData.jinPinRecommendIndex != ""){
                if (this.file.length == 0) {
                    this.$message({
                        type: "error",
                        message: "您还未选取图片文件！",
                    });
                    return;
                }
                let formData = new FormData();
                formData.append("file", this.file[0].raw);
                formData.append("jinPinName", this.addJinpinData.jinPinName);
                formData.append("jinPinType", this.addJinpinData.jinPinType);
                formData.append("jinPinManufacturer", this.addJinpinData.jinPinManufacturer);
                formData.append("jinPinPrice", this.addJinpinData.jinPinPrice);
                formData.append("jinPinRecommendIndex", this.addJinpinData.jinPinRecommendIndex);
                //请求头
                let config = {
                    headers: {
                        "Content-Type": "multipart/form-data",
                    },
                };
                let url = "/administrator/addJinpinModelData";

                this.axios.post(url, formData, config).
                then((response) => {
                    if(response.data != ""){
                        this.$message({
                            type: "success",
                            message: "音乐数据添加成功！"
                        })
                        this.reload()
                        this.addAnimeData = ""
                        this.addWindow = false
                    }else{
                        this.$message({
                            type: "error",
                            message: "音乐数据添加失败！"
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
         * 查找一条新的动漫数据(已完成)
         */
        searchTableSingleData(){
            let postData = this.qs.stringify({
                jinPinName: this.jinpinName,
            });
            this.axios({
                method: 'post',
                url: '/administrator/getJinpinDataByName',
                data: postData
            }).then(response =>{
                if(response.data.length != 0){
                    this.perPage = response.data
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

        getJinpinRecommendIndex(command){
            let postData = this.qs.stringify({
                jinPinRecommendIndex: command,
            });
            this.axios({
                method: 'post',
                url: '/administrator/getJinpinDataByIndex',
                data: postData
            }).then(response =>{
                this.perPage = response.data
                this.countTip = response.data.length
            }).catch(error => {
                console.log(error)
            })
        },

        //数据中转站
        getRecommendIndexToChange(jinPinRecommendIndex){
            this.addJinpinData.jinPinRecommendIndex = jinPinRecommendIndex
        },

        /**
         * 将下拉框选择的动漫类型进行中转站赋值(已完成)
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
            this.jinpinName = ""
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
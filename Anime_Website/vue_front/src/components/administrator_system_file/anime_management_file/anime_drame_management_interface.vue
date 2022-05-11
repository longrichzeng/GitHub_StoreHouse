<template>
    <div>
        <!-- 调用了anime_drame_management_interface这个组件，减少了这个文件组件的代码量，便于维护 -->
        <v-animeDrameOperationButton></v-animeDrameOperationButton>
        <!-- ********************************************************************************************************************* -->
        <!-- 展示的数据表格 -->
        <el-table id="anime_table_style" :header-cell-style="{background:'#e9e7ef',color:'#555'}"
                    :cell-style="{background:'#F3F4F7',color:'#343536'}" 
                    :row-style="{height: '80px', padding: '50px'}" size="mini" :data="perPage">
            <el-table-column label="动漫编号" prop="animeNumber" width="120"></el-table-column>
            <el-table-column label="动漫名称" prop="animeName" width="160"></el-table-column>
            <el-table-column label="动漫类型" prop="animeType" width="80"></el-table-column>
            <el-table-column label="出版会社" prop="animeAuthor" width="180"></el-table-column>
            <el-table-column label="出版时间" prop="animePublishTime" width="100"></el-table-column>
            <el-table-column label="推荐指数" prop="animeRecommendIndex" width="80"></el-table-column>
            <el-table-column label="动漫图片" prop="animeNumber" width="100">
                <template slot-scope="scope">            
                    <img :src="require('../../../assets/animeImage/' + scope.row.animeNumber + '.png')" height="90" />
                </template>
                </el-table-column>
            <el-table-column label="动漫介绍" width="420">
                <template slot-scope="scope">
                    <el-popover :open-delay="500" width="300" size="mini" trigger="hover" placement="top">
                        <p>动漫介绍: {{ scope.row.animeIntroduction }}</p>
                        <div slot="reference" class="name-wrapper">
                            <el-button style="color: black" type="text">{{ scope.row.animeIntroduction }}</el-button>
                        </div>
                    </el-popover>
                </template>   
            </el-table-column>
            <el-table-column label="删除" width="55">
                <template slot-scope="scope">                        
                    <el-button style="font-size: 1.5vw" type="text" class="el-icon-delete" @click="deleteTableSingleData(scope.row.animeNumber)"></el-button>                        
                </template>
            </el-table-column>
            <el-table-column label="修改" width="55">
                <template slot-scope="scope">                        
                    <el-button style="font-size: 1.5vw" type="text" class="el-icon-edit" @click="dataTransferStation(scope.row)"></el-button>                        
                </template>
            </el-table-column>    
        </el-table>  
        <!-- ********************************************************************************************************************* -->
        <!-- 控制分页 -->
        <div id="pagination_style">
            <el-pagination
            @current-change="handleCurrentChange"
            :page-size="5"
            layout="prev, pager, next, jumper, total"
            :total=totalData>
            </el-pagination>
        </div>
        <!-- ********************************************************************************************************************* -->
        <!-- 修改数据的弹出框 -->
        <el-dialog title="提示" :visible.sync="modifyWindow" width="35%" :before-close="handleClose" :append-to-body="true">
            <div style="font-family: STFangsong; font-size: 25px; font-weight: 500;">
                动漫名称:&emsp;<input id="all_input_style" type="text" v-model="needModifyAnimeData.animeName"></input><br>
                动漫类型:&emsp;<el-dropdown id="dropdown_style" @command="getAnimeTypeToChange" v-model="needModifyAnimeData.animeType">
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
                        </el-dropdown>{{needModifyAnimeData.animeType}}<br>
                出版作者:&emsp;<input id="all_input_style" type="text" v-model="needModifyAnimeData.animeAuthor"></input><br>
                出版时间:&emsp;<el-date-picker style="width: 61%; font-size: 1vw;" type="date" placeholder="选择日期" 
                                size="large" value-format="yyyy-MM-dd" v-model="needModifyAnimeData.animePublishTime"></el-date-picker><br>
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
                        </el-dropdown>{{needModifyAnimeData.animeRecommendIndex}}<br>
                <el-upload action="" accept="image/*" :on-change="onUploadChange" :auto-upload="false" :show-file-list="true">
                    <el-button id="upload_style" slot="trigger" size="small">动漫封面:&emsp;动漫封面选择</el-button>
                </el-upload>
                动漫介绍:&emsp;<el-input id="all_input_style" type="textarea" v-model="needModifyAnimeData.animeIntroduction"></el-input>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="modifyWindow = false">取 消</el-button>
                <el-button type="primary" @click="modifyTableSingleData">确 定</el-button>
            </span>
        </el-dialog>      
    </div>    
</template>

<script>
import animeDrameOperationButton from '../anime_management_file/anime_drame_operation_button.vue'
export default({
    inject: ['reload'],
    data(){
        return{
            totalData: 0,//anime数据的数量，由此来确定分页的数量
            perPage: new Array(),//定义一个名称为perPage的数组
            modifyWindow: false,//修改弹窗
            textarea: '',//文本数据
            file: [],     //空文件
            needModifyAnimeData: {  //需要修改的动漫数据
                animeName: '',                //动漫名称
                animeType: '',                //动漫类型
                animeAuthor: '',              //动漫作者
                animePublishTime: '',         //动漫出版时间
                animeRecommendIndex: '',      //动漫推荐指数
                animeIntroduction: '',        //动漫简介
            }            
        }
    },
    created(){
        //通用数据获取，先获取动漫数据，然后截取前五条数据展示到页面
        this.axios({
            method: 'post',
            url: '/administrator/getAnimeDrameData'
        }).then(response =>{
            //把获取到的数据对象长度赋给totalData
            this.totalData = response.data.length
            //把获取到的数据截取前五条数据赋给perPage
            this.perPage = response.data.slice(0,5)
        }).catch(error => {
            console.log(error)
        })
    },
    methods:{
        /**
         * 根据页数找到页数对应的五条数据(已完成)
         */
        handleCurrentChange(val) {
            this.axios({
                method: 'post',
                url: '/administrator/getAnimeDrameData'
            }).then(response =>{
                //根据页数计算出这个页数对应的数量区间，比如第一页的区间就是[0,5]、第二页是[5,10]、第三页是[10,15]、第四页是[15,20]
                let head = (val-1)*5
                let end = val*5
                this.perPage = response.data.slice(head, end)
            }).catch(error => {
                console.log(error)
            })
        },

        /**
         * 删除一条新的动漫数据(已完成)
         */
        deleteTableSingleData(number){
            let postData = this.qs.stringify({
                animeNumber: number,
            });
            this.axios({
                method: 'post',
                url: '/administrator/deleteAnimeDrameData',
                data: postData
            }).then(response =>{
                //如果后端反馈有数据的话，则提示删除成功，否则删除失败
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

        /**
         * 作为中转站，将表格现有的数据通过转接的方式呈现在修改窗口上(已完成)
         */
        dataTransferStation(animeData){
            //使窗口弹出
            this.modifyWindow = true
            //将表格现有的数据通过转接的方式呈现在修改窗口上
            this.needModifyAnimeData.animeNumber = animeData.animeNumber,
            this.needModifyAnimeData.animeName = animeData.animeName,
            this.needModifyAnimeData.animeType = animeData.animeType,
            this.needModifyAnimeData.animeAuthor = animeData.animeAuthor,
            this.needModifyAnimeData.animePublishTime = animeData.animePublishTime,
            this.needModifyAnimeData.animeRecommendIndex = animeData.animeRecommendIndex,
            this.needModifyAnimeData.animeIntroduction = animeData.animeIntroduction
        },

        //将下拉菜单选择的动漫类型数据选项赋值到修改窗口对应的动漫类型上(已完成)
        getAnimeTypeToChange(animeType){
            this.needModifyAnimeData.animeType = animeType
        },
        
        //将下拉菜单选择的动漫推荐指数数据选项赋值到修改窗口对应的动漫推荐指数上(已完成)
        getRecommendIndexToChange(animeRecommendIndex){
            this.needModifyAnimeData.animeRecommendIndex = animeRecommendIndex
        },

        /**
         * 修改一条新的动漫数据(已完成)
         */
        modifyTableSingleData(){
            //先判定修改的数据填写框内的数据是否为空，是则提示警告，否则执行下一步
            if(this.needModifyAnimeData.animeName != "" && this.needModifyAnimeData.animeType != "" && 
               this.needModifyAnimeData.animeAuthor != "" && this.needModifyAnimeData.animePublishTime != "" && 
               this.needModifyAnimeData.animeRecommendIndex != "" && this.needModifyAnimeData.animeIntroduction != ""){
                //如果file(存储文件的数据)为空，则提示还未选择图片
                if (this.file.length == 0) {    
                    this.$confirm('您还未选取图片文件！', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {//无需反馈
                    }).catch(() => {//无需反馈
                    });
                }else{
                    //不为空则执行修改数据
                    this.modifyDataTransferStation()
                }
            }else{
                this.$message({
                    type: "error",
                    message: "数据必须填写齐全！"
                })
            }   
        },  

        /**
         * 修改代码数据中转站这个方法只是为了减少上面方法的代码量，便于维护(已完成)
         */
        modifyDataTransferStation(){
            //创建一个空对象实例
            let formData = new FormData();
            //在这个空对象上添加数据
            formData.append("file", this.file[0].raw);
            formData.append("animeNumber", this.needModifyAnimeData.animeNumber);
            formData.append("animeName", this.needModifyAnimeData.animeName);
            formData.append("animeType", this.needModifyAnimeData.animeType);
            formData.append("animeAuthor", this.needModifyAnimeData.animeAuthor);
            formData.append("animePublishTime", this.needModifyAnimeData.animePublishTime);
            formData.append("animeRecommendIndex", this.needModifyAnimeData.animeRecommendIndex);
            formData.append("animeIntroduction", this.needModifyAnimeData.animeIntroduction);
            //请求头
            let config = {
                headers: {
                    "Content-Type": "multipart/form-data",
                },
            };
            let url = "/administrator/modifyAnimeDrameData";

            this.axios.post(url, formData, config).
            then((response) => {
                if(response.data != ""){
                    this.$message({
                        type: "success",
                        message: "动漫数据修改成功！"
                    })
                    this.reload()
                    this.modifyWindow = ""
                }else{
                    this.$message({
                        type: "error",
                        message: "动漫数据修改失败！"
                    })
                }
            }).catch((res) => {
                this.$message({
                    type: "error",
                    message: res
                })
            }); 
        },

        /**
         * 判断图片是否小于1MB(已完成)
         */
        onUploadChange(file) {
            this.file[0] = file;
            const isIMAGE = file.raw.type === "image/png" || file.raw.type === "image/jpg" || file.raw.type === "image/jpeg";
            const isLt1M = file.size / 1024 / 1024 / 1024 < 1;//大小要小于10MB

            if (!isIMAGE) {
                this.$message.error("上传文件只能是图片格式!");
                return false;
            }
            if (!isLt1M) {
                this.$message.error("上传文件大小不能超过 10MB!");
                return false;
            }
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
        'v-animeDrameOperationButton': animeDrameOperationButton,
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
    left: 68%;
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
<template>
    <div>
        <v-jinpinModelOperationButton></v-jinpinModelOperationButton>
        <!-- ********************************************************************************************************************* -->
        <el-table id="anime_table_style" :header-cell-style="{background:'#e9e7ef',color:'#555'}"
                    :cell-style="{background:'#F3F4F7',color:'#343536'}" 
                    :row-style="{height: '80px', padding: '50px'}" size="mini" :data="perPage">
            <el-table-column label="景品编号" prop="jinPinNumber" width="180"></el-table-column>
            <el-table-column label="景品名称" prop="jinPinName" width="160"></el-table-column>
            <el-table-column label="景品类型" prop="jinPinType" width="180"></el-table-column>
            <el-table-column label="制作会社" prop="jinPinManufacturer" width="180"></el-table-column>
            <el-table-column label="景品价格" prop="jinPinPrice" width="150"></el-table-column>
            <el-table-column label="推荐指数" prop="jinPinRecommendIndex" width="150"></el-table-column>
            <el-table-column label="景品图片" width="150">
                <template slot-scope="scope">            
                    <img :src="require('../../../assets/jinpinImage/' + scope.row.jinPinNumber + '.png')" height="90" />
                </template>
            </el-table-column>
            <el-table-column label="删除" width="100">
                <template slot-scope="scope">                        
                    <el-button style="font-size: 1.5vw" type="text" class="el-icon-delete" @click="deleteTableSingleData(scope.row.jinPinNumber)"></el-button>                        
                </template>
            </el-table-column>
            <el-table-column label="修改" width="100">
                <template slot-scope="scope">                        
                    <el-button style="font-size: 1.5vw" type="text" class="el-icon-edit" @click="dataTransferStation(scope.row)"></el-button>                        
                </template>
            </el-table-column>    
        </el-table>  
        <!-- ********************************************************************************************************************* -->
        <div id="pagination_style">
            <el-pagination
            @current-change="handleCurrentChange"
            :page-size="5"
            layout="prev, pager, next, jumper, total"
            :total=totalData>
            </el-pagination>
        </div>
        <!-- ********************************************************************************************************************* -->
        <el-dialog title="提示" :visible.sync="modifyWindow" width="35%" :before-close="handleClose" :append-to-body="true">
            <div style="font-family: STFangsong; font-size: 25px; font-weight: 500;">
                景品编号:&emsp;<input id="all_input_style" type="text" v-model="needModifyJinpinData.jinPinNumber"></input><br>
                景品名称:&emsp;<input id="all_input_style" type="text" v-model="needModifyJinpinData.jinPinName"></input><br>
                景品类型:&emsp;<input id="all_input_style" type="text" v-model="needModifyJinpinData.jinPinType"></input><br>
                制作会社:&emsp;<input id="all_input_style" type="text" v-model="needModifyJinpinData.jinPinManufacturer"></input><br>
                景品价格:&emsp;<input id="all_input_style" type="text" v-model="needModifyJinpinData.jinPinPrice"></input><br>
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
                        </el-dropdown>{{needModifyJinpinData.jinPinRecommendIndex}}<br>
                <el-upload action="" accept="image/*" :on-change="onUploadChange" :auto-upload="false" :show-file-list="true">
                    <el-button id="upload_style" slot="trigger" size="small">景品图片:&emsp;景品图片选择</el-button>
                </el-upload>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="modifyWindow = false">取 消</el-button>
                <el-button type="primary" @click="modifyDataTransferStation">确 定</el-button>
            </span>
        </el-dialog>      
    </div>    
</template>

<script>
import jinpinModelOperationButton from '../anime_management_file/jinpin_model_operation_button.vue'
export default({
    inject: ['reload'],
    data(){
        return{
            totalData: 0,
            perPage: new Array(),
            modifyWindow: false,
            file: [],         
            needModifyJinpinData: {
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
        this.axios({
            method: 'post',
            url: '/administrator/getJinpinModelData'
        }).then(response =>{
            this.totalData = response.data.length
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
                url: '/administrator/getJinpinModelData'
            }).then(response =>{
                let head = (val-1)*5
                let end = val*5
                this.perPage = response.data.slice(head, end)
            }).catch(error => {
                console.log(error)
            })
        },

        /**
         * 删除一条新的景品数据(已完成)
         */
        deleteTableSingleData(number){
            let postData = this.qs.stringify({
                jinPinNumber: number,
            });
            this.axios({
                method: 'post',
                url: '/administrator/deleteJinpinModelData',
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

        /**
         * 作为中转站，将表格现有的数据通过转接的方式呈现在修改窗口上(已完成)
         */
        dataTransferStation(animeData){
            this.modifyWindow = true
            this.needModifyJinpinData.jinPinNumber = animeData.jinPinNumber,
            this.needModifyJinpinData.jinPinName = animeData.jinPinName,
            this.needModifyJinpinData.jinPinType = animeData.jinPinType,
            this.needModifyJinpinData.jinPinManufacturer = animeData.jinPinManufacturer,
            this.needModifyJinpinData.jinPinPrice = animeData.jinPinPrice,
            this.needModifyJinpinData.jinPinRecommendIndex = animeData.jinPinRecommendIndex
        },
        
        //(已完成)
        getRecommendIndexToChange(jinPinRecommendIndex){
            this.needModifyJinpinData.jinPinRecommendIndex = jinPinRecommendIndex
        },

        /**
         * 修改一条新的动漫数据(已完成)
         */
        modifyTableSingleData(){
            if(this.needModifyAnimeData.animeName != "" && 
                this.needModifyAnimeData.animeType != "" && 
                this.needModifyAnimeData.animeAuthor != "" && 
                this.needModifyAnimeData.animePublishTime != "" && 
                this.needModifyAnimeData.animeRecommendIndex != "" && 
                this.needModifyAnimeData.animeIntroduction != ""){
                if (this.file.length == 0) {    
                    this.$confirm('您还未选取图片文件！', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                    }).then(() => {
                    }).catch(() => {        
                    });
                }else{
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
         * 只是为了减少上面方法的代码量，便于维护(已完成)
         */
        modifyDataTransferStation(){
            let formData = new FormData();
            formData.append("file", this.file[0].raw);
            formData.append("jinPinNumber", this.needModifyJinpinData.jinPinNumber);
            formData.append("jinPinName", this.needModifyJinpinData.jinPinName);
            formData.append("jinPinType", this.needModifyJinpinData.jinPinType);
            formData.append("jinPinManufacturer", this.needModifyJinpinData.jinPinManufacturer);
            formData.append("jinPinPrice", this.needModifyJinpinData.jinPinPrice);
            formData.append("jinPinRecommendIndex", this.needModifyJinpinData.jinPinRecommendIndex);
            //请求头
            let config = {
                headers: {
                    "Content-Type": "multipart/form-data",
                },
            };
            let url = "/administrator/modifyJinpinModelData";

            this.axios.post(url, formData, config).
            then((response) => {
                if(response.data != ""){
                    this.$message({
                        type: "success",
                        message: "音乐数据修改成功！"
                    })
                    this.reload()
                    this.modifyWindow = ""
                }else{
                    this.$message({
                        type: "error",
                        message: "音乐数据修改失败！"
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
        'v-jinpinModelOperationButton': jinpinModelOperationButton,
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
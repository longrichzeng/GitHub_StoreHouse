<template>
    <div>
        <v-userInforOperationButton></v-userInforOperationButton>
        <el-table id="anime_table_style" :header-cell-style="{background:'#e9e7ef',color:'#555'}"
                    :cell-style="{background:'#F3F4F7',color:'#343536'}" 
                    :row-style="{height: '75px', padding: '50px'}" size="mini" :data="userInfor">
            <el-table-column label="用户昵称" prop="username" width="120"></el-table-column>
            <el-table-column label="用户密码" prop="password" width="340"></el-table-column>
            <el-table-column label="加密盐巴" prop="salt" width="140"></el-table-column>
            <el-table-column label="用户姓名" prop="name" width="110"></el-table-column>
            <el-table-column label="手机号码" prop="phone" width="130"></el-table-column>
            <el-table-column label="用户邮箱" prop="email" width="235"></el-table-column>
            <el-table-column label="用户身份" prop="userPermission" width="150"></el-table-column>
            <el-table-column label="删除" width="65">
                <template slot-scope="scope">                        
                    <el-button style="font-size: 1.5vw" type="text" class="el-icon-delete" @click="deleteTableSingleData(scope.row.username, scope.row.phone)"></el-button>                        
                </template>
            </el-table-column>
            <el-table-column label="修改" width="65">
                <template slot-scope="scope">                        
                    <el-button style="font-size: 1.5vw" type="text" class="el-icon-edit" @click="modifyDataTransferStation(scope.row)"></el-button>                        
                </template>
            </el-table-column>    
        </el-table>  
        <!-- ********************************************************************************************************************* -->
        <!-- 控制分页 -->
        <div id="pagination_style">
            <el-pagination
            @current-change="handleCurrentChange"
            :page-size="7"
            layout="prev, pager, next, jumper, total"
            :total=totalData>
            </el-pagination>
        </div>
        <!-- ********************************************************************************************************************* -->
        <el-dialog title="提示" :visible.sync="modifyWindow" width="35%" :before-close="handleClose" :append-to-body="true">
            <div style="font-family: STFangsong; font-size: 25px; font-weight: 500;">
                用户昵称:&emsp;<input id="all_input_style" type="text" v-model="needModifyUserData.username"></input><br>
                用户密码:&emsp;<input id="all_input_style" type="text" v-model="needModifyUserData.password"></input><br>
                用户姓名:&emsp;<input id="all_input_style" type="text" v-model="needModifyUserData.name"></input><br>
                手机号码:&emsp;<input id="all_input_style" type="text" v-model="needModifyUserData.phone"></input><br>
                用户邮箱:&emsp;<input id="all_input_style" type="text" v-model="needModifyUserData.email"></input><br>
                用户身份:&emsp;<el-dropdown id="dropdown_style" @command="getUserPermission">
                    <span class="el-dropdown-link">
                        用户身份<i class="el-icon-arrow-down el-icon--right"></i>
                    </span>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item command="Zeroer">Zeroer</el-dropdown-item>
                        <el-dropdown-item command="GeneralUser">GeneralUser</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>&emsp;&emsp;{{needModifyUserData.userPermission}}<br>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="modifyWindow = false">取 消</el-button>
                <el-button type="primary" @click="modifyTableSingleData">确 定</el-button>
            </span>
        </el-dialog> 
    </div>    
</template>

<script>
import userInforOperationButton from '../user_management_file/user_infor_operation_button.vue'
export default({
    inject: ['reload'],
    data(){
        return{
            totalData: 0,//anime数据的数量，由此来确定分页的数量
            userInfor: new Array(),//定义一个名称为perPage的数组
            modifyWindow: false,//修改弹窗
            needModifyUserData: {  //需要修改的用户数据
                username: '',
                password: '',
                salt: '',
                name: '',
                phone: '',
                email: '',
                userPermission: ''
            }               
        }
    },
    created(){
        this.axios({
            method: 'post',
            url: '/administrator/getUserInforData'
        }).then(response =>{
            this.userInfor = response.data.slice(0,7)
            this.totalData = response.data.length
        }).catch(error => {
            console.log(error)
        })
    },
    methods:{
        //已完成
        handleCurrentChange(val) {
            this.axios({
                method: 'post',
                url: '/administrator/getUserInforData'
            }).then(response =>{
                let head = (val-1)*7
                let end = val*7
                this.userInfor = response.data.slice(head, end)
            }).catch(error => {
                console.log(error)
            })
        },

        //已完成
        deleteTableSingleData(name, phone){
            let postData = this.qs.stringify({
                username: name,
                phone: phone,
            });
            this.axios({
                method: 'post',
                url: '/administrator/deleteUserInforData',
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
        
        //用户权限数据中转站
        getUserPermission(userPermission){
            this.needModifyUserData.userPermission = userPermission
        },

        modifyDataTransferStation(Data){
            this.needModifyUserData.username = Data.username,
            this.needModifyUserData.password = Data.password,
            this.needModifyUserData.salt = Data.salt,
            this.needModifyUserData.name = Data.name,
            this.needModifyUserData.phone = Data.phone,
            this.needModifyUserData.email = Data.email,
            this.needModifyUserData.userPermission = Data.userPermission,
            this.modifyWindow = true
        },

        modifyTableSingleData(){
            if(this.needModifyUserData.username != "" && this.needModifyUserData.password != "" && 
               this.needModifyUserData.name != "" && this.needModifyUserData.phone != "" && 
               this.needModifyUserData.email != "" && this.needModifyUserData.userPermission != ""){
                let postData = this.qs.stringify({
                    username: this.needModifyUserData.username,
                    password: this.needModifyUserData.password,
                    salt: "",
                    name: this.needModifyUserData.name,
                    phone: this.needModifyUserData.phone,
                    email: this.needModifyUserData.email,
                    userPermission: this.needModifyUserData.userPermission,
                })
                this.axios({
                    method: 'post',
                    url: '/administrator/modifyUserInforData',
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
        'v-userInforOperationButton': userInforOperationButton,
    },
})
</script>

<style scoped>
#anime_table_style{
    position: absolute;
    top: 7%;
    left: 1%;
    width: 98%;
    font-size: 1.3vw;
    border-radius: 15px;
    font-family: STFangsong;
    font-weight: 900;
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
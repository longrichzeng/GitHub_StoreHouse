<template>
    <div>
        <!-- 左边的导航栏部分 -->
        <div id="operationButton_style">
            <el-button id="singel_operationButton_style" class="el-icon-circle-plus-outline" type="success" @click="addWindow = true">添加用户</el-button>
            <el-button id="singel_operationButton_style" class="el-icon-edit" type="primary" @click="sortWindow = true">用户分类</el-button>
            <el-button id="singel_operationButton_style" class="el-icon-search" type="danger" @click="searchWindow = true">查找用户</el-button>
        </div>   
        <!-- ********************************************************************************************************************* -->
        <el-dialog title="提示" :visible.sync="addWindow" width="35%" :before-close="handleClose" :append-to-body="true">
            <div style="font-family: STFangsong; font-size: 25px; font-weight: 500;">
                用户昵称:&emsp;<input id="all_input_style" type="text" v-model="addUserData.username"></input><br>
                用户密码:&emsp;<input id="all_input_style" type="text" v-model="addUserData.password"></input><br>
                用户姓名:&emsp;<input id="all_input_style" type="text" v-model="addUserData.name"></input><br>
                手机号码:&emsp;<input id="all_input_style" type="text" v-model="addUserData.phone"></input><br>
                用户邮箱:&emsp;<input id="all_input_style" type="text" v-model="addUserData.email"></input><br>
                用户身份:&emsp;<el-dropdown id="dropdown_style" @command="getUserPermission">
                    <span class="el-dropdown-link">
                        用户身份<i class="el-icon-arrow-down el-icon--right"></i>
                    </span>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item command="Zeroer">Zeroer</el-dropdown-item>
                        <el-dropdown-item command="GeneralUser">GeneralUser</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>&emsp;&emsp;{{addUserData.userPermission}}<br>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="addWindow = false">取 消</el-button>
                <el-button type="primary" @click="addTableSingleData">确 定</el-button>
            </span>
        </el-dialog>
        <!-- ---------------------------------------------------------------------------------------------------------------------- -->
        <el-dialog title="根据类别查找用户信息" :visible.sync="sortWindow" width="90%" height="50%" :before-close="handleClose" :append-to-body="true">
            <p style="font-size: 1.5vw; font-family: STFangsong; font-weight: 900;" v-if="countTip != 0">查询到了{{countTip}}条相关数据！</p>
            <p style="font-size: 1.5vw; font-family: STFangsong; font-weight: 900;" v-if="countTip == 0">查不到相关数据！</p>
            <el-dropdown id="dropdown_style" @command="getUserInforByUserPermission">
                <span class="el-dropdown-link">
                    用户身份<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item command="Zeroer">Zeroer</el-dropdown-item>
                    <el-dropdown-item command="GeneralUser">GeneralUser</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown><br>
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
            </el-table>  
            <span slot="footer" class="dialog-footer">
                <el-button @click="closeWindow">取 消</el-button>
                <el-button type="primary" @click="closeWindow">确 定</el-button>
            </span>
        </el-dialog>   
        <!-- ---------------------------------------------------------------------------------------------------------------------- -->
        <el-dialog title="提示" :visible.sync="searchWindow" width="90%" :before-close="handleClose" :append-to-body="true">
            <el-row>
                <el-col :span="4">
                <el-dropdown id="dropdown_style" @command="getUserInforByUserUploadType">
                    <span class="el-dropdown-link">
                        用户身份<i class="el-icon-arrow-down el-icon--right"></i>
                    </span>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item command="name">用户名称</el-dropdown-item>
                        <el-dropdown-item command="phone">手机号码</el-dropdown-item>
                        <el-dropdown-item command="email">用户邮箱</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>&emsp;<br>                
                </el-col>
                <el-col :span="16">
                    <el-input id="all_input_style" placeholder="请输入需要查找的用户名称" v-model="userUploadData"></el-input>
                </el-col>
                <el-col :span="2" :offset="1">
                    <el-button type="primary" class="el-icon-search" @click="searchTableSingleData">查找</el-button>
                </el-col>
            </el-row>
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
            userInfor: new Array(),
            addWindow: false,    
            sortWindow: false,   
            searchWindow: false, 
            uploadType: '',
            countTip: 0,
            userName: '',
            userUploadData: '',
            addUserData: {  //需要修改的用户数据
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
        
    },
    methods:{
        //已完成
        getUserPermission(index){
            this.addUserData.userPermission = index
        },

        //已完成
        addTableSingleData(){
            if(this.addUserData.username != "" && this.addUserData.password != "" && 
               this.addUserData.name != "" && this.addUserData.phone != "" && 
               this.addUserData.email != "" && this.addUserData.userPermission != ""){
                let postData = this.qs.stringify({
                    username: this.addUserData.username,
                    password: this.addUserData.password,
                    salt: null,
                    name: this.addUserData.name,
                    phone: this.addUserData.phone,
                    email: this.addUserData.email,
                    userPermission: this.addUserData.userPermission,
                })
                this.axios({
                    method: 'post',
                    url: '/administrator/addUserInforData',
                    data: postData
                }).then(response =>{
                    if(response.data != ""){
                        this.$message({
                            type: 'success',
                            message: "用户添加成功！"
                        })
                        this.reload()
                        this.addUserData = ""
                        this.addWindow = false
                    }else{
                        this.$message({
                            type: 'warning',
                            message: "用户添加失败！"
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

        //已完成
        getUserInforByUserPermission(command){
            let postData = this.qs.stringify({
                userPermission: command,
            });
            this.axios({
                method: 'post',
                url: '/administrator/getUserInforByUserPermission',
                data: postData
            }).then(response =>{
                if(response.data.length != 0){
                    this.userInfor = response.data
                    this.countTip = response.data.length
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


        getUserInforByUserUploadType(type){
            this.uploadType = type
        },

        searchTableSingleData(){
            if(this.uploadType == 'name'){
                this.getUserInforByUserName()
            }else if(this.uploadType == 'phone'){
                this.getUserInforByPhone()
            }else if(this.uploadType == 'email'){
                this.getUserInforByEmail()
            }
        },

        getUserInforByUserName(){
            let postData = this.qs.stringify({
                name: this.userUploadData,
            });
            this.axios({
                method: 'post',
                url: '/administrator/getUserInforByUserName',
                data: postData
            }).then(response =>{
                if(response.data.length != 0){
                    this.countTip = response.data.length
                    this.userInfor = response.data
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

        getUserInforByPhone(){
            let postData = this.qs.stringify({
                phone: this.userUploadData,
            });
            this.axios({
                method: 'post',
                url: '/administrator/getUserInforByPhone',
                data: postData
            }).then(response =>{
                if(response.data.length != 0){
                    this.countTip = response.data.length
                    this.userInfor = response.data
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

        getUserInforByEmail(){
            let postData = this.qs.stringify({
                email: this.userUploadData,
            });
            this.axios({
                method: 'post',
                url: '/administrator/getUserInforByEmail',
                data: postData
            }).then(response =>{
                if(response.data.length != 0){
                    this.countTip = response.data.length
                    this.userInfor = response.data
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

        // getByMusicIndex(command){
        //     let postData = this.qs.stringify({
        //         musicRecommendIndex: command,
        //     });
        //     this.axios({
        //         method: 'post',
        //         url: '/administrator/getMusicDataByIndex',
        //         data: postData
        //     }).then(response =>{
        //         this.userInfor = response.data
        //         this.countTip = response.data.length
        //     }).catch(error => {
        //         console.log(error)
        //     })
        // },

        // handleClose(done) {
        //     this.$confirm('确认关闭？').then(_ => {
        //         done();
        //     }).catch(_ => {});
        // },  

        closeWindow(){
            this.userInfor = []
            this.sortWindow =  false
            this.searchWindow =  false
            this.countTip = 0
            this.userUploadData = ''
            this.uploadType = ''
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
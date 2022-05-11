<template>
    <div>
        <div>
        <el-row>
            <el-col :span="16" :offset="6">
                <p style="color: seashell; font-size: 2.2vw; font-weight: 900; font-family: STFangsong;">Anime网站登陆</p>
            </el-col>
            <el-col :span="12" :offset="6">
                <el-input style="padding-top:10%" placeholder="帐号" v-model="loginForm.username"></el-input>
                <el-input style="padding-top:20%" type="password" placeholder="密码" v-model="loginForm.password"></el-input>
            </el-col>
            <el-col style="padding-top:10%" :span="12" :offset="6">
                <el-button style="width:100%" type="primary" @click="loginWeb">确定</el-button>
            </el-col>
        </el-row>
        </div>
    </div>
</template>

<script>
let Base64 = require('js-base64').Base64
export default({
    data(){
        return{
            infor: '',
            msg: "",
            loginForm: {
                username: null,
                password: null,
            }
        }
    },
    methods:{
        loginWeb(){
            if(this.loginForm.username != null && this.loginForm.password != null){
                let postData = this.qs.stringify({
                    username: this.loginForm.username,
                    password: this.loginForm.password,
                });
                this.axios({
                    method: 'post',
                    url: '/login/loginInfor',    
                    data: postData  
                }).then(response=>{
                    if(response.data.userPermission == "Zeroer" && response.data.code == 302 && response.data.token != null){
                        localStorage.setItem("management", 1)
                        localStorage.setItem("animeModuel", 1)
                        localStorage.setItem("dataModuel", 1)
                        this.$cookies.set("token", response.data.token);
                        this.$cookies.set("username", response.data.username);
                        this.$cookies.set("userPermission", response.data.userPermission);  
                        this.$router.replace("/administrator_main_interface")    
                        this.$message({
                            type: 'success',
                            message: '登录成功!',                    
                        });                  
                    }else if(response.data.code == 302 && response.data.token != null){
                        this.$cookies.set("token", response.data.token, 300);
                        this.$cookies.set("username", response.data.username, 300);
                        this.$cookies.set("userPermission", response.data.userPermission, 300);
                        this.$message({
                            type: 'success',
                            message: '登录成功!',                    
                        });
                        localStorage.setItem("change", 1)
                        this.$router.replace("/shopping_cart_moduel")
                        // this.$router.replace("/administrator_main_interface")
                    }else{
                        this.$message({
                            type: 'error',
                            message: '用户名或密码有误!',                    
                        });
                    }
                }).catch(error=>{
                    console.log(error)
                }) 
            }else{
                this.$message({
                    type: 'error',
                    message: '用户名或密码不能为空!',                    
                });
            }
        },
    }
})
</script>

<style scoped>

</style>
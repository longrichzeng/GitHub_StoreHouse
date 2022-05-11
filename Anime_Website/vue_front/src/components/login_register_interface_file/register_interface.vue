<template>
    <div>
        <div>
        <el-row>
            <el-col :span="12" :offset="6">
                <p style="color: seashell; font-size: 2.2vw; font-weight: 900; font-family: STFangsong;">Anime账号注册</p>
            </el-col>
            <el-col :span="12" :offset="6">
                <el-input size="small" style="padding-top:0%" placeholder="昵称" v-model="loginForm.username"></el-input>
                <el-input size="small" type="password" style="padding-top:2%" placeholder="密码" v-model="loginForm.password"></el-input>
                <el-input size="small" style="padding-top:2%" placeholder="姓名" v-model="loginForm.name"></el-input>
                <el-input size="small" style="padding-top:2%" placeholder="手机号码" v-model="loginForm.phone"></el-input>
                <el-input size="small" style="padding-top:2%" placeholder="邮箱" v-model="loginForm.email"></el-input>
            </el-col>
            <el-col :span="6" :offset="6">
                <el-input size="small" style="padding-top:3%" placeholder="验证码"></el-input>
            </el-col>
            <!-- <el-col :span="5" :offset="1">
                <img style="width: 100%; height: 50%" src="../../assets/Web_Front_Image/code.png" alt="">
            </el-col> -->
            <el-col style="padding-top:2%" :span="12" :offset="6">
                <el-button style="width:100%" type="primary" @click="registerInfor">确定</el-button>
            </el-col>
        </el-row>
        </div>
    </div>
</template>

<script>
import {verifyMobileNumber} from '../../common/js/utils.js'
import {verifyEmailNumber} from '../../common/js/utils.js'
export default({
    data(){
        return{
            msg: "longRich",
            loginForm: {
                username: "",
                password: "",
                salt: "",
                name: "",
                phone: "",
                email: ""
            }
        }
    },
    methods:{
        registerInfor(){
            if(this.loginForm.username != "" && this.loginForm.password != "" && this.loginForm.name != "" && this.loginForm.phone != "" && this.loginForm.email != ""){
                if(verifyMobileNumber(this.loginForm.phone)){
                    if(verifyEmailNumber(this.loginForm.email)){
                        let postData = this.qs.stringify({
                            username: this.loginForm.username,
                            password: this.loginForm.password,
                            salt: null,
                            name: this.loginForm.name,
                            phone: this.loginForm.phone,
                            email: this.loginForm.email,
                            userPermission: null
                        });
                        this.axios({
                            method: 'post',
                            url: '/login/addRegisteredInfor',    
                            data: postData  
                        }).then(response=>{
                            if(response.data != null && response.data != ""){
                                this.$message({
                                    type: 'success',
                                    message: '新用户注册成功！',
                                });
                                this.loginForm.username = "";
                                this.loginForm.password = "";
                                this.loginForm.name = "";
                                this.loginForm.phone = "";
                                this.loginForm.email = "";
                            }
                            
                        }).catch(error=>{
                            console.log(error)
                        }) 
                    }else{
                        // this.$message({
                        //     type: 'error',
                        //     message: '请输入正确的邮箱编号！'
                        // })
                        const h = this.$createElement;
                        this.$notify({
                            title: '错误提示',
                            message: h('i', { style: 'color: teal'}, '请输入正确的邮箱编号！'),
                            type: 'warning'
                        });
                    }
                }else{
                    // this.$message({
                    //     type: 'error',
                    //     message: '请输入正确的手机号码！'
                    // })
                    const h = this.$createElement;
                    this.$notify({
                        title: '错误提示',
                        message: h('i', { style: 'color: teal'}, '请输入正确的手机号码！'),
                        type: 'warning'
                    });
                }
            }else{
                this.$message({
                    type: 'error',
                    message: '注册信息不能为空！',
                });
            }

        },
    }
})
</script>

<style scoped>

</style>
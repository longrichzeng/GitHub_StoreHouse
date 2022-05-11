<template>
    <div class="backgrountImage">
        <el-button type="text" style="font-size: 4vw; margin-left: 93%" class="el-icon-s-promotion" @click="toMainInterface"></el-button>
        <div id="toggleButton">
            <el-col :span="12" :offset="0">
                <el-button style="width:100%" type="primary" @click.prevent="login">登陆</el-button>
            </el-col>
            <el-col :span="12" :offset="0">
                <el-button style="width:100%" type="info" @click.prevent="register">注册</el-button>
            </el-col>     
        </div>
        <div id="inputBox">
            <el-row>
                <component :is="comName"></component>
            </el-row>
        </div>
    </div>
</template>

<script>
import loginInterface from './login_interface.vue';
import registerInterface from './register_interface.vue';
import store from '@/vuex/store'
export default({
    data(){
        return{
            comName: 'v-loginInterface'
        }
    },
    methods:{
        login(){
            this.comName = 'v-loginInterface'
        },
        register(){
            this.comName = 'v-registerInterface'
        },
        toMainInterface(){
            this.$router.replace("/main_interface")
        }
        
    },
    components:{
        'v-loginInterface': loginInterface,
        'v-registerInterface': registerInterface
    },
    store,
})
</script>

<style scoped>
.backgrountImage{
    background: url("../../assets/Web_Front_Image/Login_Image.jpg") no-repeat;
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: contain;
    position: fixed;
}
#inputBox{
    background:rgba(0, 0, 0, 0.5);
    height: 55%;
    width: 30%;
    border-radius: 6%;
    position: fixed;
    top: 20%;
    left: 35%;
}
#toggleButton{
    height: 50%;
    width: 30%;
    position: fixed;
    top: 75%;
    left: 35%;
}
#inputStyle{
    padding-top: 10px;
}
</style>
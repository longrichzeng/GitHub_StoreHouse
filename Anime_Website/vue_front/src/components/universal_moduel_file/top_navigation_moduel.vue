<template>
    <div>
        <div id="navigation_background_style">
            <ul id="navigation_style">
                <li><el-button id="navigation_bar_options" type="text" @click="toMainInterface">主页</el-button></li>
                <li><el-button id="navigation_bar_options" type="text" @click="toJinpinInterface">景品手办</el-button></li>
                <li><el-button id="navigation_bar_options" type="text" @click="toLogBoardInterface">日志板</el-button></li>
                <li><el-button id="navigation_bar_options" type="text" @click="toAnimeDisplayInterface">动漫展</el-button></li>
            </ul>
            <p id="navigation_sentence">Welcome to this Anime World ！</p>
            <input id="navigation_input" type="text" placeholder="    快速搜索..."/>
            <el-button type="text" class="el-icon-s-custom" id="individual_image" @click="toIndividualSpace"></el-button>
        </div>
    </div>
</template>

<script>
import VueCookies from 'vue-cookies';
import {Base64} from 'js-base64';
export default({
    data(){
        return{

        }
    },
    methods:{
        /**
         * 跳转页面至/main_interface(主界面)
         */
        toMainInterface(){
            this.$router.replace("/main_interface")
        },

        /**
         * 跳转页面至/jinpin_interface_moduel(景品手办商城页面)
         */
        toJinpinInterface(){
            this.$router.replace("/jinpin_interface_moduel")
        },

        /**
         * 跳转页面至/log_board_interface(日志板页面)
         */
        toLogBoardInterface(){
            this.$router.replace("/log_board_interface")
        },

        /**
         * 跳转页面至/anime_display_interface(动漫展页面)
         */
        toAnimeDisplayInterface(){
            this.$router.replace("/anime_display_interface")
        },

        /**
         * 跳转页面至/individual_main_interface(用户私人的信息页面)
         */
        toIndividualSpace(){
            //获取储存在cookie中的username、token以及userPermission的信息
            let username = VueCookies.get("username")
            let token = VueCookies.get("token")
            let userPermission = VueCookies.get("userPermission")

            //在localStorage设置一个key为change，值为1的键值对，根据这个全局变量用于页面跳转判断; 因为个人信息模块界面是
            //一个界面包含四个组建，每次刷新的时候就只会跳到第一个组件展示，这对使用这部分的页面很不方便，所以必须设置一个
            //不容易改变的全局变量用于区分页面的展示;
            //有一个想法，那就是能不能通过组件传值来代替这个方法；
            localStorage.setItem("change", 1)

            //定义一个暂时的token变量，其实这里已经有些暴露来自后端的token了，其实能否使用session来代替
            let tempToken = "administrator" + username

            //将上面的暂时的token变量使用base64加密五次
            for(let i = 0; i < 5; i++){
                tempToken = Base64.encode(tempToken)
            }

            //判断username和token是否为空，以及上面生成的token和正真的token是否对的上，都满足则进入/individual_main_interface
            //(用户私人的信息页面),否则直接跳转到登录界面,并附有提示语句
            if(username != null && token != null && userPermission != null && tempToken == token){
                this.$router.replace("/individual_main_interface")
            }else{
                this.$message({
                    type: 'warning',
                    message: "请先进行登陆操作或注册账号！"
                })
                this.$router.replace("/login_register_main_interface")
            }
        }    
    }
})
</script>

<style scoped>
@media screen and (max-width: 800px) {
    #navigation_sentence{       
        display: none;
    }
    #navigation_input{
        display: none;
    }
    #individual_image{
        width: 200%;
        height: 200%;
    }
}
#navigation_background_style{
    /* background-color: #6699CC; */
    background-image: linear-gradient(to top, rgba(0, 196, 250, 0.7) 0%, rgba(0, 90, 235, 0.7) 100%);
    position: absolute;
    width: 99%;
    height: 12%;
    border-radius: 15px;
}
#navigation_style{
    position: absolute;
    list-style: none;
    font-size: 2vw;
    width: 40%;
    font-weight: 900;
    font-family: STFangsong;
}
#navigation_style li{
    color: rgb(0, 0, 0);
    margin-left: 2%;
    top: 1%;
    display: inline;
}
#navigation_bar_options{
    font-family: STFangsong;
    color: seashell;
    text-decoration: none;
    font-size:2vw;
    font-weight:900;
}
#navigation_sentence{
    position: absolute;
    left: 35%;
    top: 2%;
    font-family: Georgia;
    color: black;
    font-size:2vw;
    font-weight:900;
}
#navigation_input{
    position: absolute;
    left: 70%;
    top: 30%;
    color: darkgray;
    font-family: STFangsong;
    width: 20%;
    height: 40%;
    font-size: 1.5vw;
    border-radius: 20px;
}
#individual_image{
    position: relative;
    left: 93%;
    top: 11%;
    width: 5%;
    height: auto;
    font-size: 3vw;
    color: aliceblue;
    border: 2px white solid;
    border-radius: 50%;
}
#navigation_style :hover{
    background-color: rgba(61, 128, 228, 0.7);
}
</style>
<template>
    <div>
        <v-individualTopModuel></v-individualTopModuel>
        <div id="left_navigation_bar">
            <el-button id="left_toggel" type="text" class="el-icon-user" @click="selectTable(1)"> 个人信息</el-button><br>
            <el-button id="left_toggel" type="text" class="el-icon-s-data" @click="selectTable(2)"> 专业技能</el-button><br>
            <el-button id="left_toggel" type="text" class="el-icon-pie-chart" @click="selectTable(3)"> 拓展技能</el-button><br>
            <el-button id="left_toggel" type="text" class="el-icon-data-analysis" @click="selectTable(4)"> 年度计划</el-button><br>
        </div>   
        <div id="main_interface_background_style">
            <div v-if="change==1">
                <v-mainPersonalInformationInterface></v-mainPersonalInformationInterface>
            </div>
            <div v-if="change==2">
                <v-mainProfessionalSkillInterface></v-mainProfessionalSkillInterface>
            </div>
            <div v-if="change==3">
                <v-mainExpandSkillsInterface></v-mainExpandSkillsInterface>
            </div>    
            <div v-if="change==4">
                <v-annualPlanModuel></v-annualPlanModuel>
            </div>          
        </div>
        <div id="welcome_sentence_style">
            <span id="name_style" @click="quit">{{userName}}</span>
            <span>,欢迎来到Anime这个世界!</span>&emsp;&emsp;&emsp;&emsp;&emsp;
            <el-button style="font-size: 2vw" type="text" class="el-icon-setting" @click="deleteUserInfor"></el-button>
        </div>
    </div>
</template>

<script>
import individualTopModuel from "../universal_moduel_file/individual_top_moduel.vue"
import mainPersonalInformationInterface from "../individual_interface_file/personal_information_file/main_personal_information_interface.vue"
import mainProfessionalSkillInterface from "../individual_interface_file/professional_skill_file/main_professional_skill_interface.vue"
import mainExpandSkillsInterface from "../individual_interface_file/expand_skills_file/main_expand_skills_interface.vue"
import annualPlanModuel from "../individual_interface_file/annual_plan_moduel.vue"
import VueCookies from 'vue-cookies';
import {deleteAllUserInfor} from '../../common/js/utils.js'
import {Base64} from 'js-base64';

export default({
    inject: ['reload'],
    data(){
        return{
            change: localStorage.getItem("change"),
            userName: VueCookies.get("username")
        }
    },
    methods:{
        selectTable(count){
            this.change = count
            localStorage.setItem("change", count)
        },
        deleteCookieInfor(){
            this.$cookies.remove("token")
            this.$cookies.remove("username")
            this.$cookies.remove("userPermission")
        },   
        quit(){
            this.$confirm('确定退出登录？', '温馨提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',                    
            }).then(()=>{
                this.quitByEnd(),
                this.deleteCookieInfor(),
                this.$router.replace("/login_register_main_interface")
                this.$message({
                    type: 'success',
                    message: `提示: ${ "你已成功退出登陆！" }`
                });
                localStorage.clear()
            }).catch(()=>{
                this.$message({
                    type: 'info',
                    message: `提示: ${ "你已取消退出登陆！" }`
                });          
            })
        },
        quitByEnd(){
            let postData = this.qs.stringify({
                username: VueCookies.get("username"),
            });
            this.axios({
                method: 'post',
                url: '/login/logout',   
                data: postData       
            }).catch(error=>{
                console.log(error)
            })
        },
        deleteUserInfor(){
            this.$confirm('确定删除这个帐号吗?', '温馨提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',                    
            }).then(()=>{
                let username = VueCookies.get("username")
                deleteAllUserInfor(username)
                this.deleteCookieInfor(),
                this.$message({
                    type: 'success',
                    message: `提示: ${ "已经将您在这个世界的痕迹清除干净，永别了!" }`
                });
                this.reload()
                this.$router.replace("/login_register_main_interface")
            }).catch(()=>{
                this.$message({
                    type: 'info',
                    message: `提示: ${ "我们很高兴您对这个世界还存有留恋！" }`
                });          
            })
        }
    },
    components:{
        'v-individualTopModuel': individualTopModuel,
        'v-mainPersonalInformationInterface': mainPersonalInformationInterface,
        'v-mainProfessionalSkillInterface': mainProfessionalSkillInterface,
        'v-mainExpandSkillsInterface': mainExpandSkillsInterface,
        'v-annualPlanModuel': annualPlanModuel,
        
    },
})
</script>

<style scoped>
#left_navigation_bar{
    background-color: rgba(11, 37, 84, 0.7);
    border-radius: 15px;
    position: fixed;
    top: 25%;
    left: 2%;
    width: 10%;
    height: 25%;
}
#left_navigation_bar :hover{
    color: deepskyblue;
}
#left_toggel{
    font-size: 1.4vw; 
    margin-left: 12%;
    color: aliceblue;
    font-family: STFangsong;
}
#main_interface_background_style{
    position: absolute;
    background-color: rgba(100, 149, 239, 0.2);
    margin-top: 12%;
    margin-left: 13%;
    width: 84%;
    height: auto;
    border-radius: 15px;
}
#welcome_sentence_style{
    font-size: 1.5vw;
    position: absolute;
    margin-top: 8.5%;
    margin-left: 65%;
    font-family: STFangsong;
}
#name_style{
    font-weight: 900;
}
#name_style:hover{
    color: blue;
}
</style>
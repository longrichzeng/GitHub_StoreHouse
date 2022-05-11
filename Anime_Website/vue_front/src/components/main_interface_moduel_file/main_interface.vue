<template>
    <div>
        <v-topNavigation></v-topNavigation>
        <v-mainDisplay></v-mainDisplay>
        <v-bottomCommunication></v-bottomCommunication>
        <v-animeDrame></v-animeDrame>
        <v-musicRanking></v-musicRanking>
        <v-animeWallpaper></v-animeWallpaper>
        <div id="welcome_sentence_style">
            <span id="name_style" @click="quit">{{userName}}</span>
            <span>欢迎来到Anime这个世界!</span>
        </div>            
        <div style="position: absolute; margin-top: 45%"></div>
    </div>
</template>

<script>
import topNavigation from '../universal_moduel_file/top_navigation_moduel.vue';
import bottomCommunication from '../universal_moduel_file/bottom_communication_moduel.vue';
import mainDisplay from './main_display_moduel.vue';
import animeDrame from './anime_drame_moduel.vue';
import musicRanking from './music_ranking_moduel.vue';
import animeWallpaper from './anime_wallpaper_moduel.vue';
import VueCookies from 'vue-cookies';
export default({
    data(){
        return{
            userName: VueCookies.get("username"),
        }
    },
    created(){
        // console.log(verifyMobileNumber("13169485319"));
        // console.log(verifyEmailNumber("2864659907@qq.com"));
    },
    methods:{
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
        }
    },
    components:{
        'v-topNavigation': topNavigation,
        'v-bottomCommunication': bottomCommunication,
        'v-mainDisplay': mainDisplay,
        'v-animeDrame': animeDrame,
        'v-musicRanking': musicRanking,
        'v-animeWallpaper': animeWallpaper,
    },
})
</script>

<style scoped>

#welcome_sentence_style{
    font-size: 1.5vw;
    position: absolute;
    margin-top: 6.5%;
    margin-left: 72%;
    font-family: STFangsong;
}
#name_style{
    font-weight: 900;
}
#name_style:hover{
    color: blue;
}
#cue_sentence_style{
    position: absolute;
    font-size: 3vw;
    top: 15%;
    left: 5%;
    font-weight: 900;
    font-family: STFangsong;
}
</style>
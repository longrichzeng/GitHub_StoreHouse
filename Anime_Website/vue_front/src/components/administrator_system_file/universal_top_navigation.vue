<template>
    <div>
        <div id="navigation_style">
            <el-row>
                <el-col :span="7" :offset="1">
                    <el-button id="navigation_toggle_style" type="text" @click="chooseModuel(1)">动漫管理</el-button>
                    <el-button id="navigation_toggle_style" type="text" @click="chooseModuel(2)">用户管理</el-button>
                    <el-button id="navigation_toggle_style" type="text" @click="chooseModuel(3)">管理员权限</el-button>
                </el-col>
                <el-col :span="12" :offset="1">
                    <p id="navigation_sentence_style">
                        止まって前に進まなくても、やがて記憶になり、<br>
                        &emsp;&emsp;&emsp;明日は花が咲き、希望が咲きます。 ---《Start Dash!》
                    </p>
                </el-col>
                <el-col :span="2" :offset="1">
                    <!-- 这里还有个功能还未确定 -->
                    <el-button type="text" class="el-icon-s-custom" id="individual_image" @click="quit"></el-button>
                </el-col>
            </el-row>
        </div>
        <div id="main_moduel_style">
            <div v-if="count == 1">
                <v-animeMainManagement></v-animeMainManagement>
            </div>
            <div v-if="count == 2">
                <v-userMainManagement></v-userMainManagement>
            </div>
            <div v-if="count == 3">
                <v-dataMainManagement></v-dataMainManagement>
            </div>
        </div>        
    </div>    
</template>

<script>
import animeMainManagement from '../administrator_system_file/anime_management_file/anime_main_management_interface.vue'
import userMainManagement from '../administrator_system_file/user_management_file/user_main_management_interface.vue'
import dataMainManagement from '../administrator_system_file/data_management_file/data_main_management_interface.vue'
export default({
    data(){
        return{
            count: localStorage.getItem("management")
        }
    },
    created(){

    },
    methods:{
        /**
         * 在组建跳转之前，先修改本地存储的数据，在跳转，这样的好处是页面刷新的时候，不会总是只跳到首页面
         */
        chooseModuel(number){
            localStorage.setItem("management", number)
            this.count = number
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
                // this.quitByEnd(),
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
        'v-animeMainManagement': animeMainManagement,
        'v-userMainManagement': userMainManagement,
        'v-dataMainManagement': dataMainManagement,
    }
})
</script>

<style scoped>
#navigation_style{
    position: fixed;
    background-image: linear-gradient(-90deg, #29bdd9 0%, #276ace 100%);
    width: 99%;
    height: 12%;
    border-radius: 15px;
}
#navigation_toggle_style{
    font-size: 2vw;
    font-weight: 900;
    font-family: STFangsong;
    color: aliceblue;
    margin-top: 7%;
}
#navigation_toggle_style:hover{
    background-color: rgba(53, 92, 151, 0.7);
    color: #b6cef3;
    border-radius: 15px;
}
#navigation_sentence_style{
    font-size: 1.8vw;
    font-weight: 900;
    font-family: STFangsong;
    color: aliceblue;
    margin-top: 2%;
}
#individual_image{
    width: 58%;
    height: auto;
    left: 93%;
    margin-top: 8%;
    font-size: 3vw;
    color: aliceblue;
    border: 2px white solid;
    border-radius: 50%;
}
</style>
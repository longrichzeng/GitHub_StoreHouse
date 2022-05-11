<template>
    <div>
        <v-topNavigation></v-topNavigation>
        <div id="left_navigation_bar">
            <el-button id="left_toggel" type="text" class="el-icon-lollipop" @click="getAllAnimeDrema">全部番剧</el-button><br>
            <el-button id="left_toggel" type="text" class="el-icon-ice-cream-square" @click="getAnimeAboutType('热血战斗')">热血战斗</el-button><br>
            <el-button id="left_toggel" type="text" class="el-icon-ice-cream-round" @click="getAnimeAboutType('人生感悟')">人生感悟</el-button><br>
            <el-button id="left_toggel" type="text" class="el-icon-ice-cream" @click="getAnimeAboutType('萝莉废萌')">萝莉废萌</el-button><br>
            <el-button id="left_toggel" type="text" class="el-icon-cherry" @click="getAnimeAboutType('魔法世界')">魔法世界</el-button><br>
            <el-button id="left_toggel" type="text" class="el-icon-apple" @click="getAnimeAboutType('青春校园')">青春校园</el-button><br>
            <el-button id="left_toggel" type="text" class="el-icon-cold-drink" @click="getAnimeAboutType('日常搞笑')">日常搞笑</el-button><br>
            <el-button id="left_toggel" type="text" class="el-icon-sugar" @click="getAnimeAboutType('催泪治愈')">催泪治愈</el-button>
        </div>
        <div id="main_background_style">
            <el-row>
                <el-col style="margin-top: 2%; margin-left: 6%" v-for="(img,index) in infor" :key="index" :span="6" :offset="1">
                    <el-popover :open-delay="300" placement="bottom-end" width="300" trigger="hover">     
                        <p>番剧名称: {{ infor[index].animeName }}</p>   
                        <p>番剧类型: {{ infor[index].animeType }}</p>
                        <p>番剧作者: {{ infor[index].animeAuthor }}</p>
                        <p>番剧发布时间: {{ infor[index].animePublishTime }}</p>
                        <p>番剧推荐指数: {{ infor[index].animeRecommendIndex }}</p>
                        <p>番剧描述: {{ infor[index].animeIntroduction }}</p>       
                        <img id="anime_image_style" slot="reference" :src="require('../../assets/animeImage/' + infor[index].animeNumber + '.png')" />
                    </el-popover>
                </el-col>
            </el-row>
        </div>
        <img id="right_image_style" src="../../assets/Web_Front_Image/rimu.png" alt="">
    </div>
</template>

<script>
import topNavigation from '../universal_moduel_file/top_navigation_moduel.vue';
import bottomCommunication from '../universal_moduel_file/bottom_communication_moduel.vue';
export default({
    data(){
        return{
            infor: []
        }
    },
    created(){
        this.axios({
            method: 'post',
            url: '/administrator/getAnimeDrameData',          
        }).then(response=>{
            this.infor = response.data
        }).catch(error=>{
            console.log(error)
        })
    },
    methods:{
        getAllAnimeDrema(){
            this.axios({
                method: 'post',
                url: '/administrator/getAnimeDrameData',
            }).then(response=>{
                this.infor = response.data
            }).catch(error=>{
                console.log(error)
            })            
        },
        getAnimeAboutType(animeType){
            let postData = this.qs.stringify({
                animeType: animeType,
            });
            this.axios({
                method: 'post',
                url: '/administrator/getAnimeAboutType',    
                data: postData  
            }).then(response=>{
                this.infor = response.data
            }).catch(error=>{
                console.log(error)
            })              
        }
    },
    components:{
        'v-topNavigation': topNavigation,
        'v-bottomCommunication': bottomCommunication,
    },
})
</script>

<style scoped>
#left_navigation_bar{
    background-color: rgba(100, 149, 239, 0.2);
    border-radius: 15px;
    position: fixed;
    top: 20%;
    left: 8%;
    width: 12%;
    height: 50%;
}
#main_background_style{
    background-color: rgba(100, 149, 239, 0.2);
    border-radius: 15px;
    position: absolute;
    top: 16%;
    left: 25%;
    width: 55%;
    height: auto;
}
#anime_image_style{
    width: 100%;
    height: 100%; 
}
#right_image_style{
    position: fixed;
    left: 77%;
    top: 13%;
}
#left_toggel{
    font-size: 1.4vw; 
    margin-left: 20%;
}
</style>
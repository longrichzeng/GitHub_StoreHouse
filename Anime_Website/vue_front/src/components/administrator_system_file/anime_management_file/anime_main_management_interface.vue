<template>
    <div>
        <!-- <v-universalTopNavigation></v-universalTopNavigation> -->
        <div id="left_moduel_style">
            <div style="margin-top: 15%">
                <el-button id="toggel_word_style" type="text" @click="chooseModuel(1)">动漫番剧</el-button>
            </div>
            <div style="margin-top: 5%">
                <el-button id="toggel_word_style" type="text" @click="chooseModuel(2)">动漫音乐</el-button>
            </div>
            <div style="margin-top: 5%">
                <el-button id="toggel_word_style" type="text" @click="chooseModuel(3)">景品手办</el-button>
            </div>
        </div>
        <div id="main_moduel_style">
            <div v-if="count == 1">
                <v-animeDrameManagement></v-animeDrameManagement>
            </div>
            <div v-if="count == 2">
                <v-animeMusicManagement></v-animeMusicManagement>
            </div>
            <div v-if="count == 3">
                <v-jinpinModelManagement></v-jinpinModelManagement>
            </div>
        </div>
    </div>    
</template>

<script>
import universalTopNavigation from '../universal_top_navigation.vue'
import animeDrameManagement from '../anime_management_file/anime_drame_management_interface.vue'
import animeMusicManagement from '../anime_management_file/anime_music_management_interface.vue'
import jinpinModelManagement from '../anime_management_file/jinpin_model_management_interface.vue'
export default({
    data(){
        return{
            count: localStorage.getItem("animeModuel")
        }
    },
    created(){

    },
    methods:{
        chooseModuel(number){
            localStorage.setItem("animeModuel", number)
            this.count = number
        }
    },
    components:{
        'v-universalTopNavigation': universalTopNavigation,
        'v-animeDrameManagement': animeDrameManagement,
        'v-animeMusicManagement': animeMusicManagement,
        'v-jinpinModelManagement': jinpinModelManagement,
    },
    
})
</script>

<style scoped>
#left_moduel_style{
    position: fixed;
    background: linear-gradient(to bottom, #323232 0%, #3F3F3F 40%, #1C1C1C 150%), linear-gradient(to top, rgba(255,255,255,0.40) 0%, rgba(0,0,0,0.25) 200%);
    background-blend-mode: multiply;			
    top: 14%;
    width: 8%;
    height: 85%;
    border-radius: 15px;
    text-align: center;
}
#toggel_word_style{
    font-size: 1.5vw;
    font-weight: 900;
    font-family: STFangsong;
    color: aliceblue;
}
#toggel_word_style:hover{
    color: rgb(32, 116, 252);
    background-color: aliceblue;
}
#main_moduel_style{
    position: fixed;
    background-color: white;
    border: solid ;
    width: 90%;
    height: 85%;
    top: 14%;
    left: 9%;
    border-radius: 15px;
}
</style>
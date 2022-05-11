<template>
    <div>
        <v-topNavigation></v-topNavigation>
        <div>
            <el-table id="log_board_style" :row-style="{height: '0'}" :cell-style="{top: '10px'}" :data="infor">
                <el-table-column prop="notesTitle" label="日志标题" width="250"></el-table-column>
                <el-table-column prop="notesContent" label="日志内容" width="700"></el-table-column>
                <el-table-column prop="formationTime" label="编写时间" width="200"></el-table-column>
            </el-table>
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
    methods:{

    },
    created(){
        this.axios({
            method: 'post',
            url: '/administrator/getNotesInforData',          
        }).then(response=>{
            this.infor = response.data;
        }).catch(error=>{
            console.log(error)
        })
    },
    components:{
        'v-topNavigation': topNavigation,
        'v-bottomCommunication': bottomCommunication,
    },
})
</script>

<style scoped>
#log_board_style{
    position: absolute;
    width: 80%;
    left: 5%;
    top: 20%;
    border-radius: 15px;
    font-size: 1.4vw;
    font-weight: 900;
    font-family: STFangsong;
}
#right_image_style{
    position: fixed;
    left: 77%;
    top: 13%;
}
</style>
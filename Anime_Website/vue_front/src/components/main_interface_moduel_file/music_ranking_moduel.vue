<template>
    <div>
        <div id="music_ranking_style">
            <el-table :row-style="{height: '0'}" :cell-style="{padding: '0'}" size="mini" :data="infor">
                <el-table-column label="音乐排行版" width="340">
                        <template slot-scope="scope">
                            <el-popover :open-delay="500" width="300" size="mini" trigger="hover" placement="right">
                                <p>番剧名称: {{ scope.row.musicName }}</p>
                                <p>番剧类型: {{ scope.row.musicType }}</p>
                                <p>番剧作者: {{ scope.row.musicSinger }}</p>
                                <p>番剧发布时间: {{ scope.row.musicRecommendIndex }}</p>
                                <div slot="reference" class="name-wrapper">
                                    <el-button type="text">{{ scope.row.musicName }}</el-button>
                                </div>
                            </el-popover>
                        </template>                      
                </el-table-column>
            </el-table>        
        </div>
    </div>
</template>

<script>
export default({
    data(){
        return{
            infor: new Array(),
        }
    },
    created(){
        this.axios({
            method: 'post',
            url: '/administrator/getAnimeMusicData',          
        }).then(response=>{
            this.infor = response.data.slice(0,11);
        }).catch(error=>{
            console.log(error)
        })
    },
    methods:{

    }
})
</script>

<style scoped>
#music_ranking_style{
    position: absolute;
    background-image: linear-gradient(-225deg, rgba(125, 226, 252, 0.2) 0%, rgb(187, 184, 229, 0.2) 100%);
    width: 25%;
    height: 83%;
    left: 72%;
    top: 104%;
    border-radius: 15px;
}
.el-table{
    left: 5%;
    top: 3%;
    width: 90%;
    border-radius: 15px;
    font-size: 2vw;
    font-weight: 900;
    font-family: STFangsong;
}
.el-button{
    font-size: 1.5vw;
    font-weight: 900;
    font-family: STFangsong;
    color: black;
}
</style>
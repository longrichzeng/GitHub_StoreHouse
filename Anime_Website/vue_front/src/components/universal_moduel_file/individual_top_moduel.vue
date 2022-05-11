<template>
    <div>
        <div id="background_style">
            <el-row>
                <el-col :span="1">
                    <img id="headImage_style" src="../../assets/Web_Front_Image/headImage.jpg" alt="">
                </el-col>
                <el-col id="top_sentence_style" :span="19">
                    <p>真実を追求する者は、傲慢であってはならず、科学では説明できない<br>
                    &emsp;&emsp;&emsp;奇跡を笑ってはならず、この世界の美しさを避けてはなりません  -----《CLANNAD》</p>
                </el-col>
                <el-col :span="1">
                    <el-button id="withdraw_style" type="text" class="el-icon-s-promotion" @click="toMainInterface"></el-button>
                </el-col>
            </el-row>
        </div>
    </div>
</template>

<script>
export default({
    data(){
        return{

        }
    },
    methods:{
        /**
         * 跳转界面到/main_interface(主界面)
         */
        toMainInterface(){
            this.$router.replace("/main_interface")
        }
    }
})
</script>

<style scoped>
#background_style{
    background-color: cornflowerblue;
    position: absolute;
    width: 99%;
    height: 18%;
    border-radius: 15px;
}
#headImage_style{
    width: 180%;
    height: auto;
    border-radius: 50%;
    margin-top: 15%;
    margin-left: 30%;
}
#top_sentence_style{
    font-size: 1.8vw;
    font-weight: 900;
    margin-top: 0.5%;
    margin-left: 7%;
    font-family: STFangsong;
    color: aliceblue;
}
#withdraw_style{
    font-size: 5vw; 
    margin-top: 30%;
    margin-left: 50%;
    color: azure;
}
</style>
<template>
    <div>
        <div id="bottom_communication_style">
            <el-row>
                <el-col :span="19">
                    <p id="bottom_sentence">&emsp;日々私たちが过ごしている日常というのは、<br>
                    &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;実は奇迹の连続なのかもしれん.-----《日常》</p>
                </el-col>
                <el-col :span="1">
                    <img id="icon_image" src="../../assets/Web_Front_Image/bottom_icon/QQ.png" alt="">
                </el-col>       
                <el-col :span="1">
                    <img id="icon_image" src="../../assets/Web_Front_Image/bottom_icon/weChat.png" alt="">
                </el-col>       
                <el-col :span="1">
                    <img id="icon_image" src="../../assets/Web_Front_Image/bottom_icon/steam.png" alt="">
                </el-col>       
                <el-col :span="1">
                    <img id="icon_image" src="../../assets/Web_Front_Image/bottom_icon/bilibili.png" alt="">
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

    }
})
</script>

<style scoped>
#bottom_communication_style{
    /* background-color: #003366; */
    background-image: linear-gradient(to top, #1e3c72 0%, #1e3c72 1%, #2a5298 100%);
    position: absolute;
    width: 99%;
    height: 15%;
    top: 189%;
    border-radius: 15px;
}
#bottom_sentence{
    width: auto;
    font-size: 1.5vw;
    font-family: STFangsong;
    font-weight: 900;
    color: antiquewhite;
}
#bottom_icon_style{
    position: absolute;
    margin-left: 57%;
    width: 40%;
}
#bottom_icon_style li{
    margin-left: 5%;
    display: inline;
}
#icon_image{
    width: 90%;
    height: 90%;
    margin-top: 50%;
}

</style>
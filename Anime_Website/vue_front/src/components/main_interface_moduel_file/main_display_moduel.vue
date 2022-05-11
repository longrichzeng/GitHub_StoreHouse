<template>
    <div>
        <el-row id="main_display_style">
            <el-carousel trigger="click" indicator-position="inside" height="450px" :interval=5000>
                <el-carousel-item v-for="(img,index) in image" :key="index">
                    <img id="toggel_image" :src="img.url">
                </el-carousel-item>
            </el-carousel>
        </el-row>
        <p id="main_display_sentence">
            止まって前に進まなくても、やがて記憶になり、<br> 
            &emsp;&emsp;&emsp;&emsp;明日は花が咲き、希望が咲きます。 ---《Start Dash!》</p>
    </div>
</template>

<script>
export default({
    data(){
        return{
            image:[
                {url:require('@/assets/Web_Front_Image/main_Interface_Toggle_Image/image1.png')},
                {url:require('@/assets/Web_Front_Image/main_Interface_Toggle_Image/image2.png')},
                {url:require('@/assets/Web_Front_Image/main_Interface_Toggle_Image/image3.png')},
                {url:require('@/assets/Web_Front_Image/main_Interface_Toggle_Image/image4.png')},
                {url:require('@/assets/Web_Front_Image/main_Interface_Toggle_Image/image5.png')}
            ]
        }
    },
    methods:{

    }
})
</script>

<style scoped>
#main_display_style{
    position: absolute;
    background-image: linear-gradient(-225deg, rgba(125, 226, 252, 0.2) 0%, rgb(187, 184, 229, 0.2) 100%);
    width: 65%;
    height: 75%;
    left: 5%;
    top: 15%;
    border-radius: 15px;
}
#toggel_image{
    position: absolute;
    width: 96%;
    top: 3%;
    left: 2%;
    height: 100%; 
    border-radius: 15px;
}
#main_display_sentence{
    font-size: 2vw;
    color: black;
    font-weight: 900;
    font-family: STFangsong;
    position: absolute;
    top: 73%;
    left: 10%;
}
</style>
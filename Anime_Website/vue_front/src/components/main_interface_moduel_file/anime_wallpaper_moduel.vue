<template>
    <div>
        <div id="anime_wallpaper_style">
            <el-row>
                <div id="wallpaper_title">&emsp;动漫壁纸</div>
                <el-col style="margin-left: 3%; margin-top: 1%" v-for="(img,index) in image" :key="index" :span="5" :offset="0">
                    <img style="width: 100%; height: 100%;" :src="img.url" alt="">
                </el-col>
            </el-row>
        </div>
    </div>
</template>

<script>
export default({
    data(){
        return{
            image:[
                {url:require('@/assets/Web_Front_Image/wallpaper_Image/1.png')},
                {url:require('@/assets/Web_Front_Image/wallpaper_Image/2.png')},
                {url:require('@/assets/Web_Front_Image/wallpaper_Image/3.png')},
                {url:require('@/assets/Web_Front_Image/wallpaper_Image/4.png')},
                {url:require('@/assets/Web_Front_Image/wallpaper_Image/5.png')},
                {url:require('@/assets/Web_Front_Image/wallpaper_Image/6.png')},
                {url:require('@/assets/Web_Front_Image/wallpaper_Image/7.png')},
                {url:require('@/assets/Web_Front_Image/wallpaper_Image/8.png')},
                {url:require('@/assets/Web_Front_Image/wallpaper_Image/9.png')},
                {url:require('@/assets/Web_Front_Image/wallpaper_Image/10.png')},
                {url:require('@/assets/Web_Front_Image/wallpaper_Image/11.png')},
                {url:require('@/assets/Web_Front_Image/wallpaper_Image/12.png')},
                {url:require('@/assets/Web_Front_Image/wallpaper_Image/13.png')},
                {url:require('@/assets/Web_Front_Image/wallpaper_Image/14.png')},
                {url:require('@/assets/Web_Front_Image/wallpaper_Image/15.png')},
                {url:require('@/assets/Web_Front_Image/wallpaper_Image/16.png')},
                {url:require('@/assets/Web_Front_Image/wallpaper_Image/17.png')},
                {url:require('@/assets/Web_Front_Image/wallpaper_Image/18.png')},
                {url:require('@/assets/Web_Front_Image/wallpaper_Image/19.png')},
                {url:require('@/assets/Web_Front_Image/wallpaper_Image/20.png')},
            ]
        }
    },
    methods:{

    }
})
</script>

<style scoped>
#anime_wallpaper_style{
    position: absolute;
    background-image: linear-gradient(-225deg, rgba(125, 226, 252, 0.2) 0%, rgb(187, 184, 229, 0.2) 100%);
    width: 65%;
    height: 90%;
    left: 5%;
    top: 97%;
    border-radius: 15px;
}
#wallpaper_title{
    font-size: 2vw;
    font-weight: 900;
    font-family: STFangsong;
}
</style>
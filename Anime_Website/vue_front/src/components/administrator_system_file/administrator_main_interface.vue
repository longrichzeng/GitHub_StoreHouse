<template>
    <div>
        <!-- 这个管理员主界面调用universal_top_navigation.vue这个组件 -->
        <v-universalTopNavigation></v-universalTopNavigation>
    </div>    
</template>

<script>
import universalTopNavigation from './universal_top_navigation.vue'
export default({
    data(){
        return{

        }
    },
    created(){

    },
    methods:{

    },
    components:{
        'v-universalTopNavigation': universalTopNavigation,
    },
    
})
</script>

<style scoped>

</style>
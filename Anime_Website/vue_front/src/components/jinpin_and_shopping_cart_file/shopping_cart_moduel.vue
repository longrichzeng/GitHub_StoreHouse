<template>
    <div>
        <v-topNavigation></v-topNavigation>
        <div v-if="judge" id="background_style">
            <el-row id="shopping_cart_style" v-for="(info, index) in infor" :key="index">
                <el-col :span="6">
                    <img id="jinpin_image_style" :src="require('../../assets/jinpinImage/' + infor[index].jinPinNumber + '.png')">
                </el-col>
                <el-col style="font-size: 1.7vw;font-weight: 900;font-family: STFangsong;" :span="18">
                    景品编号: {{infor[index].jinPinNumber}}<br>
                    景品名称: {{infor[index].jinPinName}}.{{infor[index].jinPinType}}<br>
                    景品单价: {{infor[index].jinPinPrice}}<br>
                    景品厂商: {{infor[index].jinPinManufacturer}}<br>
                    景品数量: <el-button id="modify_jinPin_purchase_quantity" type="text" class="el-icon-plus" @click="addJinPinPurchaseQuantity(infor[index].jinPinNumber)"></el-button>
                                &nbsp;{{infor[index].jinPinPurchaseQuantity}}
                              <el-button id="modify_jinPin_purchase_quantity" type="text" class="el-icon-minus" @click="subJinPinPurchaseQuantity(infor[index].jinPinNumber)"></el-button><br>
                    景品总价: {{infor[index].jinPinTotalPrice}}&emsp;&emsp;&emsp;
                    <el-button style="font-size: 3vw; color: black;" type="text" class="el-icon-delete" @click="deleteJinPinPurchaseQuantity(infor[index].jinPinNumber)"></el-button>
                </el-col>                
            </el-row>
            <el-row style="margin-bottom: 3%; margin-top: 1%; margin-left: 0%; width: 30%; border: solid; border-radius: 15px">
                <el-col :span="8">
                    <el-button type="primary" style="margin-top: 20%; margin-left: 5%; font-size: 1.5vw; font-weight: 900;font-family: STFangsong;">结算</el-button>
                </el-col>
                <el-col :span="12">
                    <p style="font-size: 2vw; font-weight: 900;font-family: STFangsong;">总价: ￥{{totalPrice}}</p>
                </el-col>
            </el-row>
        </div>
        <div v-if="!judge" id="cue_sentence_style">
            <el-empty :image-size="200" description="你在购物车还未添加任何景品手办！"></el-empty>
            <!-- <p>你在购物车还未添加任何景品手办！</p> -->
        </div>
        <img style="position: fixed; width: 40%; height: 80%; margin-top: 7%; margin-left: 58%" src="../../assets/Web_Front_Image/shoppingCart.png" alt="">
        <div id="welcome_sentence_style">
            <span id="name_style" @click="quit">{{userName}}</span>
            <span>,欢迎来到Anime这个世界!</span>
        </div>
    </div>
</template>

<script>
import topNavigation from '../universal_moduel_file/top_navigation_moduel.vue';
import bottomCommunication from '../universal_moduel_file/bottom_communication_moduel.vue';
import VueCookies from 'vue-cookies';
export default({
    inject: ['reload'],
    data(){
        return{
            judge: true,
            infor: {},
            otherinfor: {},
            totalPrice: 0,
            userName: VueCookies.get("username")
        }
    },
    created(){
        let postData = this.qs.stringify({
            jinPinBuyingUser: VueCookies.get("username"),
        });
        this.axios({
            method: 'post',
            url: '/ShoppingCart/getUserTotalShoppingCartData',    
            data: postData  
        }).then(response=>{
            if(response.data.length != 0){
                this.infor = response.data
                for(let i = 0; i < response.data.length; i++){
                    this.totalPrice += parseFloat(response.data[i].jinPinTotalPrice)
                }
                this.judge = true
            }else{
                this.judge = false
            }
        }).catch(error=>{
            console.log(error)
        })
    },
    methods:{
        addJinPinPurchaseQuantity(number){
            let postData = this.qs.stringify({
                shoppingCartJinPinNumber: number,
                jinPinBuyingUser: VueCookies.get("username"),
            });
            this.axios({
                method: 'post',
                url: '/ShoppingCart/addJinPinPurchaseQuantity',    
                data: postData  
            }).then(response=>{
                this.infor = response.data
                this.reload() 
            }).catch(error=>{
                console.log(error)
            })
        },
        subJinPinPurchaseQuantity(number){
            let postData = this.qs.stringify({
                shoppingCartJinPinNumber: number,
                jinPinBuyingUser: VueCookies.get("username"),
            });
            this.axios({
                method: 'post',
                url: '/ShoppingCart/subJinPinPurchaseQuantity',    
                data: postData  
            }).then(response=>{
                this.infor = response.data
                this.reload() 
            }).catch(error=>{
                console.log(error)
            })   
        },
        deleteJinPinPurchaseQuantity(number){
            let postData = this.qs.stringify({
                shoppingCartJinPinNumber: number,
                jinPinBuyingUser: VueCookies.get("username"),
            });
            this.axios({
                method: 'post',
                url: '/ShoppingCart/deleteShoppingCartData',    
                data: postData  
            }).then(response=>{
                this.infor = response.data
                this.reload() 
            }).catch(error=>{
                console.log(error)
            })   
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
                this.quitByEnd(),
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
        'v-topNavigation': topNavigation,
        'v-bottomCommunication': bottomCommunication,
    },
})
</script>

<style scoped>
#background_style{
    position: absolute;
    width: 80%;
    /* height: auto; */
    top: 17%;
    left: 5%;
}
#shopping_cart_style{
    border: solid;
    background-color: rgba(100, 149, 239, 0.2);
    width: 80%;
    height: 30%;
    border-radius: 15px;
    margin-top: 1%;
}
#modify_jinPin_purchase_quantity{
    font-size: 1vw;
    border: solid;
}
#jinpin_image_style{
    width: 80%;
    height: 80%;
    margin-top: 5%;
    margin-left: 5%;
    border: solid;
}
#welcome_sentence_style{
    font-size: 1.5vw;
    position: absolute;
    margin-top: 6.5%;
    margin-left: 40%;
    font-family: STFangsong;
}
#name_style{
    font-weight: 900;
}
#name_style:hover{
    color: blue;
}
#cue_sentence_style{
    position: absolute;
    font-size: 3vw;
    top: 25%;
    left: 20%;
    font-weight: 900;
    font-family: STFangsong;
}
</style>
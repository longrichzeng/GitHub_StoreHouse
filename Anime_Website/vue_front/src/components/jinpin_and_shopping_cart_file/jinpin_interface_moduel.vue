<template>
    <div>
        <v-topNavigation></v-topNavigation>
        <!-- <v-bottomCommunication></v-bottomCommunication> -->
        <el-button id="shopping_cart_icon_style" type="text" class="el-icon-shopping-cart-1" @click="toShoppingCart">购物车</el-button>
            <el-row id="background_style">
                <el-col style="margin-top: 3%; margin-bottom: 3%; margin-left: 3.3%; background-color: white" v-for="(img,index) in otherinfor" :key="index" :span="5">
                    <div style="border: 2px cornflowerblue solid;">
                        <img id="jinpin_image_style" :src="require('../../assets/jinpinImage/' + otherinfor[index].jinPinNumber + '.png')" />
                        <div style="border-top-style: solid;">
                            <p style="font-size: 1.5vw; font-weight: 900; font-family: STFangsong; white-space: nowrap;">
                                &emsp;{{otherinfor[index].jinPinPrice}}
                                &emsp;&emsp;&emsp;&emsp;<el-button @click="addJinpinInShoppingCart(otherinfor[index].jinPinNumber, otherinfor[index].jinPinPrice)" id="put_thing_in_shopping_cart" type="text" class="el-icon-shopping-cart-1"></el-button>
                            </p>                    
                            <p style="font-size: 1.3vw; font-weight: 900; font-family: STFangsong; ">
                                &emsp;{{otherinfor[index].jinPinName}}.{{otherinfor[index].jinPinType}}
                            </p>
                        </div>
                    </div>
                </el-col>
            </el-row>
    </div>
</template>

<script>
import topNavigation from '../universal_moduel_file/top_navigation_moduel.vue';
import bottomCommunication from '../universal_moduel_file/bottom_communication_moduel.vue';
import VueCookies from 'vue-cookies';
import {Base64} from 'js-base64';
export default({
    data(){
        return{
            infor: {},
            otherinfor: {}
        }
    },
    created(){
        this.axios({
            method: 'post',
            url: '/administrator/getJinpinModelData',          
        }).then(response=>{
            this.otherinfor = response.data
        }).catch(error=>{
            console.log(error)
        })
    },
    methods:{
        addJinpinInShoppingCart(number, price){
            if(VueCookies.get("username") != null && VueCookies.get("userPermission") != null && VueCookies.get("token") != null){
                let postData = this.qs.stringify({
                    shoppingCartJinPinNumber: number,
                    jinPinBuyingUser: VueCookies.get("username"),
                    jinPinPrice: price,
                    jinPinPurchaseQuantity: 1,
                    jinPinTotalPrice: null
                });
                this.axios({
                    method: 'post',
                    url: '/ShoppingCart/addJinpinToShoppingCart',    
                    data: postData  
                }).then(response=>{
                    this.infor = response.data
                    this.$message({
                        type: 'success',
                        message: "成功加入购物车！"
                    })
                }).catch(error=>{
                    console.log(error)
                })
            }else{
                this.$message({
                    type: 'warning',
                    message: "请先进行登陆操作或注册账号！"
                })
                this.$router.replace("login_register_main_interface")
            }
        },
        toShoppingCart(){
            let username = VueCookies.get("username")
            let token = VueCookies.get("token")
            let userPermission = VueCookies.get("userPermission")
            let tempToken = "administrator" + username
            for(let i = 0; i < 5; i++){
                tempToken = Base64.encode(tempToken)
            }
            if(username != null && token != null && userPermission != null && tempToken == token){
                this.$router.replace("shopping_cart_moduel")
            }else{
                this.$message({
                    type: 'warning',
                    message: "请先进行登陆操作或注册账号！"
                })
                this.$router.replace("login_register_main_interface")
            }
        }
    },
    components:{
        'v-topNavigation': topNavigation,
        'v-bottomCommunication': bottomCommunication,
    },
})
</script>

<style scoped>
#shopping_cart_icon_style{
    position: absolute;
    width: 10%;
    height: 10%;
    top: 12%;
    left: 80%;
    font-size: 2vw;
}
#put_thing_in_shopping_cart{
    width: 20%;
    height: 20%;
    font-size: 3vw
}
#background_style{
    background-color: rgba(100, 149, 239, 0.2);
    position: absolute;
    width: 90%;
    height: auto;
    top: 20%;
    left: 5%;
    border-radius: 15px;
}
#jinpin_image_style{
    width: 100%;
    height: 100%
}
.el-row{
    display:flex;
    flex-wrap: wrap;
}
</style>
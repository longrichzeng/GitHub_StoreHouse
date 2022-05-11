import Vue from 'vue'
import Router from 'vue-router'
import VueCookies from 'vue-cookies'
import {Base64} from 'js-base64'

const login_register_main_interface = () => import('../components/login_register_interface_file/login_register_main_interface')
const main_interface = () => import('../components/main_interface_moduel_file/main_interface')

const jinpin_interface_moduel = () => import('../components/jinpin_and_shopping_cart_file/jinpin_interface_moduel')
const shopping_cart_moduel = () => import('../components/jinpin_and_shopping_cart_file/shopping_cart_moduel')
const log_board_interface = () => import('../components/log_board_file/log_board_interface')
const anime_display_interface = () => import('../components/anime_display_file/anime_display_interface')

const individual_main_interface = () => import('../components/individual_interface_file/individual_main_interface')

const administrator_main_interface = () => import('../components/administrator_system_file/administrator_main_interface')

const includPush = Router.prototype.push
	Router.prototype.push = function push(location) {
  		return includPush.call(this, location).catch(err => err)
	}
Vue.use(Router)

const routes = [
  {
    path: '',
    redirect: '/main_interface'
  },
  {
    path: '/login_register_main_interface',
    name: 'login_register_main_interface',
    component: login_register_main_interface
  },
  {
    path: '/main_interface',
    name: 'main_interface',
    component: main_interface
  },
  {
    path: '/jinpin_interface_moduel',
    name: 'jinpin_interface_moduel',
    component: jinpin_interface_moduel
  },
  {
    path: '/shopping_cart_moduel',
    name: 'shopping_cart_moduel',
    component: shopping_cart_moduel
  },
  {
    path: '/log_board_interface',
    name: 'log_board_interface',
    component: log_board_interface
  },
  {
    path: '/anime_display_interface',
    name: 'anime_display_interface',
    component: anime_display_interface
  },
  {
    path: '/individual_main_interface',
    name: 'individual_main_interface',
    component: individual_main_interface
  },
  {
    path: '/administrator_main_interface',
    name: 'administrator_main_interface',
    component: administrator_main_interface
  }
] 

const router = new Router({
  routes
})

router.beforeEach((to,from,next)=>{
  let username = VueCookies.get("username")
  let token = VueCookies.get("token")
  let userPermission = VueCookies.get("userPermission")
  let tempToken = "administrator" + username
  for(let i = 0; i < 5; i++){
    tempToken = Base64.encode(tempToken)
  }

  if(to.path === "/login_register_main_interface"){
    next();
  }else if(to.path === "/main_interface"){
    next();
  }else if(to.path === "/jinpin_interface_moduel"){
    next();
  }else if(to.path === "/shopping_cart_moduel"){
    if(username != null && token != null && userPermission != null && tempToken == token){
      next();
    }else{
      next("/login_register_main_interface");
    }
  }else if(to.path === "/log_board_interface"){
    next();
  }else if(to.path === "/anime_display_interface"){
    next();
  }else if(to.path === "/individual_main_interface"){
    if(username != null && token != null && userPermission != null && tempToken == token){
      next();
    }else{
      next("/login_register_main_interface");
    }
  }else if(to.path === "/administrator_main_interface"){
    if(username != null && token != null && userPermission == "Zeroer" && tempToken == token){
      next()
    }else{
      next("/login_register_main_interface");
    }
  }else{
    next();
  }
})
export default router;
import Vue from 'vue';
import App from './App';
import router from './router';

//导入第三方组件使用，有elementUI、echarts、axios、qs序列化、cookies、md5加密解密
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import VueCookies from 'vue-cookies'
import * as echarts from 'echarts';
import axios from 'axios';
import md5 from 'js-md5';
import qs from "qs";

//自定义js导入
// import Utils from './common/js/utils.js';
// Vue.prototype.utils=Utils;

Vue.use(ElementUI)
Vue.use(VueCookies)

Vue.prototype.$echarts = echarts;
Vue.prototype.axios = axios;
Vue.prototype.$md5 = md5;
Vue.prototype.qs = qs;
Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

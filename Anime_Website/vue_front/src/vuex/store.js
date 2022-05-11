import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    count: 1,
    toLogin: 'v-loginInterface',
    toRegister: 'v-registerInterface'
  },
  mutations: {
    modify_count(state, count){
      state.count = count
    },
  }  
})
export default store

import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import VueResource from "vue-resource"

//UI组件库
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.config.productionTip = false


//开启插件
Vue.use(ElementUI)
Vue.use(VueResource)



new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

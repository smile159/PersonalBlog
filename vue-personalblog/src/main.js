import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

//UI组件库
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.config.productionTip = false


//开启插件
Vue.use(ElementUI)
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

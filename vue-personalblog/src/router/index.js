import Vue from 'vue'
import VueRouter from 'vue-router'

//自定义组件
import Home from "@/components/Home";
import Login from "@/views/Login";

Vue.use(VueRouter)

const routes = [
  {
    path:'/',
    component:Home
  },
  {
    path: "/login",
    component: Login
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

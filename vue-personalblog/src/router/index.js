import Vue from 'vue'
import VueRouter from 'vue-router'

//自定义组件
import Home from "@/components/Home";
import Login from "@/views/Login";
import Test from "@/components/Test";
import Main from "@/components/layout/Main";

Vue.use(VueRouter)

const routes = [
  {
    path:'/',
    component:Home,
    redirect:"/main",
    children:[
      {
        path:"test",
        name:"test",
        component:Test
      },
      {
        path:"main",
        name:"main",
        component: Main
      }
    ]
  },
  {
    path: "/login",
    component: Login
  }
]

const router = new VueRouter({
  mode: 'hash',
  base: process.env.BASE_URL,
  routes
})

export default router

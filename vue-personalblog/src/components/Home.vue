<template>
  <div>
    <!--回到顶部-->
    <el-backtop :bottom="60" style="width: 70px;height: 70px">
      <div
          style="{
        height: 100%;
        width: 100%;
        background-color: #f2f5f6;
        box-shadow: 0 0 6px rgba(0,0,0, .12);
        text-align: center;
        line-height: 70px;
        color: #1989fa;
        border-radius: 50%;
        font-size: 25px;
      }"
      >
        UP
      </div>
    </el-backtop>
    <!--容器-->
    <el-container>
      <!--导航栏-->
      <el-header>
        <Header :userInfo="userinfo"></Header>
      </el-header>
      <!--主体内容-->
      <el-main class="el-main">
        <!--&lt;!&ndash;显示的内容&ndash;&gt;-->
        <!--<Main :userInfo="userinfo"></Main>-->
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>


<script>
//库
import axios from "axios"

//模块
import Header from "@/components/layout/Header";
import Main from "@/components/layout/Main";

export default {
  name: "Home",
  components: {Header, Main},
  data() {
    return {
      //定义用户的数据
      userinfo: {name: "xiaoxin", age: 18}
    }
  },
  mounted() {
    //测试axios是否正常
    //   axios.get("http://localhost:8080/test").then(response =>{
    //     console.log("请求成功!!!",response)
    //   },error => {
    //     console.log("请求失败！！！",error)
    //   }
    // )
  }
}
</script>

<style>

/*导航栏铺不满，因为内置了样式.el-header  有一个左右的20px像素值，可以覆盖就行了..*/
.el-container .el-header {
  /*取消左右的20px像素*/
  padding: 0;
}

/*去除内边距*/
.el-card .el-card__body {
  padding: 0;
}

.el-main {
  background-color: #E9EEF3;
  color: #333;
}

.el-divider--horizontal {
  margin: 0 !important;
}

</style>
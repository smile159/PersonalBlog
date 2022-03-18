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
    <el-container>
      <el-header>
        <!--导航栏-->
        <Header/>
      </el-header>
      <div>
        <el-main class="el-main">
          <!--显示的内容-->
          <Main/>
        </el-main>
      </div>

    </el-container>
  </div>
</template>


<script>

//模块
import Header from "@/components/layout/Header";
import Main from "@/components/layout/Main";

export default {
  name: "Home",
  components: {Header, Main},
  data() {
    return {}
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
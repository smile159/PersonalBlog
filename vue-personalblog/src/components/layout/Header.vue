<template>
  <div class="nav">
    <el-menu
        mode="horizontal"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b"
        ref="el-menu-head"
        router
    >
      <!--网站图标-->
      <el-menu-item index="/main">
        <a href="/">
          <img src="//lf3-cdn-tos.bytescm.com/obj/static/xitu_juejin_web/e08da34488b114bd4c665ba2fa520a31.svg"
               alt="稀土掘金" class="logo-img">
        </a>
      </el-menu-item>
      <!--博客/主页-->
      <el-menu-item index="2">博客</el-menu-item>
      <!--占位的-->
      <el-menu-item index="3">课程</el-menu-item>
      <!--占位的-->
      <el-menu-item index="4">直播</el-menu-item>

      <!--搜索框，搜索文章-->
      <el-menu-item index="5">
        <el-input
            placeholder="请输入内容"
            suffix-icon="el-icon-search"
            v-model="searchKey"
            @keydown.enter.native="searchArticle"
        >
        </el-input>
      </el-menu-item>
      <el-menu-item index="/test">组件测试</el-menu-item>
      <!--用户头像和昵称-->
      <el-submenu
          index="6"
          class="loginUser-head"
          popper-class="loginUser-item"
          v-if="isLogin"
      >
        <template>
          <template slot="title" style="color: #fff">
            <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
            <span class="loginUser-name">smileya</span>
          </template>
          <el-menu-item index="2-1">写文章</el-menu-item>
          <el-menu-item index="2-2">个人空间</el-menu-item>
          <el-menu-item index="2-3">我的收藏</el-menu-item>
          <el-menu-item index="2-4">我的点赞</el-menu-item>
          <el-menu-item index="2-5">浏览历史</el-menu-item>
          <el-menu-item index="2-6">退出</el-menu-item>
        </template>
      </el-submenu>
      <el-menu-item
          index="/login"
          class="loginUser-head"
          v-if="!isLogin"
      >
      未登录
      </el-menu-item>



    </el-menu>
  </div>
</template>

<script>
export default {
  name: "Header",
  props: ["userInfo"],
  data() {
    return {
      searchKey: "",
      isLogin: false
    }
  },
  computed: {},
  methods: {
    //  搜索文章
    searchArticle(v, a) {
      // console.log(this.searchKey)
      this.$message.success("您搜索的是" + this.searchKey)
    }
  },
  mounted() {
    console.log(this.userInfo)
  }
}
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
}

.nav {
  width: 100%;
}

.el-menu-item + .loginUser-head {
  font-size: 16px;
  float: right;
}

.loginUser-name {
  padding: 0 5px 0 10px;
}

.loginUser-item .el-menu-item {
  /*margin-left: 15px;*/
}
</style>
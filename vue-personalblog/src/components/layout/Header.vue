<template>
  <div class="nav">
    <el-menu
        mode="horizontal"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b"
        ref="el-menu-head"
        :router=false
    >
      <el-menu-item index="1">
        <a href="/">
          <img src="//lf3-cdn-tos.bytescm.com/obj/static/xitu_juejin_web/e08da34488b114bd4c665ba2fa520a31.svg"
               alt="稀土掘金" class="logo-img">
        </a>
      </el-menu-item>
      <el-menu-item index="2">博客</el-menu-item>
      <el-menu-item index="3">课程</el-menu-item>
      <el-menu-item index="4">直播</el-menu-item>
      <el-menu-item index="5">
        <el-input
            placeholder="请输入内容"
            suffix-icon="el-icon-search"
            v-model="searchKey"
            @keydown.enter.native="searchArticle"
        >
        </el-input>
      </el-menu-item>

      <el-submenu
          index="6"
          class="user-head"
          popper-class="user-item"
      >
        <template slot="title">
          <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
          <span class="user-name">smileya</span>
        </template>
        <el-menu-item index="2-1">写文章</el-menu-item>
        <el-menu-item index="2-2">个人空间</el-menu-item>
        <el-menu-item index="2-3">我的收藏</el-menu-item>
        <el-menu-item index="2-4">我的点赞</el-menu-item>
        <el-menu-item index="2-5">浏览历史</el-menu-item>
        <el-menu-item index="2-6">退出</el-menu-item>
      </el-submenu>


    </el-menu>
  </div>
</template>

<script>
export default {
  name: "Header",
  data() {
    return {
      searchKey: ""
    }
  },
  computed: {},
  methods: {
    //  搜索文章
    searchArticle(v, a) {
      // console.log(this.searchKey)
      this.$message.success("您搜索的是" + this.searchKey)
    }
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

.el-menu-item + .user-head {
  font-size: 16px;
  float: right;
}

.user-name {
  padding: 0 5px 0 10px;
}

.user-item .el-menu-item {
  /*margin-left: 15px;*/
}
</style>
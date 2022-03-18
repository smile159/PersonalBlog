<template>
  <div class="content">

    <!--左侧文章内容-->
    <div class="left">
      <ul
          class="infinite-list"
          v-infinite-scroll="load"
          infinite-scroll-disabled="disabled"
      >
        <li v-for="rObj in rData" class="infinite-list-item">
          <el-card class="box-card">
            <!--标题-->
            <div class="box-title">
              <a href="#">{{ rObj.title }}</a>
              <el-divider></el-divider>
            </div>

            <!--主体内容-->
            <div class="box-content">
              <a href="#">{{ rObj.content }}</a>
            </div>
            <!--标签-->
            <div class="box-tag">
              <el-tag>Java</el-tag>
              <el-tag>Python</el-tag>
            </div>
          </el-card>
        </li>
      </ul>
    </div>
    <!--右侧通告等-->
    <div class="right">
      <el-card class="box-notification">
        <h2>下午好</h2>
        <p>今日无事发生</p>
      </el-card>
    </div>
  </div>
</template>

<script>
export default {
  name: "Main",
  data() {
    return {
      count: 0,
      rData: [
        {
          title: "尤雨溪携手字节前端专家，畅聊 Vue 3.0 & 前端技术新趋势",
          content: "尤雨溪、月影、郭辉、屈光宇四位大咖陪你畅聊，狂送1000份稀土掘金睡眠眼罩",
          time: "10分钟前",
          author: "小馨"
        },
        {
          title: "基于 vite2 + Vue3 写一个在线帮助文档工具",
          content: "这是一个可以在线编写帮助文档的小工具（组件），基于vue3编写，可以在线编写代码、运行代码。有编辑和浏览两种状态。 非常方便好用。",
          time: "1小时前",
          author: "小小"
        },
        {
          title: "基于 vite2 + Vue3 写一个在线帮助文档工具",
          content: "这是一个可以在线编写帮助文档的小工具（组件），基于vue3编写，可以在线编写代码、运行代码。有编辑和浏览两种状态。 非常方便好用。",
          time: "1小时前",
          author: "小小"
        },
        {
          title: "基于 vite2 + Vue3 写一个在线帮助文档工具",
          content: "这是一个可以在线编写帮助文档的小工具（组件），基于vue3编写，可以在线编写代码、运行代码。有编辑和浏览两种状态。 非常方便好用。",
          time: "1小时前",
          author: "小小"
        },
        {
          title: "基于 vite2 + Vue3 写一个在线帮助文档工具",
          content: "这是一个可以在线编写帮助文档的小工具（组件），基于vue3编写，可以在线编写代码、运行代码。有编辑和浏览两种状态。 非常方便好用。",
          time: "1小时前",
          author: "小小"
        },
        {
          title: "基于 vite2 + Vue3 写一个在线帮助文档工具",
          content: "这是一个可以在线编写帮助文档的小工具（组件），基于vue3编写，可以在线编写代码、运行代码。有编辑和浏览两种状态。 非常方便好用。",
          time: "1小时前",
          author: "小小"
        },
        {
          title: "基于 vite2 + Vue3 写一个在线帮助文档工具",
          content: "这是一个可以在线编写帮助文档的小工具（组件），基于vue3编写，可以在线编写代码、运行代码。有编辑和浏览两种状态。 非常方便好用。",
          time: "1小时前",
          author: "小小"
        },
        {
          title: "基于 vite2 + Vue3 写一个在线帮助文档工具",
          content: "这是一个可以在线编写帮助文档的小工具（组件），基于vue3编写，可以在线编写代码、运行代码。有编辑和浏览两种状态。 非常方便好用。",
          time: "1小时前",
          author: "小小"
        },
        {
          title: "基于 vite2 + Vue3 写一个在线帮助文档工具",
          content: "这是一个可以在线编写帮助文档的小工具（组件），基于vue3编写，可以在线编写代码、运行代码。有编辑和浏览两种状态。 非常方便好用。",
          time: "1小时前",
          author: "小小"
        },
        {
          title: "基于 vite2 + Vue3 写一个在线帮助文档工具",
          content: "这是一个可以在线编写帮助文档的小工具（组件），基于vue3编写，可以在线编写代码、运行代码。有编辑和浏览两种状态。 非常方便好用。",
          time: "1小时前",
          author: "小小"
        },
        {
          title: "基于 vite2 + Vue3 写一个在线帮助文档工具",
          content: "这是一个可以在线编写帮助文档的小工具（组件），基于vue3编写，可以在线编写代码、运行代码。有编辑和浏览两种状态。 非常方便好用。",
          time: "1小时前",
          author: "小小"
        }
      ]
    }
  },
  computed: {
    noMore() {
      return this.count >= 20
    },
    disabled() {
      return this.loading || this.noMore
    }
  },
  methods: {
    load() {
      this.loading = true
      setTimeout(() => {
        this.count += 2
        this.loading = false
      }, 2000)
    }
  }
}
</script>

<style>
li {
  list-style: none;
}

.left {
  float: left;
  width: 1160px;
  /*background-color: black;*/
  margin-left: 5%;
}

.right {
  float: right;
}

.text {
  font-size: 14px;
}

.box-card {
  width: 100%;
  height: 140px;
}

.box-title {
  height: 50px;
  /*background-color: pink;*/
  line-height: 50px;
  padding: 0 30px;
}

.box-title a {
  font-size: 18px;
  text-decoration: none;
  color: #333333;
  font-weight: 700;
}

.box-content {
  height: 50px;
  /*background-color: skyblue;*/
  line-height: 50px;
}

.box-content a {
  font-size: 14px;
  text-decoration: none;
  color: #86909c;
  padding: 0 30px;
}

.box-tag {
  margin: 0 20px;
}

.box-tag .el-tag {
  margin: 0 5px;
}


.infinite-list-item {
  margin: 5px 0;
}


.box-notification {
  width: 400px;
  height: 200px;
  background-color: pink;
  margin-right: 150px;
}

.box-notification h2 {
  padding: 10px 20px;
}

.box-notification p {
  padding: 10px 20px;
}


</style>
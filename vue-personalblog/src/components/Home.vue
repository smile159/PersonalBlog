<template>
  <div>
    <el-button type="primary" @click="getData">点我获取数据</el-button>
    <el-card class="boxCard" v-show="serverData">
      <div>hhh</div>
    </el-card>
  </div>


</template>

<style>
.boxCard{
  width: 200px;
  height: 200px;
  margin: 0 auto;
}
</style>

<script>
import axios from "axios"
export default {
  name: "Test",
  data(){
    return{
      serverData:''//服务器数据
    }
  },
  methods:{
    getData(){
      axios.get("http://localhost:8080/getData").then(response =>{
        this.$message.success("请求成功");
        this.serverData = response.data;//写入数据到data
      },
      error => {
        this.$message.error("请求失败",error.message);
      })
    }
  }
}
</script>

<style scoped>

</style>
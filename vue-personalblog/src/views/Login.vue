<template>
  <div id="bj">
    <div class="login-box">
      <el-card>
        <h2 class="login-title">登录</h2>
        <!-- 手机号/用户名/邮箱/密码-->
        <div class="name_pass">
          <el-input
              placeholder="请输入手机号 / 用户名 / 邮箱"
              prefix-icon="el-icon-user"
              v-model="loginData.u">
          </el-input>
          <el-input
              placeholder="请输入密码"
              prefix-icon="el-icon-lollipop"
              v-model="loginData.p">
          </el-input>
          <div>
            <el-checkbox v-model="remember" label="1" class="remember-user">记住我</el-checkbox>
            <a href="#" class="lost-pass">忘记密码？</a>
          </div>
          <el-button round class="loginBtn" @click="login">芝麻开门</el-button>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
//库
import axios from "axios";


export default {
  name: "Login",
  data() {
    return {
      loginData: {
        u: "",
        p: ""
      },
      remember: false
    }
  },
  methods: {
    //用户登录
    login() {
      // 数据校验
      if (this.loginData.u === "") {
        this.$message.error("用户名不能为空")
        return
      }
      if (this.loginData.p === "") {
        this.$message.error("密码不能为空")
        return
      }
      // 数据通过以后开始发送请求到服务器验证
      axios.post("http://127.0.0.1:8080/login",{
        u:this.loginData.u,
        p:this.loginData.p
      }).then(res => {
        if (res.data.status === "1"){
          this.$message.success(res.data.msg)
        }else {
          this.$message.error(res.data.msg)
        }
      },err =>{
        console.log("err = ",err)
      })
    }
  }
}
</script>

<style scoped>
/*背景-渐变色*/
#bj {
  width: 100%;
  height: 100%;
  background: linear-gradient(to right, rgb(199, 210, 254), rgb(254, 202, 202), rgb(254, 249, 195));
}

/*登录盒子*/
.login-box {
  position: absolute;
  left: 50%;
  margin-left: -250px;
  top: 50%;
  margin-top: -250px;
}

.login-box .login-title {
  background: linear-gradient(to right, rgb(249, 168, 212), rgb(216, 180, 254), rgb(129, 140, 248));
  /* 将文字区域剪裁出来 */
  -webkit-background-clip: text;
  /* 将文字颜色改为透明色 */
  color: transparent;
  text-align: center;
  margin-top: 10%;
}

/*登录卡片*/
.el-card {
  width: 500px;
  height: 500px;
}

/*输入框的盒子*/
.name_pass {
  position: absolute;
  top: 30%;
  width: 460px;
  padding: 0 20px;
}

.name_pass .el-input {
  padding: 5px 0;
}

.name_pass .loginBtn {
  margin-top: 30px;
  width: 460px;
}

.name_pass .loginBtn:hover,.loginBtn:active {
  background: linear-gradient(to right top, rgb(254, 202, 202), rgb(252, 165, 165), rgb(254, 240, 138));
  color: #333333;
  border-color: transparent;
}

.name_pass .remember-user {
  margin-top: 20px;
}

.name_pass .lost-pass {
  font-size: 16px;
  margin-top: 18px;
  float: right;
  color: #1989fa;
  text-decoration: none;
}


</style>
<template>
  <div id="bj">
    <div class="login-box">
      <el-card>
        <!-- 手机号/用户名/邮箱/密码  登录界面-->
          <div :class="loginClass" ref="loginDiv">
            <h2 class="title">登录</h2>
            <el-input
                placeholder="请输入手机号 / 用户名 / 邮箱"
                prefix-icon="el-icon-loginUser"
                v-model="loginData.u">
            </el-input>
            <el-input
                placeholder="请输入密码"
                prefix-icon="el-icon-lollipop"
                :show-password=true
                v-model="loginData.p">
            </el-input>
            <div>
              <el-checkbox v-model="remember" label="1" class="remember-loginUser">记住我</el-checkbox>
              <a href="#" class="lost-pass">忘记密码？</a>
            </div>
            <el-button round class="loginBtn" @click="toLogin">芝麻开门</el-button>
            <div class="goRegister" @click="moveRegisterDiv">没有账号？立即注册</div>
          </div>

      <!-- 注册界面 -->
        <div :class="registerClass">
          <h2 class="title">注册</h2>
          <el-input
              placeholder="请输入用户名"
              prefix-icon="el-icon-loginUser"
              v-model="registerData.u"
              :validate-event="true"
          >
          </el-input>
          <el-input
              placeholder="请输入密码"
              prefix-icon="el-icon-lollipop"
              :show-password="true"
              v-model="registerData.p">
          </el-input>
          <el-input
              placeholder="请确认密码"
              prefix-icon="el-icon-lollipop"
              :show-password="true"
              v-model="registerData.cp">
          </el-input>
          <el-input
              placeholder="请输入邮箱"
              prefix-icon="iconfont icon-youxiang"
              v-model="registerData.e">
          </el-input>
          <el-button round class="loginBtn" @click="toRegister">打开新世界大门</el-button>
          <div class="goLogin" @click="moveLoginDiv">已有账号？立即登录</div>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
//库
import axios from "axios";
import '../assets/icon/iconfont.css';
export default {
  name: "Login",
  data() {
    return {
      // 用户登录的数据
      loginData: {
        u: "smile",
        p: "123456"
      },
      // 用户注册的数据
      registerData:{
        u:"",
        p:"",
        cp:"",
        e:""
      },
      remember: false,
      loginClass:['name_pass'],
      registerClass:['register']
    }
  },
  methods: {
    //用户登录
    toLogin() {
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
        if (res.data.status === 1){
          this.$message.success(res.data.msg)
        }else {
          this.$message.error(res.data.msg)
        }
      },err =>{
        console.log("err = ",err)
      })
    },
    toRegister(){
      axios.post("http://127.0.0.1:8080/register",{
        rName:this.registerData.u,
        rPass:this.registerData.p,
        rePass:this.registerData.cp,
        email:this.registerData.e
      }).then(
          res =>{
            this.$message.success(res.data.msg)
          },
          err =>{
            console.log("注册错误,err = ",err)
          }
      )
    },
    moveRegisterDiv(){
      this.loginClass.push("switch_register")
      // 删除switch_login
      this.loginClass = this.loginClass.filter( item =>{
        return item !== "switch_login";
      })
    },
    moveLoginDiv(){
      this.loginClass.pop();
      this.loginClass.push("switch_login")
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

/*登录卡片*/
.el-card {
  width: 500px;
  height: 500px;
}

/*输入框的盒子*/
.name_pass {
  /*display: none;*/
  width: 460px;
  height: 500px;
  padding: 0 20px;
  transition: all 1s;
  /*background-color: skyblue;*/
}

/*将页面内容切换到注册页面*/
.switch_register {
  /*触发的动画为moveRegister 用时1s 速度曲线为ease 在终点停下*/
  animation: moveRegister 1s ease forwards;
}

/*将页面内容切换到登录页面*/
.switch_login {
  animation: moveLogin 1s ease forwards;
}



.el-card .title {
  padding: 30px;
  background: linear-gradient(to right, rgb(249, 168, 212), rgb(216, 180, 254), rgb(129, 140, 248));
  /* 将文字区域剪裁出来 */
  -webkit-background-clip: text;
  /* 将文字颜色改为透明色 */
  color: transparent;
  text-align: center;
}


.el-card .el-input {
  padding: 6px 0;
}

.el-card .loginBtn {
  margin-top: 30px;
  width: 460px;
}

.el-card .loginBtn:hover,.loginBtn:active {
  background: linear-gradient(to right top, rgb(254, 202, 202), rgb(252, 165, 165), rgb(254, 240, 138));
  color: #333333;
  border-color: transparent;
}

.name_pass .remember-loginUser {
  margin-top: 20px;
}

.name_pass .lost-pass {
  font-size: 16px;
  margin-top: 18px;
  float: right;
  color: #1989fa;
  text-decoration: none;
}

/*立即注册*/
.name_pass .goRegister,.el-card .goLogin {
  background: linear-gradient(to right, rgb(249, 168, 212), rgb(216, 180, 254), rgb(129, 140, 248));
  /* 将文字区域剪裁出来 */
  -webkit-background-clip: text;
  /* 将文字颜色改为透明色 */
  color: transparent;
  text-align: center;
  padding: 60px 0;
}

/*注册界面的父div*/
.register {
  width: 460px;
  height: 500px;
  /*background-color: saddlebrown;*/
  margin: 0 auto;
  transition: all 1s;
}

/*定义登录切换到注册的动画*/
@keyframes moveRegister {
  0% {
    margin-top: 0;
  }
  100% {
    margin-top: -500px;
  }
}

/*定义从注册切换到登录的界面*/
@keyframes moveLogin {
  0% {
    margin-top: -500px;
  }
  100% {
    margin-top: 0;
  }
}

</style>
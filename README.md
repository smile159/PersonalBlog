# PersonalBlog
个人博客系统开发

# 开发记录
## 2022/3/18
### 实现内容
* Header组件左侧添加导航，右侧添加头像
* Main组件添加了文章的内容，右侧通告模块
* 增加导航栏搜索框，可以搜索文章，具体功能未实现
* 页面滑动一定距离出现回到顶部的按钮
### 待实现(新功能，计划内容)
    1.底部备案、友情链接等
### 待解决
    1.导航栏点击搜索框，头像框会改变文字颜色以及底部出现一个下边框
    1.文章的标题和内容只有在a标签上才会跳转，其他地方不会跳转，需要增加跳转的面积（√）

## 2022/3/22
### 实现内容
* 新建数据库pb，新建表user
* 后端添加mybatis，mysql驱动，添加了简单的登录功能
* 前端添加了登录页面、axios，可以与后端进行交互
* 配置CROS跨域请求处理

###待实现
    1.前端注册页面(√)
    2.前端登录和未登录对应不同的导航栏
    3.登录成功后跳转到主页进入并提示用户成功登录
    4.点击文章需要先登录

### 待解决
    1.登录按钮有时出现蓝色背景


## 2022/3/23
### 实现内容
* 注册页面，以及注册页面和登录页面的切换动画效果

###待实现
    1.对注册的数据进行校验，通过后提交到服务器上
    2.注册完成后转到登录页或者直接进入主页(现在还不确定)，如果转入到登录页就直接填好账号，密码留空

### 待解决
    1.切换动画感觉不流畅
# WeChat-Sell

基于 Spring Boot、JPA、MySQL、Redis、HTML/CSS/JavaScript、vue.js 的微信点餐系统。

实现的功能：卖家后台的商品信息的增删改查，微信客户端的点餐功能(除支付外)。

实现：使用 HTML/CSS/JavaScript 设计卖家后端页面，使用 Vue.js 前端框架设计手机微信点餐客户端，MySQL用于商品信息、订单信息及卖家信息存储，Redis 应用于卖家端登录时缓存 token，Spring Boot + JPA 应用于所有数据传输层。基本实现了点餐功能，除微信支付以外，微信支付需要认证商家才能提供对应支付接口，暂未实现。

使用开发工具：IDEA(编写业务代码以及启动卖家端后台服务)、natapp(内网穿透)、node.js(用于运行买家端服务)

### 卖家端

卖家端登录页面：

![登录页面](https://github.com/LiuLixy/image/blob/master/seller_login.png)

登陆中：

![登陆中](https://github.com/LiuLixy/image/blob/master/login.png)

登陆成功：

![登陆成功](https://github.com/LiuLixy/image/blob/master/login_success.png)

后台管理：

![订单主页面](https://github.com/LiuLixy/image/blob/master/main.png)

![添加商品](https://github.com/LiuLixy/image/blob/master/insert_page.png)

### 买家端

![主页面](https://github.com/LiuLixy/image/blob/master/weixin_main_page.jpg)

![购物车](https://github.com/LiuLixy/image/blob/master/cart.jpg)

![订餐页面](https://github.com/LiuLixy/image/blob/master/order_detail_page.jpg)

![订单详情页面](https://github.com/LiuLixy/image/blob/master/order_info_page.jpg)
1.项目需求
  模拟当当网部分功能.在线购物系统(电子商务)
 (1)产品浏览模块(main)
    主界面,类别浏览界面
 (2)购物车模块(cart)
    添加,更改数量,删除,恢复购买,金额统计等
 (3)用户模块(user)
    登录,注册
 (4)订单模块(order)
    创建订单-->确认,填写送货地址,成功提示
2.项目技术架构
  整体基于MVC思想,实现分层设计
  (1)显示层(V)
     JSP,jQuery,Ajax,Struts2标签+OGNL表达式
  (2)控制层(C)
     Struts2控制器,struts.xml配置
  (3)业务层(M)
     Action组件
  (4)数据访问层(M)
     DAO组件,JDBC技术
3.项目文件的结构
  (1)src目录结构
    com.tarena.action
    com.tarena.action.main 产品浏览Action
    com.tarena.action.cart 购物车Action
    com.tarena.action.order 订单Action
    com.tarena.action.user 用户模块Action
    com.tarena.dao DAO接口
    com.tarena.dao.impl DAO实现
    com.tarena.util 工具类
    com.tarena.interceptor 拦截器组件
    com.tarena.entity 实体类
    com.tarena.service 服务器接口
    com.tarena.service.impl 接口实现
  (2)Web-Root文件目录
     /Web-Root/user/    用户模块JSP
     /Web-Root/cart/    购物车JSP
     /Web-Root/order/   订单JSP
     /Web-Root/main/    产品浏览JSP
     /Web-Root/common/  页眉页脚等公共JSP
     /Web-Root/css/     样式文件
     /Web-Root/js/      javascript脚本
     /Web-Root/images/  界面图片
     /Web-Root/productImages/ 产品图片
   (3)配置文件
      a.struts配置文件
        struts.xml       系统主配置
        struts-user.xml  用户模块
        struts-main.xml  产品浏览模块
        struts-order.xml 订单模块
        struts-cart.xml  购物车模块
       b.web.xml
         配置Struts2控制器
4.数据库设计
  (1)d_user:用户信息表
  (2)d_product:产品信息表
  (3)d_book:图书信息表
  (4)d_category:类别信息
  (5)d_category_product:类别和产品对应关系
  (6)d_order:订单信息表
  (7)d_item:订单明细表,存储了某个订单买了哪些商品
  (8)d_receive_address:送货地址表

5.引入jar包
  struts2核心包
  数据库驱动
  struts2-json-plugin.jar


我的购物车：http://localhost:8080/T-GWAP/cart/cart_list.jsp
页脚1：http://localhost:8080/T-GWAP/common/foot.jsp
页脚2：http://localhost:8080/T-GWAP/common/foot1.jsp
页眉1：http://localhost:8080/T-GWAP/common/head.jsp
页眉2：http://localhost:8080/T-GWAP/common/head1.jsp
介绍：http://localhost:8080/T-GWAP/common/introduce.jsp
地址表单所需js：js/address_form.js
放大镜js：js/jqzoom.js
登录表单js：js/login_form.js
注册表单js：js/register_form.js
验证表单js：js/verify_form.js
书籍详细：http://localhost:8080/T-GWAP/main/book_info.jsp
主页：http://localhost:8080/T-GWAP/main/main.jsp
书籍分类：http://localhost:8080/T-GWAP/main/book_list.jsp
类别：http://localhost:8080/T-GWAP/main/category.jsp
热卖：http://localhost:8080/T-GWAP/main/hot.jsp
新书：http://localhost:8080/T-GWAP/main/new.jsp
推荐：http://localhost:8080/T-GWAP/main/recommend.jsp
地址表单：http://localhost:8080/T-GWAP/order/address_form.jsp
定单信息：http://localhost:8080/T-GWAP/order/order_info.jsp
定单成功：http://localhost:8080/T-GWAP/order/order_ok.jsp
帮助页面：http://localhost:8080/T-GWAP/user/help.jsp
登陆页面：http://localhost:8080/T-GWAP/user/login_form.jsp
注册页面：http://localhost:8080/T-GWAP/user/register_form.jsp
验证页面：http://localhost:8080/T-GWAP/user/verify_form.jsp
邮箱验证码通过：http://localhost:8080/T-GWAP/user/register_ok.jsp
错误：http://localhost:8080/T-GWAP/error.jsp
索引页面：http://localhost:8080/T-GWAP/index.jsp
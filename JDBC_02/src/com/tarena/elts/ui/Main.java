package com.tarena.elts.ui;

import com.tarena.elts.dao.UserDao;

public class Main {
  public static void main(String[] args) {
    // 创建所有对象, 注入, 解决依赖关系
    LoginFrame loginFrame = new LoginFrame();

    WelcomeWindow welcomeWindow = new WelcomeWindow();
    ClientContext clientContext = new ClientContext();
    UserDao userDao = new UserDao();
    clientContext.setUserDao(userDao);

    clientContext.setWelcomeWindow(welcomeWindow);

    loginFrame.setClientContext(clientContext);
    clientContext.setLoginFrame(loginFrame);

    // 使用show()显示登录界面
    clientContext.show();
  }

}

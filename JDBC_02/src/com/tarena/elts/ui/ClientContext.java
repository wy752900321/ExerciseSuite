package com.tarena.elts.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.tarena.elts.dao.UserDao;
import com.tarena.elts.entity.User;

/** 客户界面控制器: 客户端上下文环境 */
public class ClientContext {
  private UserDao userDao;

  public UserDao getUserDao() {
    return userDao;
  }

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

  // private LoginFrame loginFrame = new LoginFrame();
  private LoginFrame loginFrame;

  /** 依赖注入(IOC) 这里注入的是loginFrame是实例 */
  public void setLoginFrame(LoginFrame loginFrame) {
    this.loginFrame = loginFrame;
  }

  private WelcomeWindow welcomeWindow;

  public void setWelcomeWindow(WelcomeWindow welcomeWindow) {
    this.welcomeWindow = welcomeWindow;
  }

  /**
   * 显示软件的开始界面, 先显示登录界面 show()方法的运行, 必须依赖于 loginFrame变量引用 具体的界面对象,
   * 这个界面对象必须依赖方法setLoginFrame() 注入, 注入这个界面对象实例!
   **/
  public void show() {
    loginFrame.setVisible(true);
  }

  /**
   * 此方法被 login按钮调用! 登录系统, 控制逻辑 1 从登录界面获得用户的ID和pwd 2 调用业务模型的login方法完成登录功能 3
   * 根据登录的结果, 如果成功就 更新菜单界面,显示用户信息 关闭登录界面, 打开菜单界面 4 如果登录失败就在登录界面上显示失败消息
   */
  public void login() {
    try {
      System.out.println("login");
      int id = loginFrame.getUserId();
      String pwd = loginFrame.getPassword();
      User user = userDao.findUserByIdAndPwd(id, pwd);
      if (user != null) {
        System.out.println("登录成功!!!");
      } else {
        System.out.println("登录失败!!!");
      }
    } catch (Exception e) {
      // 显示错误界面....
    }
  }

  /**
   * 退出系统 控制逻辑
   * 
   * @param source
   *          代表从哪一个界面退出. 是一个窗口的引用
   */
  public void exit(JFrame source) {
    // Confirm 确认
    // Dialog 对话框
    int val = JOptionPane.showConfirmDialog(source, "离开吗?");
    if (val == JOptionPane.YES_OPTION) {
      System.exit(0);// 结束当前Java进程
    }
  }
}

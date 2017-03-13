package com.tarena.elts.ui;

import com.tarena.elts.entity.User;
import com.tarena.elts.service.ExamService;
import com.tarena.elts.service.IdOrPwdException;

/** 客户界面控制器；客户端上下文环境 */
public class ClientContext {
	// private LoginFrame loginFrame = new LoginFrame();//自己造，不好

	private LoginFrame loginFrame;// 默认null,获得，注入，对象注入,依赖注入

	/** 依赖注入(IOC) 这里注入的是loginFrame是实例,汽车与汽油的关系 */
	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}

	private ExamService examService;// 创建对象examService

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	private MenuFrame menuFrame;

	public void setMenuFrame(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}

	/**
	 * 显示软件的开始界面,先显示登录界面 show()方法的运行必须依赖于loginFrame变量引用具体的界面对象,
	 * 这个界面对象必须依赖方法setLoginFrame()进行注入,注入这个界面对象实例！
	 */
	public void show() {
		loginFrame.setVisible(true);// 显示界面
	}

	/**
	 * 此方法被login按钮调用 登陆系统，控制逻辑 
	 * 		1.从登录界面获得用户的ID和pwd 
	 * 		2.调用业务模型的login方法完成登录功能
	 *	 	3.根据登陆的结果，如果成功就更新菜单界面，显示用户信息 关闭登录界面，打开菜单界面
	 *		4.如果登录失败就在登陆界面上显示失败消息
	 */
	public void login() {
		try {
			// 1.从登录界面获取ID和pwd
			int id = loginFrame.getUserId();// 用户输入的id
			String pwd = loginFrame.getPassword();
			// 2.调用业务模型的登录功能
			// examService.login()引用接口的类型，引用类型绑定到对象上。方法也绑定到对象上。调用业务模型
			User user = examService.login(id, pwd);
			// 3.如果登录成功就关闭登录界面，打开菜单界面
			// menuFrame.updateView(user);//更新菜单界面
			loginFrame.setVisible(false);
			menuFrame.setVisible(true);
		  }catch(IdOrPwdException e){
	        e.printStackTrace();
	        loginFrame.showMessage("登录失败:"+e.getMessage());
	      }catch(NumberFormatException e){
	        e.printStackTrace();
	        loginFrame.showMessage("ID 必须是整数");
	      }catch(Exception e){
	        e.printStackTrace();
	        loginFrame.showMessage("登录失败:"+e.getMessage());
	      }
	}

}

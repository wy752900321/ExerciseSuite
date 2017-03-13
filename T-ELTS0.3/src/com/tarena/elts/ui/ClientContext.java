package com.tarena.elts.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;
import com.tarena.elts.service.ExamService;
import com.tarena.elts.service.IdOrPwdException;

/** 客户界面控制器；客户端上下文环境 
 *  3) 创建控制器类ClientContext类, 添加登录响应方法
 *  4) 创建控制器类ClientContext类, 中添加界面对象引用和
 		注入方法. 达到控制器能够操作这些对象的目的 
 */
public class ClientContext {
	// private LoginFrame loginFrame = new LoginFrame();//自己造，不好

	private LoginFrame loginFrame;// 默认null,获得，注入，对象注入,依赖注入
	/** 依赖注入(IOC) 这里注入的是loginFrame是实例,汽车与汽油的关系 */
	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}
	/**
	 * 7) 为ClientContext 增加业务层接口的引用
  			private ExamService examService;
  			public void setExamService(ExamService examService) {
    			this.examService = examService;
  			}
	 */
	private ExamService examService;// 创建对象examService

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}
//	private WelcomeWindow welcomeWindow;
//	public void setWelcomeWindow(WelcomeWindow welcomeWindow) {
//		this.welcomeWindow = welcomeWindow;
//	}
	private ExamFrame examFrame;
	public void setExamFrame(ExamFrame examFrame) {
		this.examFrame = examFrame;
	}
	private MenuFrame menuFrame;
	public void setMenuFrame(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}
	/**
	 * 9) 为ClientContext 增加show() 方法, 用来显示软件界面.
	 * 显示软件的开始界面,先显示登录界面 show()方法的运行必须依赖于loginFrame变量引用具体的界面对象,
	 * 这个界面对象必须依赖方法setLoginFrame()进行注入,注入这个界面对象实例！
	 */
	public void show() {
		loginFrame.setVisible(true);// 显示界面
	}

	/**
	 * 4. 实现退出系统的功能 1) 为ClientContext添加exit方法
	 */
	public void exit(JFrame from){
		int val = JOptionPane.showConfirmDialog(from, "确定要离开吗？");
		if(val==JOptionPane.YES_OPTION){
			System.exit(0);//系统退出
		}
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
			menuFrame.setVisible(true);
			loginFrame.setVisible(false);
			menuFrame.updateView(user);//更新菜单界面
			
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
	public void start() {
		// 控制器, 增加事件响应方法start()
		  /** 开始考试 */
		try{
		ExamInfo examInfo = examService.startExam();
		//第一道题
		QuestionInfo questionInfo = examService.getQuestion(0);
		examFrame.updateView(examInfo,questionInfo);
		menuFrame.setVisible(false);
		examFrame.setVisible(true);
		}catch(Exception e){
			e.printStackTrace();
			 JOptionPane.showMessageDialog(menuFrame, e.getMessage());
		}
		
	}

}

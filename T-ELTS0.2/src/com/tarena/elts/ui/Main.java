package com.tarena.elts.ui;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.entity.User;
import com.tarena.elts.service.ExamService;
import com.tarena.elts.service.ExamServiceImpl;
import com.tarena.elts.service.IdOrPwdException;
import com.tarena.elts.util.Config;
//8. 创建整合测试 Main.class
public class Main{
	public static void main(String[] args) throws Exception {
		//初始化软件组件（零件）
		LoginFrame loginFrame = new LoginFrame();//登陆界面
		ExamFrame examFrame = new ExamFrame();	//答题界面
		MenuFrame menuFrame = new MenuFrame();
		WelcomeWindow welcomWindow = new WelcomeWindow();//闪屏
		ClientContext clientContext = new ClientContext();//客户界面控制器；客户端上下文环境 
		ExamServiceImpl service = new ExamServiceImpl();//核心业务功能实现类,登陆。。
		Config config = new Config("client.properties");//Config读取系统的配置文件
		EntityContext entityContext = new EntityContext(config);
		
		//组装组件
		service.setEntityContext(entityContext);
		loginFrame.setClientContext(clientContext);
		clientContext.setExamService(service);//examService
		clientContext.setLoginFrame(loginFrame);
		clientContext.setExamFrame(examFrame);
		clientContext.setMenuFrame(menuFrame);
		//clientContext.setWelcomeWindow(welcomeWindow);//错误未解决
		//启动软件界面
		clientContext.show();
		
	/*	//创建所有对象，注入，解决依赖关系
		LoginFrame loginFrame = new LoginFrame();
		MenuFrame menuFrame = new MenuFrame();
		ClientContext clientContext = new ClientContext();
		ExamService examService = new ExamService() {
			public User login(int id, String pwd) throws IdOrPwdException {
				if (id == 1 && pwd.equals("1234")) {
					return new User("贾东坡", 1, "1234");
				}
				throw new IdOrPwdException("登陆错误！");
			}
		};
		ExamServiceImpl examService = new ExamServiceImpl();
		Config config = new Congfig("client.properties");
		EntityContext entityContext = new EntityContext(config);
		
		examService.setEntityContext = new  EntityContext(config);
		
			clientContext.setExamService(examService);
			clientContext.setLoginFrame(loginFrame);
			clientContext.setMenuFrame(menuFrame);
			loginFrame.setClientContext(clientContext);
			
			//使用show()显示登录界面
			clientContext.show();*/
	}
}

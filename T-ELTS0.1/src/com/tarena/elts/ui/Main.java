package com.tarena.elts.ui;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.entity.User;
import com.tarena.elts.service.ExamService;
import com.tarena.elts.service.ExamServiceImpl;
import com.tarena.elts.service.IdOrPwdException;

public class Main{
	public static void main(String[] args) {
		//创建所有对象，注入，解决依赖关系
		LoginFrame loginFrame = new LoginFrame();
		MenuFrame menuFrame = new MenuFrame();
		ClientContext clientContext = new ClientContext();
		ExamService examService = new ExamService() {
			public User login(int id, String pwd) throws IdOrPwdException {
				if (id == 1001 && pwd.equals("1234")) {
					return new User("贾东坡", 1001, "1234");
				}
				throw new IdOrPwdException("登陆错误！");
			}
		};
//		ExamServiceImpl examService = new ExamServiceImpl();
//		Config config = new Congfig("client.properties");
//		EntityContext entityContext = new EntityContext(config);
//		
//		examService.setEntityContext = new  EntityContext(config);
		
			clientContext.setExamService(examService);
			clientContext.setLoginFrame(loginFrame);
			clientContext.setMenuFrame(menuFrame);
			loginFrame.setClientContext(clientContext);
			
			//使用show()显示登录界面
			clientContext.show();
	}
}

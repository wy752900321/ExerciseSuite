package com.tarena.elts.test;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.service.ExamServiceImpl;
import com.tarena.elts.ui.ClientContext;
import com.tarena.elts.ui.ExamFrame;
import com.tarena.elts.ui.LoginFrame;
import com.tarena.elts.ui.MenuFrame;
import com.tarena.elts.util.Config;

//创建整合测试 Main.class
public class Main {
	public static void main(String[] args) {
		//初始化软件组件(零件)
		LoginFrame loginFrame = new LoginFrame();
		ExamFrame examFrame = new ExamFrame();
		MenuFrame menuFrame = new MenuFrame();
		ClientContext clientContext =new ClientContext();
		ExamServiceImpl service = new ExamServiceImpl();
		Config config = new Config("client.properties");
		EntityContext entityContext = new EntityContext(config);
		//组装组件
		service.setEntityContext(entityContext);
		loginFrame.setClientContext(clientContext);
		clientContext.setExamService(service);
		clientContext.setLoginFrame(loginFrame);
		clientContext.setMenuFrame(menuFrame);
		menuFrame.setClientContext(clientContext);
		//启动软件界面
		clientContext.show();
		
	}
}

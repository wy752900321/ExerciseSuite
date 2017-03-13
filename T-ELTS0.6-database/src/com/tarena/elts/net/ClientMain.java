package com.tarena.elts.net;

//import com.tarena.elts.service.ExamServiceImpl;
import com.tarena.elts.ui.ClientContext;
import com.tarena.elts.ui.ExamFrame;
import com.tarena.elts.ui.LoginFrame;
import com.tarena.elts.ui.MenuFrame;
import com.tarena.elts.ui.WelcomeWindow;
import com.tarena.elts.util.Config;

/** 网络客户端入口*/
public class ClientMain {
	public static void main(String[] args){
		//配置文件
		Config config = new Config("client.properties");
		//界面层 ＝ 视图 ＋ 控制器
		LoginFrame loginFrame = new LoginFrame();
		MenuFrame menuFrame = new MenuFrame();
		ExamFrame examFrame = new ExamFrame();
		WelcomeWindow welcomeWindow = new WelcomeWindow();
		//控制器
		ClientContext clientContext = new ClientContext();
		
		//业务模型
		//ExamServiceImpl examService = new ExamServiceImpl();
		ExamServiceAgent examService = new ExamServiceAgent();
		
		//组装 界面层 业务层 和 数据层
		loginFrame.setClientContext(clientContext);
		clientContext.setLoginFrame(loginFrame);
		menuFrame.setClientContext(clientContext);
		clientContext.setMenuFrame(menuFrame);
		examFrame.setClientContext(clientContext);
		clientContext.setExamFrame(examFrame);
		clientContext.setWelcomeWindow(welcomeWindow);
		
		//插接 examService 到 表现层控制器
		clientContext.setExamService(examService);
		examService.setConfig(config);
		
		clientContext.show();
	}
}

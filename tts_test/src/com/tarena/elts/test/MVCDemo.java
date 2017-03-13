package com.tarena.elts.test;


import java.util.List;

import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;
import com.tarena.elts.service.ExamService;
import com.tarena.elts.service.IdOrPwdException;
import com.tarena.elts.ui.ClientContext;
import com.tarena.elts.ui.ExamFrame;
import com.tarena.elts.ui.LoginFrame;
import com.tarena.elts.ui.MenuFrame;

public class MVCDemo {
	public static void main(String[] args) {
		//初始化软件组件(零件)
		LoginFrame loginFrame = new LoginFrame();
		ExamFrame examFrame = new ExamFrame();
		MenuFrame menuFrame = new MenuFrame();
		ClientContext clientContext = new ClientContext();
		ExamService service = new ExamServiceDemo();
		//组装组件
		loginFrame.setClientContext(clientContext);
		clientContext.setExamService(service);
		clientContext.setLoginFrame(loginFrame);
	    clientContext.setExamFrame(examFrame);
	    clientContext.setMenuFrame(menuFrame);
	    //启动界面
	    clientContext.show();
	}
	static class ExamServiceDemo implements ExamService{

		public User login(int id, String pwd) throws IdOrPwdException {
			if(id==1001&&pwd.equals("1234")){
				return new User("贾东坡",1001,"1234");
			}
			throw new IdOrPwdException("用户名／密码错误！");
		}

		public QuestionInfo getQuestion(int i) {
			// TODO Auto-generated method stub
			return null;
		}

		public ExamInfo startExam() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void saveUserAnswers(int idx, List<Integer> userAnswers) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getScore() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int send() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
}

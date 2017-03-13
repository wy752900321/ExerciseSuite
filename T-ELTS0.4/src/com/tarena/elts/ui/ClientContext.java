package com.tarena.elts.ui;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
	private ExamFrame examFrame;
	private MenuFrame menuFrame;
	private ExamService examService;// 创建对象examService
	private WelcomeWindow welcomeWindow;

	/** 依赖注入(IOC) 这里注入的是loginFrame是实例,汽车与汽油的关系 */
	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}
	public void setExamService(ExamService examService) {
		this.examService = examService;
	}
	
	public void setExamFrame(ExamFrame examFrame) {
		this.examFrame = examFrame;
	}
	public void setMenuFrame(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}
	public void setWelcomeWindow(WelcomeWindow welcomeWindow) {
		this.welcomeWindow = welcomeWindow;
	}
	/**
	 * 9) 为ClientContext 增加show() 方法, 用来显示软件界面.
	 * 显示软件的开始界面,先显示登录界面 show()方法的运行必须依赖于loginFrame变量引用具体的界面对象,
	 * 这个界面对象必须依赖方法setLoginFrame()进行注入,注入这个界面对象实例！
	 */
	public void show() {
		welcomeWindow.setVisible(true);//打开闪屏
		final Timer timer = new Timer();//声明计时器
		timer.schedule(new TimerTask(){	//设置任务，二秒后关闭闪屏，后打开loginFrame
			public void run(){
				welcomeWindow.setVisible(false);
				loginFrame.setVisible(true);
				timer.cancel();
			}
		}, 2000);
	}
	 //4. 实现退出系统的功能 1) 为ClientContext添加exit方法
	public void exit(JFrame from){
		int value = JOptionPane.showConfirmDialog(from, "伙计，确定要离开吗？");
		if(value==JOptionPane.YES_OPTION){
			from.setVisible(false);
			System.exit(0);//系统退出，结束当前java进程
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
			System.out.println("examService:"+examService);
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
//	 控制器, 增加事件响应方法start()开始考试
	public void start() {
		
		try{
//			调用业务层方法开始考试, 返回考试详细信息
		ExamInfo examInfo = examService.startExam();
		//第一道题,调用业务层方法取回第一道题
		QuestionInfo questionInfo = examService.getQuestion(0);
//		保持当前题目状态  private QuestionInfo currentQuestionInfo;
		currentQuestionInfo = questionInfo;
//		QuestionInfo currentQuestionInfo = questionInfo;
//		this.currentQuestionInfo = questionInfo;
//		保持考试信息状态
		this.examInfo = examInfo;
		//更新ExamFrame显示考试信息, 和第一道题
		examFrame.updateView(examInfo,questionInfo);
//		关闭菜单界面
		menuFrame.setVisible(false);
		 //打开考试界面
		examFrame.setVisible(true);
		startTimer();
		}catch(Exception e){
			e.printStackTrace();
			 JOptionPane.showMessageDialog(menuFrame, e.getMessage());
		}
		
	}
	private QuestionInfo currentQuestionInfo;
	private ExamInfo examInfo;
	public void prev() {
		try{
			//取得当前的题号
			int index = currentQuestionInfo.getQuestionIndex();
			//保存当前考题的用户答案到业务层
			List<Integer> userAnswers = examFrame.getUserAnswers();
			examService.saveUserAnswers(index, userAnswers);
			//取得上一题目
			QuestionInfo questionInfo = examService.getQuestion(index-1);
			currentQuestionInfo = questionInfo;
			//更新考试界面，显示上一题目
			examFrame.updateView(examInfo, questionInfo);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(examFrame, e.getMessage());
		}
	}
	public void next() {
		try{
			//取得当前的题号
			int index = currentQuestionInfo.getQuestionIndex();
			//保存当前考题的用户答案到业务层
			List<Integer> userAnswers = examFrame.getUserAnswers();
			examService.saveUserAnswers(index, userAnswers);
			//取得下一题目
			QuestionInfo questionInfo = examService.getQuestion(index+1);
			currentQuestionInfo = questionInfo;
			//更新考试界面，显示上一题目
			examFrame.updateView(examInfo, questionInfo);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(examFrame, e.getMessage());
		}
		
	}
	public void send() {
		int val = JOptionPane.showConfirmDialog(examFrame, "你确定要交卷子了吗？");
		if(val ==JOptionPane.YES_OPTION){
			gameOver();
		}
	}
	public void gameOver(){
		try{
			int index = currentQuestionInfo.getQuestionIndex();
			//获取最后的用户答案
			List<Integer> userAnswers = examFrame.getUserAnswers();
			//保存用户答案
			examService.saveUserAnswers(index, userAnswers);
			//交卷处理
			int score = examService.send();
			//显示分数
			timer.cancel();
			JOptionPane.showMessageDialog(examFrame, "分数："+score);
			//关闭考试界面
			examFrame.setVisible(false);
			//返回菜单界面
			menuFrame.setVisible(true);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(examFrame, e.getMessage());
		}
	}
	
	public void result() {
		try{
			int score =examService.getScore();
			JOptionPane.showMessageDialog(menuFrame, "分数："+score);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(menuFrame, e.getMessage());
		}
		
	}
	private Timer timer;
	private void startTimer(){
		timer = new Timer();
		long start = System.currentTimeMillis();
		final long end = examInfo.getTimeLimit()*60*1000+start;
		timer.schedule(new TimerTask(){
			@Override
			public void run(){
				long show = end-System.currentTimeMillis();
				long h = show/1000/60/60;
				long m = show/1000/60%60;
				long s = show/1000%60;
				examFrame.updateTime(h, m, s);
			}
		}, 0,1000);
		timer.schedule(new TimerTask(){
		      @Override
		      public void run() {

		        gameOver();
		      }
		    }, new Date(end));
	}
}

package com.tarena.elts.ui;

import java.awt.Color;
import java.sql.Date;
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

/** 客户界面控制器；客户端上下文环境 */
public class ClientContext {
	private LoginFrame loginFrame;

	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}

	private ExamFrame examFrame;

	public void setExamFrame(ExamFrame examFrame) {
		this.examFrame = examFrame;
	}

	private MenuFrame menuFrame;

	public void setMenuFrame(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}

	private ExamService examService;

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	public void show() {
		loginFrame.setVisible(true);// 显示界面
	}

	/**
	 * 此方法被login按钮调用 登陆系统，控制逻辑 1.从登录界面获得用户的ID和pwd 2.调用业务模型的login方法完成登录功能
	 * 3.根据登陆的结果，如果成功就更新菜单界面，显示用户信息 关闭登录界面，打开菜单界面 4.如果登录失败就在登陆界面上显示失败消息
	 */
	public void login() {
		try {
			// 1.从登录界面获取ID和pwd
			int id = loginFrame.getUserId();
			String pwd = loginFrame.getPassword();
			// 2.调用业务模型的登录功能
			// examService.login()引用接口的类型，引用类型绑定到对象上。方法也绑定到对象上。调用业务模型
			User user = examService.login(id, pwd);
			// 3.如果登录成功就关闭登录界面，打开菜单界面
			menuFrame.updateView(user);// 更新菜单界面
			loginFrame.setVisible(false);
			menuFrame.setVisible(true);

		} catch (IdOrPwdException e) {
			e.printStackTrace();
			loginFrame.showMessage("登录失败：" + e.getMessage());
		} catch (NumberFormatException e) {
			e.printStackTrace();
			loginFrame.showMessage("ID 必须是整数");
		} catch (Exception e) {
			e.printStackTrace();
			loginFrame.showMessage("登录失败：" + e.getMessage());
		}
	}

	public void exit(JFrame from) {
		int val = JOptionPane.showConfirmDialog(from, "确定要离开吗！");
		if (val == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void start() {
		try {
			ExamInfo examInfo = examService.startExam();
			QuestionInfo questionInfo = examService.getQuestion(0);
			currentQuestion = questionInfo;
			this.examInfo = examInfo;
			examFrame.updateView(examInfo, questionInfo);
			menuFrame.setVisible(false);
			examFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(menuFrame, e.getMessage());
		}
	}

	/*
	 * 2 考试时间提醒与超时交卷 1) 更新控制器 start方法添加: startTimer(); 2) 更新控制器 添加
	 */
	private Timer timer;

	private void startTimer() {
		timer = new Timer();
		long start = System.currentTimeMillis();
		int timeout = examInfo.getTimeLimit() * 60 * 1000;
		final long end = timeout + start;
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// show 是需要显示的剩余时间
				long show = end - System.currentTimeMillis();
				long h = show / 1000 / 60 / 60;
				long m = show / 1000 / 60 % 60;
				long s = show / 1000 % 60;
				examFrame.updateTime(h, m, s);
			}
		}, 0, 1000);
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				gameOver();// 提前交卷！
			}
		}, new Date(end));
	}

	public void gameOver() {
		try {
			int idx = currentQuestion.getQuestionIndex();
			//获取最后的用户答案
			List<Integer> userAnswers = examFrame.getUserAnswers();
			//保存用户答案
			examService.saveUserAnswers(idx, userAnswers);
			//交卷处理
			int score = examService.send();
			//显示分数
			timer.cancel();
			JOptionPane.showMessageDialog(examFrame, "你的分数:" + score);
			examFrame.setVisible(false);
			menuFrame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(examFrame, e.getMessage());
		}
	}

	private QuestionInfo currentQuestion;
	private ExamInfo examInfo;

	public void next() {
		try {
			int idx = currentQuestion.getQuestionIndex();
			List<Integer> userAnswers = examFrame.getUserAnswers();
			examService.saveUserAnswers(idx, userAnswers);
			currentQuestion = examService.getQuestion(idx + 1);
			examFrame.updateView(examInfo, currentQuestion);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(examFrame, e.getMessage());
		}
	}

	public void prev() {
		try {
			int idx = currentQuestion.getQuestionIndex();
			List<Integer> userAnswers = examFrame.getUserAnswers();
			examService.saveUserAnswers(idx, userAnswers);
			currentQuestion = examService.getQuestion(idx - 1);
			examFrame.updateView(examInfo, currentQuestion);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(examFrame, e.getMessage());
		}
	}

	public void send() {
			int val = JOptionPane.showConfirmDialog(examFrame, "交吗？");
			if (val != JOptionPane.YES_OPTION) {
				gameOver();
			}
	}

	public void result() {
		try {
			int score = examService.getScore();
			JOptionPane.showMessageDialog(menuFrame, "考试分数：" + score);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(menuFrame, e.getMessage());
		}
	}

	public void getRules() {
	 JOptionPane.showMessageDialog(menuFrame, "不能抄");
	}

}
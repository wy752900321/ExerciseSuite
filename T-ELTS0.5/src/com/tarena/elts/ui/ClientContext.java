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

/** 客户界面控制器: 客户端上下文环境  */
public class ClientContext {

  //private LoginFrame loginFrame = new LoginFrame();
  private LoginFrame loginFrame;
  /** 依赖注入(IOC) 这里注入的是loginFrame是实例 */
  public void setLoginFrame(LoginFrame loginFrame) {
    this.loginFrame = loginFrame;
  }
  private ExamService examService;
  public void setExamService(ExamService examService) {
    this.examService = examService;
  }
  private MenuFrame menuFrame;
  public void setMenuFrame(MenuFrame menuFrame) {
    //System.out.println("setMenuFrame()" + menuFrame); 
    this.menuFrame = menuFrame;
  }
  private ExamFrame examFrame;
  public void setExamFrame(ExamFrame examFrame) {
    this.examFrame = examFrame;
  }
  private WelcomeWindow welcomeWindow;
  public void setWelcomeWindow(WelcomeWindow welcomeWindow) {
    this.welcomeWindow = welcomeWindow;
  }
  /**
   * 显示软件的开始界面,  先显示登录界面
   * show()方法的运行, 必须依赖于 loginFrame变量引用
   * 具体的界面对象, 这个界面对象必须依赖方法setLoginFrame()
   * 注入, 注入这个界面对象实例!
   **/
  public void show(){
    welcomeWindow.setVisible(true);
    final Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      public void run() {
        welcomeWindow.setVisible(false);
        loginFrame.setVisible(true); 
        timer.cancel();
      }
    }, 2000); 
  }
  /**
   * 此方法被 login按钮调用!
   * 登录系统, 控制逻辑
   *  1 从登录界面获得用户的ID和pwd
   *  2 调用业务模型的login方法完成登录功能
   *  3 根据登录的结果, 如果成功就 更新菜单界面,显示用户信息
   *     关闭登录界面, 打开菜单界面
   *  4 如果登录失败就在登录界面上显示失败消息
   */
  public void login(){
    try{
      int id = loginFrame.getUserId();
      String pwd = loginFrame.getPassword();
      User user = examService.login(id, pwd);
      //System.out.println("loing():menuFrame:"+menuFrame);
      //System.out.println("loing():user+"+user);
      menuFrame.updateView(user);//更新菜单界面
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
  /**
   * 退出系统 控制逻辑
   * @param source 代表从哪一个界面退出. 是一个窗口的引用
   */
  public void exit(JFrame source){
    //Confirm 确认
    // Dialog 对话框
    int val = 
      JOptionPane.showConfirmDialog(source, "离开吗?");
    if(val==JOptionPane.YES_OPTION){
      System.exit(0);//结束当前Java进程
    }
  }

  public void start(){
    try{
      examInfo = examService.start();//生成考卷
      QuestionInfo questionInfo = 
        examService.getQuestion(0);
      currentQuestionInfo = questionInfo;
      examFrame.updateView(examInfo, questionInfo);
      menuFrame.setVisible(false);
      examFrame.setVisible(true);
      startTimer();
    }catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          menuFrame, e.getMessage());
      menuFrame.repaint();//重绘界面
    }
  }
  private QuestionInfo currentQuestionInfo;
  private ExamInfo examInfo;
  
  public void next(){
    try{
      //取得当前的题号
      int index = currentQuestionInfo.getQuestionIndex();
      //保存当前考题的用户答案到业务层
      List<Integer> userAnswers= 
        examFrame.getUserAnswers(); 
      examService.saveUserAnswers(index, userAnswers);
      //取得下一题目
      QuestionInfo questionInfo = 
        examService.getQuestion(index+1);
      currentQuestionInfo = questionInfo;
      //更新考试界面, 显示下一题目
      examFrame.updateView(examInfo, questionInfo);
    }catch(Exception e){
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          examFrame, e.getMessage());
    }
  }
  public void prev(){
    try{
      //取得当前的题号
      int index = currentQuestionInfo.getQuestionIndex();
      //保存当前考题的用户答案到业务层
      List<Integer> userAnswers= 
        examFrame.getUserAnswers(); 
      examService.saveUserAnswers(index, userAnswers);
      //取得下一题目
      QuestionInfo questionInfo = 
        examService.getQuestion(index-1);
      currentQuestionInfo = questionInfo;
      //更新考试界面, 显示上一题目
      examFrame.updateView(examInfo, questionInfo);
    }catch(Exception e){
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          examFrame, e.getMessage());
    }
  }
  
  public void send(){
    int val = JOptionPane
      .showConfirmDialog(examFrame, "真的交卷吗?");
    if(val==JOptionPane.YES_OPTION){
      gameOver();
    }
  }
  
  private void gameOver(){
    try{
      //保存最后选择的考题答案
      List<Integer> ans = examFrame.getUserAnswers();
      int index = currentQuestionInfo.getQuestionIndex();
      examService.saveUserAnswers(index, ans);
      //结束考试, 得到分数
      int socre = examService.examOver();
      //显示分数
      JOptionPane.showMessageDialog(
          examFrame, "您的分数"+socre);
      //切换窗口
      examFrame.setVisible(false);
      menuFrame.setVisible(true);
      timer.cancel();
    }catch(Exception e){
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          examFrame, e.getMessage());
    }
  }
  private Timer timer = new Timer();
  private void startTimer(){
    final long end = System.currentTimeMillis() + 
      examInfo.getTimeLimit() * 1000 * 60;
    timer.schedule(new TimerTask() {
      public void run() {
        long now = System.currentTimeMillis();
        long show = end-now;
        long h = show/1000/60/60;
        long m = show/1000/60%60;
        long s = show/1000%60;
        examFrame.showTime(h,m,s);
      }
    }, 0, 1000);
    timer.schedule(new TimerTask() {
      public void run() {
        gameOver();
      }
    }, new Date(end));
  }
  public void result() {
    try {
      int score = examService.getScore();
      JOptionPane.showMessageDialog(
          menuFrame, "考试分数:"+score);
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          menuFrame, e.getMessage());
    }
  }
}


















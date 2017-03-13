package com.tarena.elts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.Question;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;
/** 核心业务功能的实现类 */
public class ExamServiceImpl implements ExamService {
  private boolean finished = false;
  private EntityContext entityContext;
  public void setEntityContext(EntityContext entityContext) {
    this.entityContext = entityContext;
  }

  public User login(int id, String pwd) 
    throws IdOrPwdException {
    User user = entityContext.findUserById(id);
    if(user==null){
      throw new IdOrPwdException("无用户!");
    }
    if(user.getPasswd().equals(pwd)){
      loginUser = user;
      return user;//登录成功
    }
    throw new IdOrPwdException("密码错误!");
  }
 
  private User loginUser;
  private List<QuestionInfo> paper =
    new ArrayList<QuestionInfo>();
  
  private void createPaper(){
    //每个级别抽取两道考题
    Random r = new Random();
    int i=0;
    for(int level=Question.LEVEL1; 
      level<=Question.LEVEL10; level++){
      List<Question> list = 
        entityContext.findQuestions(level);
      
      int index = r.nextInt(list.size());
      Question q = list.remove(index);
      paper.add(new QuestionInfo(i++, q));
      
      index = r.nextInt(list.size());
      q = list.remove(index);
      paper.add(new QuestionInfo(i++, q));
    }
  }
  
  public ExamInfo start() {
    if(finished)
      throw new RuntimeException("考试已经结束!");
    //创建考卷
    createPaper();
    //组织考试信息
    ExamInfo examInfo = new ExamInfo();
    examInfo.setQuestionCount(paper.size());
    examInfo.setTimeLimit(entityContext.getTimeLimit());
    examInfo.setTitle(entityContext.getTitle());
    examInfo.setUser(loginUser);//当前系统登录用户
    return examInfo;
  }
  
  public QuestionInfo getQuestion(int index) {
    return paper.get(index); 
  }
  public void saveUserAnswers(
      int index, List<Integer> userAnswers) {
    QuestionInfo q = paper.get(index);
    q.getUserAnswers().clear();
    q.getUserAnswers().addAll(userAnswers);
  }
  private int score; 
  public int examOver() {
    if(finished)
      throw new RuntimeException("考试已经结束!");
    
    for (QuestionInfo q : paper) {
      Question question = q.getQuestion();
      List<Integer> userAnswers = q.getUserAnswers();
      if(userAnswers.equals(question.getAnswers())){
        score+=question.getScore();
      }
    }
    finished=true;
    return score;
  }
  
  public int getScore() {
    if(! finished )
      throw new RuntimeException("没有考试哪有分数!");
    return score;
  }
}









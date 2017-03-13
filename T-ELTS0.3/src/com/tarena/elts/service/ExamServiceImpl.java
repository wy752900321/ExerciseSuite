package com.tarena.elts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.Question;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;
/**核心业务功能实现类
 * 6. 利用用户数据实现登录业务逻辑
 	1) 实现业务功能实现类 ExamServiceImpl 的login方法
 */
public class ExamServiceImpl implements ExamService{
	
	//6. 利用用户数据实现登录业务逻辑->实现EntityContext的注入方法
	private EntityContext entityContext;
	public void setEntityContext(EntityContext entityContext) {
		this.entityContext = entityContext;
	}
	
	//6. 利用用户数据实现登录业务逻辑->实现业务功能实现类 ExamServiceImpl 的login方法
	public User login(int id,String pwd) throws IdOrPwdException{
		User user = entityContext.findUserById(id);
		if(user==null){
			throw new IdOrPwdException("找不到这个伙计！");
		}
		if(user.getPasswd().equals(pwd)){
			return user;//登陆成功
		}
		throw new IdOrPwdException("密码有问题!");
	}
	/***
	 * 3) 业务层: 增加: startExam() getQuestion()
 			开始考试业务描述: 开始考试时候, 抽取考卷试题, 每个level抽取2题
 			返回考试描述信息:ExamInfo
 			考卷是: 有抽取的题目组成的线性表集合
 			获取试题: 根据题目序号获取指定试题
	 */
	private List<QuestionInfo> paper = new ArrayList<QuestionInfo>();
	
	public QuestionInfo getQuestion(int index) {
		return paper.get(index);
	}
	private User loginUser;
	public ExamInfo startExam() {
		  createPaper();
		    ExamInfo info = new ExamInfo();
		    //初始化info ...
		    info.setQuestionCount(paper.size());
		    info.setTimeLimit(entityContext.getTimeLimit());
		    info.setTitle(entityContext.getTitle());
		    info.setUser(loginUser);
		    return info;
	}
		  
		  private void createPaper(){
		    Random r = new Random();
		    int idx = 0;
		    for(int i=Question.LEVEL1; i<=Question.LEVEL10; i++){
		      List<Question> list = 
		        entityContext.findQuestions(i);
		      //抽出2道题
		      Question q1 = list.remove(r.nextInt(list.size()));
		      Question q2 = list.remove(r.nextInt(list.size()));
		      paper.add(new QuestionInfo(idx++, q1));
		      paper.add(new QuestionInfo(idx++, q2));
		    }
		  }
}	  

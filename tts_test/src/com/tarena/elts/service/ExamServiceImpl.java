package com.tarena.elts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.Question;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;

/***
 * 3) 业务层: 增加: startExam() getQuestion()
			开始考试业务描述: 开始考试时候, 抽取考卷试题, 每个level抽取2题
			返回考试描述信息:ExamInfo
			考卷是: 有抽取的题目组成的线性表集合
			获取试题: 根据题目序号获取指定试题
 */
public class ExamServiceImpl implements ExamService {
	/** 登录业务逻辑实现 */
	public User login(int id, String pwd) throws IdOrPwdException {
		User user = entityContext.getUser(id);
		if (user == null)
			throw new IdOrPwdException("这个伙计去哪了，找不到啊。");
		if (user.getPasswd().equals(pwd)) {
			this.loginUser = user;//不加试题界面会不显示文本
			return user;// 登陆成功
		}
		throw new IdOrPwdException("密码错误了！");
	}

	// 2) 实例EntityContext 的注入方法
	private EntityContext entityContext;

	public void setEntityContext(EntityContext entityContext) {
		this.entityContext = entityContext;
	}

	private List<QuestionInfo> paper = new ArrayList<QuestionInfo>();

	public QuestionInfo getQuestion(int index) {
		return paper.get(index);
	}

	private User loginUser;

	public ExamInfo startExam() {
		createPape();
		ExamInfo info = new ExamInfo();
		info.setQuestionCount(paper.size());
		info.setTimeLimit(entityContext.getTimeLimit());
		info.setTitle(entityContext.getTitle());
		info.setUser(loginUser);
		return info;
	}

	private void createPape() {
		Random r = new Random();
		int idx = 0;
		for (int i = Question.LEVEL1; i <= Question.LEVEL10; i++) {
			List<Question> list = entityContext.findQuestions(i);
			//找出2道题
			Question q1 = list.remove(r.nextInt(list.size()));
			Question q2 = list.remove(r.nextInt(list.size()));
			paper.add(new QuestionInfo(idx++, q1));
			paper.add(new QuestionInfo(idx++, q2));
		}
	}

	// 业务层保存用户答案
	public void saveUserAnswers(int idx, List<Integer> userAnswers) {
		paper.get(idx).setUserAnswers(userAnswers);
	}

	private int score = 0;
	public int examOver() {
		// 判分
		for (QuestionInfo qInfo : paper) {
			Question q = qInfo.getQuestion();
			if (qInfo.getUserAnswers().equals(q.getAnswers())) {
				score += q.getScore();
			}
		}
		return score;
	}
	private boolean finish=false;
	public int send(){
		if(finish){
			throw new RuntimeException("考试已经结束！");
		}
		score = 0;
		for(QuestionInfo info :paper){
			Question q = info.getQuestion();
			List<Integer> answers = q.getAnswers();
			List<Integer> userAnswers = info.getUserAnswers();
			if(answers.equals(userAnswers)){
				score+=q.getScore();
			}
		}
		finish=true;
		return score;
	}

	@Override
	public int getScore() {
			if(!finish)
				throw new RuntimeException("还没有考试呀！");
			return score;
	}
	
}
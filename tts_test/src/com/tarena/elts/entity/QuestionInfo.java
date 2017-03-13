package com.tarena.elts.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题和用户答案的值对象, 表示界面上的一道题和对应的用户答案
 * 是值对象
 * QuestionInfo 代表用户考卷上的试题, 包含题目,用户答案和试题序号
 */
public class QuestionInfo{
	//题目
	private Question question;
	//在试卷中的序号0，1，2
	private int questionIndex;
	//用户答案
	private List<Integer> userAnswers = new ArrayList<Integer>();
	public QuestionInfo(){
	}
	public QuestionInfo(int questionIndex,Question question){
		this.question = question;
		this.questionIndex = questionIndex;
	}
	public QuestionInfo(int questionIndex,Question question,List<Integer> userAnswers){
		super();
		this.question =question;
		this.userAnswers = userAnswers;
		this.questionIndex = questionIndex;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public int getQuestionIndex() {
		return questionIndex;
	}
	public void setQuestionIndex(int questionIndex) {
		this.questionIndex = questionIndex;
	}
	public List<Integer> getUserAnswers() {
		return userAnswers;
	}
	public void setUserAnswers(List<Integer> userAnswers) {
		this.userAnswers = userAnswers;
	}
	@Override
	public String toString() {
		return question.toString();
	}
	
}

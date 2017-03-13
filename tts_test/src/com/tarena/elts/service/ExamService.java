package com.tarena.elts.service;

import java.util.List;

import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;

/**软件的核心功能：登录，开始(发卷)，交卷*/
public interface ExamService {
	User login(int id,String pwd)
			throws IdOrPwdException;

	ExamInfo startExam();

	QuestionInfo getQuestion(int i);

	void saveUserAnswers(int idx, List<Integer> userAnswers);

	int send();

	int getScore();
}

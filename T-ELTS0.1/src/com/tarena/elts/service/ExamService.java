package com.tarena.elts.service;

import com.tarena.elts.entity.User;

/**软件的核心功能：登录，开始(发卷)，交卷*/
public interface ExamService {
	User login(int id ,String pwd)
		throws IdOrPwdException;
}

package com.tarena.elts.service;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.entity.User;
/**核心业务功能实现类*/
public class ExamServiceImpl implements ExamService{

	//6. 利用用户数据实现登录业务逻辑->实现EntityContext的注入方法
	private EntityContext entityContext;
	public void setEntityContext(EntityContext entityContext) {
		this.entityContext = entityContext;
	}
	public User login(int id, String pwd) throws IdOrPwdException {
		User user = entityContext.findUserById(id);
		if(user==null){
			throw new IdOrPwdException("无用户");
		}
		if(user.getPasswd().equals(pwd)){
			return user;//登陆成功
		}
		throw new IdOrPwdException("密码错误");
	}
}
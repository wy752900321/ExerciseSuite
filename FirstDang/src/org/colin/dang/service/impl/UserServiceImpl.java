package org.colin.dang.service.impl;

import org.colin.dang.common.Constant;
import org.colin.dang.dao.UserDAO;
import org.colin.dang.dao.impl.UserDAOImpl;
import org.colin.dang.pojo.User;
import org.colin.dang.service.UserService;
import org.colin.dang.util.EmailUtil;
import org.colin.dang.util.EncryptUtil;
import org.colin.dang.util.VerifyUtil;



public class UserServiceImpl implements UserService{
 

	public void register(User user) throws Exception{
		 String pwd=EncryptUtil.md5(user.getPassword());
		   user.setPassword(pwd);
		   user.setUserIntegral(Constant.NORMAL);
		   user.setIsEmailVerify("N");
		   
		   user.setLastLoginTime(System.currentTimeMillis());
		  
		   String code=VerifyUtil.createEmailVerifyCode();
		   
		   user.setEmailVerifyCode(code);
		   EmailUtil.sendEmail(user.getEmail(), code);
		   UserDAO userDao=new UserDAOImpl();
		   userDao.save(user);
		   
	}

	public String loginCheckEmail(String email,String ip) throws Exception {
		 UserDAO userDao=new UserDAOImpl();
		  User user=userDao.findByPassWord(email);
		 if(user==null){
			 return "0";
		 }else{
			 String verify=user.getIsEmailVerify();
			 if(verify.equals("Y")){
		  String pwd= user.getPassword();
		  user.setLastLoginIp(ip);
		  user.setLastLoginTime(System.currentTimeMillis());
		   userDao.save(user);
		return pwd;
			 }else{
				 return "0";
			 }
		 }
	}

	public boolean checkEmail(String email) throws Exception {
		boolean ok;
		UserDAO userDao=new UserDAOImpl();
		   User user=userDao.findByEmail(email);
		   if(user==null){
			   ok=true;
		   }else{
			   ok=false;
		   }
		return ok;
	}

	public boolean emailVerifyCode(String errorTxt,String email) throws Exception {
		boolean ok;
		 UserDAO userDao=new UserDAOImpl();
    	 User user=userDao.findByEmailVerify(email);
    	 user.setIsEmailVerify("Y");
    	 String emailVerify=user.getEmailVerifyCode();
    	 if(emailVerify.equals(errorTxt)){
    		 userDao.updateUser(user);
    		 ok=true;
    	 }else{
    		 ok=false;
    	 }
		return ok;
	}


}

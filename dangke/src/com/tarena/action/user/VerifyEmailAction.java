package com.tarena.action.user;

import com.tarena.dao.UserDAO;
import com.tarena.dao.impl.UserDAOImpl;
import com.tarena.entity.User;

public class VerifyEmailAction {

	private User user;
	private String inputEmailCode;//接收到的邮箱验证码
	private String message;
	public String execute(){
		try {
			//将接收到的邮箱验证码解析
			//获取用户ID和UUID
			System.out.println("用户的邮箱为：   ................."+message);
			String UUID = inputEmailCode.substring(0, inputEmailCode.lastIndexOf('-'));
			int ID = Integer.parseInt(inputEmailCode.substring(inputEmailCode.lastIndexOf('-')+1));
			System.out.println("ID................."+ID);
			System.out.println("UUID+++++++++++++"+UUID);
			UserDAO userDao = new UserDAOImpl();
			//判断是否正确
			//如果正确,更新d_user的is_email_verify 并返回user 对象；
		    user= userDao.findUserByIDandUUID(ID,UUID);
			//System.out.println("user.getNickname............."+user.getNickname());
			//System.out.println("user.getEmail............"+user.getEmail());
			if(user==null){
				UserDAO dao = new UserDAOImpl();
				user=dao.findUserByEmail(message);
				message="验证码错误，请重新输入！";
				return "fail";
			}
		}catch (Exception e) {
			//e.printStackTrace();
			return "error";
		}
	   return "success";	
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String getInputEmailCode() {
		return inputEmailCode;
	}

	public void setInputEmailCode(String inputEmailCode) {
		this.inputEmailCode = inputEmailCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
}

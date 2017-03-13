package cn.com.webwork.register;

import com.opensymphony.xwork.Action;

public class registerAction implements Action {

	private User user = new User();

	public String execute() throws Exception {
		System.out.println("Start execute 。。。。。。。。。。。。。");
		System.out.println("User=" + user);

		return SUCCESS;
	}

	public User getUser() {
		return this.user;
	}

	public static boolean testel(String str1, String str2) {
		System.out.println("接收到的数据[" + str1 + "],str2[" + str2 + "]");
		return true;
	}

}

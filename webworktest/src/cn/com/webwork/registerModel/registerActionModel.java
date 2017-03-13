package cn.com.webwork.registerModel;
import cn.com.webwork.register.User;

import com.opensymphony.xwork.Action;
import com.opensymphony.xwork.ModelDriven;
public class registerActionModel implements Action,ModelDriven {

	private User user = new User();
	public String execute() throws Exception {
		System.out.println("Start execute 。。。。。。。。。。。。。");
		System.out.println("User="+user);

		return SUCCESS;
	}
	
	/*public Object getModel(){
		return user;
	}*/
	public Object getModel() {
		return user;
	}

}

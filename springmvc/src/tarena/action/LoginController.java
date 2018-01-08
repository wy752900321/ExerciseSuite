package tarena.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class LoginController extends SimpleFormController{
	
	//默认执行的处理方法
	public ModelAndView onSubmit(
			HttpServletRequest req, 
			HttpServletResponse res,
			Object command,
			BindException errors) throws Exception {
		User user = (User)command;
		String name = user.getName();
		String pwd = user.getPassword();
		Map model = new ModelMap();
		if("scott".equalsIgnoreCase(name) 
				&& "123456".equals(pwd)){
			model.put("name", name);
			//注意:标示符需要使用视图组件名
			//例如ok.jsp就写ok
			return new ModelAndView("ok",model);
		}else{
			model.put("error", "用户名或密码错误");
			return new ModelAndView("login",model);
		}
		
	}

}

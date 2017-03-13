package cn.itcast.util;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Synchronization;

public class UUIDToken {
	private static UUIDToken uuidToken=new UUIDToken();
	private UUIDToken(){
	}
	
	public static UUIDToken getUuidToken() {
		return uuidToken;
	}
	
	/**
	 * 该方法的作用生成唯一的UUID
	 * @param request
	 * @return
	 */
	public synchronized String getUUidAsUniqueStr(HttpServletRequest request){
		//如果存在，获取以存在的session,如果不存在,创建新的session
		HttpSession session=request.getSession();
		String uuidstr=UUID.randomUUID().toString();
		if(uuidstr!=null){
			session.setAttribute("session.token", uuidstr);
		}
		return uuidstr;
	}

	/**
	 * 判断jsp页面隐藏域的值和session中的值是否相等
	 *   * 如果相等,返回true
	 *   * 如果不相等,返回false
	 * @param request
	 * @return
	 */
	public boolean isValidateToken(HttpServletRequest request) {
		//获取已经存在的session,如果不存在,返回null
		HttpSession session=request.getSession(false);
		
		if(session==null){
			return false;
		}
		
		//获取session中保存的值
		String saveed=(String)session.getAttribute("session.token");
		if(saveed==null){
			return false;
		}
		
		//	<input type="hidden" name="html.tolen" value="<%=UUIDToken.getUuidToken().getUUidAsUniqueStr(request)%>>">
		String hidValue=request.getParameter("html.token");
		if(hidValue==null){
			return false;
		}
		
		//比对隐藏域的值和session中存放的值的大小
		return saveed.equals(hidValue);
	}

	/**
	 * 删除session中存放的值
	 * @param request
	 */
	public void resetUUIDToken(HttpServletRequest request) {
		
		//获取已经存在的session,如果不存在,返回null
		HttpSession session=request.getSession(false);
		
		if(session==null){
			return;
		}
		session.removeAttribute("session.token");
	}
}

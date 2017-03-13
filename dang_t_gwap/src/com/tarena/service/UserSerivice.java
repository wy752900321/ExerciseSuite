package com.tarena.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.tarena.entity.User;

/**
 * 用户服务器
 * @author soft01
 *
 */
public interface UserSerivice {
	/**
	 * 检查用户登陆
	 * 
	 * @param email
	 *            用户输入的邮箱
	 * @param password
	 *            用户输入的密码
	 * @param servletRequest
	 *            监听的request
	 * @param session
	 *            监听的session
	 * @return 返回一个登陆成功或失败的字符串
	 */
	public String checkLogin(String email, String password,
			HttpServletRequest servletRequest, Map<String, Object> session);

	/**
	 * 用户注册逻辑
	 * @param user 用户
	 * @param session 监听的session
	 * @param servletRequest 监听的request
	 * @return
	 */
	public boolean register(User user,Map<String, Object> session, HttpServletRequest servletRequest);

	/**
	 * 验证邮箱逻辑
	 * @param code
	 * @param session
	 * @return
	 */
	public String verifyEmail(String code,Map<String, Object> session);
}

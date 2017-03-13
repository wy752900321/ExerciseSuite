package com.tarena.dao;

import com.tarena.entity.User;

public interface UserDAO {
	/**
	 * @param user
	 *            用户信息
	 * @exception Exception
	 */
	public void insert(User user) throws Exception;

	/**
	 * 通过email找一个用户
	 * 
	 * @param email
	 *            传入的email
	 * @return 返回一个用户
	 * @throws Exception
	 */
	public User findByEmail(String email) throws Exception;

	/**
	 * 通过nickname找一个用户
	 * 
	 * @param nickName
	 *            传入的nickname
	 * @return 返回一个用户
	 * @throws Exception
	 */
	public User findByNickName(String nickName) throws Exception;

	/**
	 * 通过id找一个用户
	 * 
	 * @param id
	 *            传入的id
	 * @return 返回一个用户
	 * @throws Exception
	 */
	public User findById(int id) throws Exception;

	/**
	 * 通过id更新用户信息
	 * 
	 * @param id
	 *            用户id
	 * @throws Exception
	 */
	public void updateById(int id) throws Exception;

	/**
	 * 更新用户的验证码状态
	 * 
	 * @param id
	 *            用户id
	 * @param verify
	 *            是否通过验证
	 * @return 返回Y或N
	 * @throws Exception
	 */
	public String updateVerify(int id, boolean verify) throws Exception;

}

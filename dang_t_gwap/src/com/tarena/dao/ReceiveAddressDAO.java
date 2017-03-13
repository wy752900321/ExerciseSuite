package com.tarena.dao;

import java.util.List;

import com.tarena.entity.ReceiveAddress;

/**
 * 为d_receive_address表量身定做DAO
 * 
 * @author soft01
 * 
 */
public interface ReceiveAddressDAO {
	/**
	 * 插入收件人地址信息
	 * 
	 * @param receiveAddress
	 *            收件人地址对象
	 * @throws Exception
	 */
	public void insert(ReceiveAddress receiveAddress) throws Exception;

	/**
	 * 列出全部收件人地址
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<ReceiveAddress> findAll() throws Exception;

	/**
	 * 通过id找一个收件人地址
	 * 
	 * @param id
	 *            收件人地址表id
	 * @return
	 * @throws Exception
	 */
	public ReceiveAddress findById(int id) throws Exception;
}

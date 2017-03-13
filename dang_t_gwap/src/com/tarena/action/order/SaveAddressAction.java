package com.tarena.action.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.tarena.dao.ReceiveAddressDAO;
import com.tarena.entity.ReceiveAddress;
import com.tarena.util.DAOFactory;

/**
 * 此类用于保存定单地址，关联表为d_receive_address
 * 
 * @author soft01
 * 
 */
public class SaveAddressAction implements Serializable {
	private static final long serialVersionUID = 7167335826449775537L;
	// 保存收件人地址的集合
	private List<ReceiveAddress> list = new ArrayList<ReceiveAddress>();
	private int id;
	// 通过id找出一个地址，然后发送到address_form.jsp
	private String msgStr;

	public String execute() {
		// 实例化一个收件人地址的对象
		ReceiveAddressDAO addressDAO = (ReceiveAddressDAO) DAOFactory
				.getInstance("ReceiveAddressDAO");
		try {
			// 获取所有的信息存放到list集合当中
			list = addressDAO.findAll();
			// 链接到address_form.jsp页面
			return "success";
		} catch (Exception e) {
			// 利用Logger进行调试工作
			Logger logger = Logger.getLogger(SaveAddressAction.class);
			logger.error("获取信息时出现错误", e);
			// 链接到error.jsp页面
			return "error";
		}
	}

	// 通过id找到一个收件人地址信息
	public String findById() {
		// 实例化对象
		ReceiveAddressDAO addressDAO = (ReceiveAddressDAO) DAOFactory
				.getInstance("ReceiveAddressDAO");
		try {
			// 找出收件人地址赋值给收件人地址对象
			ReceiveAddress receiveAddress = addressDAO.findById(id);
			// 把收件人地址信息保存成一个字符串
			msgStr = receiveAddress.toString();
			// 以json形式返回ajax请求参数
			return "success";
		} catch (Exception e) {
			// 记录日志
			Logger logger = Logger.getLogger(SaveAddressAction.class);
			logger.error("通过id找收件人地址时出错", e);
			return "false";
		}
	}

	// getter and setter
	public void setList(List<ReceiveAddress> list) {
		this.list = list;
	}

	public List<ReceiveAddress> getList() {
		return list;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setMsgStr(String msgStr) {
		this.msgStr = msgStr;
	}

	public String getMsgStr() {
		return msgStr;
	}

}

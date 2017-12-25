package cn.itcast.ssh.service.impl;

import cn.itcast.ssh.service.ILeaveBillService;
import cn.itcast.ssh.dao.ILeaveBillDao;

public class LeaveBillServiceImpl implements ILeaveBillService {

	private ILeaveBillDao leaveBillDao;

	public void setLeaveBillDao(ILeaveBillDao leaveBillDao) {
		this.leaveBillDao = leaveBillDao;
	}

}

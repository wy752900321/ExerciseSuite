package com.cenrise.cdc;

/*
 * CDC服务器参数
 */
public class CDCServerParams {
	String cdcIP;// cdc服务器的IP
	int cdcPort;// cdc服务器的端口号
	String cdcUser;// cdc服务器的用户名
	String cdcPWD;// cdc服务器的用户名密码
	int cdcMonitorPort;// cdc服务器的监控管理端口
	String cdcMonitorUser;// cdc服务器的监控管理用户名
	String cdcMonitorPWD;// cdc服务器的监控管理用户名密码
	String cdcExtractName;// cdc服务器的抽取实例名称
	String cdcSubName;// cdc服务器的订阅名
	int cdcBatchNum;// cdc服务器的批次获取记录数

	public String getCdcIP() {
		return cdcIP;
	}

	public void setCdcIP(String cdcIP) {
		this.cdcIP = cdcIP;
	}

	public int getCdcPort() {
		return cdcPort;
	}

	public void setCdcPort(int cdcPort) {
		this.cdcPort = cdcPort;
	}

	public String getCdcUser() {
		return cdcUser;
	}

	public void setCdcUser(String cdcUser) {
		this.cdcUser = cdcUser;
	}

	public String getCdcPWD() {
		return cdcPWD;
	}

	public void setCdcPWD(String cdcPWD) {
		this.cdcPWD = cdcPWD;
	}

	public int getCdcMonitorPort() {
		return cdcMonitorPort;
	}

	public void setCdcMonitorPort(int cdcMonitorPort) {
		this.cdcMonitorPort = cdcMonitorPort;
	}

	public String getCdcMonitorUser() {
		return cdcMonitorUser;
	}

	public void setCdcMonitorUser(String cdcMonitorUser) {
		this.cdcMonitorUser = cdcMonitorUser;
	}

	public String getCdcMonitorPWD() {
		return cdcMonitorPWD;
	}

	public void setCdcMonitorPWD(String cdcMonitorPWD) {
		this.cdcMonitorPWD = cdcMonitorPWD;
	}

	public String getCdcExtractName() {
		return cdcExtractName;
	}

	public void setCdcExtractName(String cdcExtractName) {
		this.cdcExtractName = cdcExtractName;
	}

	public String getCdcSubName() {
		return cdcSubName;
	}

	public void setCdcSubName(String cdcSubName) {
		this.cdcSubName = cdcSubName;
	}

	public int getCdcBatchNum() {
		return cdcBatchNum;
	}

	public void setCdcBatchNum(int cdcBatchNum) {
		this.cdcBatchNum = cdcBatchNum;
	}
}

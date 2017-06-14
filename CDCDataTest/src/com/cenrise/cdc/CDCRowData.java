package com.cenrise.cdc;

import java.util.List;

/*
 * 从CDC获取到的增量数据
 */
public class CDCRowData {
	String batchID;// 增量数据的批次号
	List<Object[]> cdcRowData;// 增量数据
	boolean isHaveNext;// 是否还有增量数据

	public String getBatchID() {
		return batchID;
	}

	public void setBatchID(String batchID) {
		this.batchID = batchID;
	}

	public List<Object[]> getCdcRowData() {
		return cdcRowData;
	}

	public void setCdcRowData(List<Object[]> cdcRowData) {
		this.cdcRowData = cdcRowData;
	}

	public boolean isHaveNext() {
		return isHaveNext;
	}

	public void setHaveNext(boolean isHaveNext) {
		this.isHaveNext = isHaveNext;
	}

}

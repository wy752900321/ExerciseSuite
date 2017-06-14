package com.cenrise.cdc;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.vbill.cdc.common.CDCException;
import cn.vbill.cdc.common.subcription.model.SubFilterConfig;
import cn.vbill.cdc.common.subcription.model.SubscriptionInfo;
import cn.vbill.cdc.dataservice.client.BatchMsgData;
import cn.vbill.cdc.dataservice.client.DataServiceClient;
import cn.vbill.cdc.dataservice.client.RowDataInfo;
import cn.vbill.cdc.dataservice.subscription.Subscriber;

/*
 * CDC服务器的数据服务接口
 */
public class CDCDataServiceImpl {
	private static final Logger logger = LoggerFactory.getLogger(CDCDataServiceImpl.class);
	private DataServiceClient client;

	public CDCDataServiceImpl(String subName, String cdcServerIP, String cdcServerPort, String cdcServerUser,
			String cdcServerPassword) {
		client = new DataServiceClient(subName, new InetSocketAddress(cdcServerIP, Integer.parseInt(cdcServerPort)),
				cdcServerUser, cdcServerPassword, 1000);
		client.connect();
	}

	public CDCDataServiceImpl(String subName, String cdcServerIP, int cdcServerPort, String cdcServerUser,
			String cdcServerPassword) {
		client = new DataServiceClient(subName, new InetSocketAddress(cdcServerIP, cdcServerPort), cdcServerUser,
				cdcServerPassword, 1000);
		client.connect();
	}

	/*
	 * 在CDC服务器上取消订阅
	 */
	public boolean unSubscriptionTable(String extractName) throws Exception {
		try {
			// client.connect();
			client.unSub(extractName);
			client.disconnect();
			return true;
		} catch (Exception e) {
			client.disconnect();
			throw e;
		}
	}

	/*
	 * 从CDC服务器上获取抽取实例上的订阅信息
	 */
	public List<String[]> getSubInfo(String extractID) {
		List<Subscriber> subList = client.getClientSubInfosByExtractId(extractID);
		List<String[]> subInfos = new ArrayList<String[]>();
		if (subList != null && !subList.isEmpty()) {
			for (Subscriber sub : subList) {
				String[] subinfo = { sub.getExtractId(), sub.getSubId() };
				subInfos.add(subinfo);
			}
		}
		client.disconnect();
		return subInfos;
	}

	/*
	 * 判断CDC服务器上是否存在此订阅
	 */
	public boolean ifExistSubName(String extractID, String subName) {
		List<Subscriber> subList = client.getClientSubInfosByExtractId(extractID);
		client.disconnect();
		if (subList != null && !subList.isEmpty()) {
			for (Subscriber sub : subList) {
				if (sub.getSubId().equals(subName)) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * 获取订阅的详细信息
	 */
	public SubFilterConfig getSubDetailInfo(String extractID, String subID) {
		List<Subscriber> subList = client.getClientSubInfosByExtractId(extractID);
		client.disconnect();
		if (subList != null && !subList.isEmpty()) {
			for (Subscriber sub : subList) {
				if (sub.getSubId().equals(subID)) {
					return sub.getFilterConfig();
				}
			}
		}
		return null;
	}

	/*
	 * 获取增量数据
	 */
	public CDCRowData getData(String extractName, int batchsize) {
		// client.connect();
		// update by dongpo.jia 20170419
		// BatchMsgData batchData = client.getBatchMsgData(extractName,
		// batchsize);//获取批量数据
		BatchMsgData batchData = client.getMsgBatch(extractName, batchsize);// 获取批量数据

		CDCRowData rowData = new CDCRowData();
		if (batchData != null) {
			rowData.setBatchID(batchData.getBatchId());// 保存批次ID

			List<Object[]> cdcRowDataObj = new ArrayList<Object[]>();

			List<RowDataInfo> rowDataList = batchData.getDatas();// 获取批次数据
			Iterator<RowDataInfo> iter = rowDataList.iterator();
			while (iter.hasNext()) {
				RowDataInfo rowDataInfo = iter.next();
				List<Object> listObject = rowDataInfo.getColumnValues();
				String operationtype = "none";
				if ("1".equalsIgnoreCase(rowDataInfo.getOperType())) {
					operationtype = "insert";
				} else if ("2".equalsIgnoreCase(rowDataInfo.getOperType())) {
					operationtype = "update";
				} else if ("3".equalsIgnoreCase(rowDataInfo.getOperType())) {
					operationtype = "delete";
				}
				listObject.add(operationtype);// 添加数据的操作类型
				cdcRowDataObj.add(listObject.toArray());
			}

			rowData.setCdcRowData(cdcRowDataObj);
		}
		return rowData;
	}

	/*
	 * 提交已经消费过的数据
	 */
	public boolean commitData(String extractName, String batchID) {

		try {
			client.ackMsg(batchID, extractName);

			client.disconnect();
			logger.info("commitData result:" + true);
			return true;
		} catch (CDCException e) {
			client.disconnect();
			logger.info("commitData result:" + false);
			return false;
		}
	}

	/*
	 * 在CDC服务器上添加订阅数据
	 */
	public String startSubscriptionTable(String tableName, String extractName, String schema,
			LinkedHashMap<String, String> columnInfo) {
		try {
			// 连接CDC Client
			// client.connect();
			// 构造订阅信息对象
			SubscriptionInfo info = new SubscriptionInfo();
			info.setExtractId(extractName);
			// 构造订阅table，columns 对象
			SubFilterConfig config = new SubFilterConfig();
			// 修改当数据库时MYSQL数据库时，使用数据库名称作为schema的参数值 add by liuxu TIETL-1679
			config.setSchemaName(schema);

			List<SubFilterConfig.Table> tables = new ArrayList<SubFilterConfig.Table>();

			SubFilterConfig.Table t = new SubFilterConfig.Table();
			t.setName(tableName);

			List<SubFilterConfig.Column> cs = new ArrayList<SubFilterConfig.Column>();
			Iterator<String> columnIter = columnInfo.keySet().iterator();
			while (columnIter.hasNext()) {
				String columnname = columnIter.next();
				SubFilterConfig.Column c = new SubFilterConfig.Column();
				c.setName(columnname);
				c.setType(columnInfo.get(columnname));
				cs.add(c);
			}
			t.setColumns(cs);

			tables.add(t);

			config.setTables(tables);

			info.setSubFilterConfig(config);

			client.sub(SubscriptionInfo.toByteArray(info));
			client.disconnect();
			return "true";
		} catch (CDCException e) {
			client.disconnect();
			return e.getMessage();
		}
	}

	public void rollback(String subID) throws Exception {

		client.rollbackMsg(subID);
		client.disconnect();
	}

	public void disConnect() {
		client.disconnect();

	}

	public void connect() {
		client.connect();
	}

	public boolean isConnect() {
		return client.isConnected();
	}
}

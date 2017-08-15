package com.tongtech.cdc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tongtech.ti.cdc.mng.client.JMXCDCClient;
import com.tongtech.ti.cdc.mng.common.ExtractInfo;
/*
 * CDC服务器的监控管理接口
 */
public class CDCJMXServiceImpl {
	private static final Logger logger = LoggerFactory.getLogger(CDCJMXServiceImpl.class);
	private JMXCDCClient jmxClient;

	public CDCJMXServiceImpl(String cdcServerIP, String monitorPort, String monitorUser, String monitorPassword) {
		jmxClient = new JMXCDCClient();
		jmxClient.setIp(cdcServerIP);
		jmxClient.setPort(Integer.parseInt(monitorPort));
		jmxClient.setUser(monitorUser);
		jmxClient.setPwd(monitorPassword);
	}
	/*
	 * 检测抽取实例名称是否存在
	 */
	public boolean checkIsExistCdcExtract(String id) throws Exception{
		logger.debug("cdc check id="+id+"  is or not exist!");
		
		jmxClient.connect();
		List<ExtractInfo> list = jmxClient.getCDCServerRunningInfo().getExtractServerInfo().getExtracts();
		jmxClient.close();
		
		logger.debug("cdc extract info sum="+list.size());
		for(ExtractInfo info:list){
			if(id.equals(info.getId())){
				return true;
			}	
		}
		return false;
	}
	//获取抽取实例名称
	public String getCDCExtractNames() throws Exception{
		logger.debug("get cdc extract names:...");
		jmxClient.connect();
		
		List<ExtractInfo> extractInfos = jmxClient.getCDCServerRunningInfo().getExtractServerInfo().getExtracts();
		jmxClient.close();
		
		if(extractInfos != null && !extractInfos.isEmpty()){
			String[] extractNames = new String[extractInfos.size()];
			int i = 0;
			for(ExtractInfo ei : extractInfos){
				extractNames[i++] = ei.getId();
			}
			extractInfos.clear();
			return extractNamesToString(extractNames);
		}
		return null;
	}
	
	private String extractNamesToString(String[] extractNames) {
		StringBuffer retval = new StringBuffer(250);
		for(String name : extractNames){
			retval.append(name+",");
		}
		return retval.toString();
	}
}

package com.friend.system.manger.cn.util;

public class LimitUtil {
	private static int pageCount =3;
	/**
	 * 根据总共的数据数 查询出 总共 分出的页数
	 * @param count
	 * @return
	 */
	public static int getTotalPages(int count){
		int result = 0;
		result = count%pageCount==0?count/pageCount:count/pageCount+1;
		return result;
	}
	
	public static int getStart(int nowPage){
		int result = 0;
		result = pageCount*(nowPage-1);
		return result;
	}
	public static int getPageCount(){
		return pageCount;
	}
}

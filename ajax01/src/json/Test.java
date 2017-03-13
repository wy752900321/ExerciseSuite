package json;

import java.util.ArrayList;
import java.util.List;

import sun.applet.Main;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import bean.Stock;

public class Test {
	/*
	 * {'stockCode':'600015','price':10}
	 */
	public static void test1(){
		Stock s = new Stock();
		s.setStockCode("60015");
		s.setPrice(10);
		JSONObject obj = JSONObject.fromObject(s);
		String str = obj.toString();
		System.out.println(str);
	}
	  /*
	 * [{'stockCode':'600015','price':10},
	 * {'stockCode':'600022','price':20}]
	 */
	public static void test2()	{
		List<Stock> stocks = new ArrayList<Stock>();
		Stock s = new Stock();
		s.setStockCode("60015");
		s.setPrice(10);
		stocks.add(s);
		Stock s2 = new Stock();
		s2.setStockCode("600022");
		s2.setPrice(20);
		stocks.add(s2);
		JSONArray obj = JSONArray.fromObject(stocks);
		String str = obj.toString();
		System.out.println(str);
	}
	public static void main(String[] args) {
		test1();
		test2();
	}
}

package test;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import bean.Option;

public class ToJsonTest {
	/*java对象－＞JSON字符串*/
	public static void test2(){
		////{"cityName":"海淀","cityValue":"hd"}
		Option op = new Option("海淀","hd");
		JSONObject obj = JSONObject.fromObject(op);
		String str = obj.toString();
		System.out.println(str);
	}
	
	/*数组对象->JSON字符串*/
	public static void test3(){
		////{"cityName":"海淀","cityValue":"hd"}
		Option op = new Option("海淀","hd");
		Option op2 = new Option("东城","dc");
		Option op3 = new Option("西城","xc");
		Option[] ops = {op,op2,op3};
		JSONArray obj = JSONArray.fromObject(ops);
		String str = obj.toString();
		System.out.println(str);
	}
	
	/*List对象->JSON字符串*/
	public static void test4(){
		////{"cityName":"海淀","cityValue":"hd"}
		Option op = new Option("海淀","hd");
		Option op2 = new Option("东城","dc");
		Option op3 = new Option("西城","xc");
		List<Option> ops = new ArrayList<Option>();
		ops.add(op);
		ops.add(op2);
		ops.add(op3);
		JSONArray obj = JSONArray.fromObject(ops);
		String str = obj.toString();
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		test2();
		test3();
		test4();
	}
}

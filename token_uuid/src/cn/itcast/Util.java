package cn.itcast;

public class Util {
	private static Util test;
	private Util(){
	}
	public static Util getInstance(){
		if(test==null){
			test=new Util();
		}
		return test;
	}
}

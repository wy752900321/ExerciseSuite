package basic.day18.mldn.generics;

public class GenericsDemo06 {
	public static void main(String[] args) {
		Point5<String> p = new Point5<String>();
		p.setVar("贾东坡");//设置字符串
		System.out.println(p.getVar().length());//取得字符长度
	}
}

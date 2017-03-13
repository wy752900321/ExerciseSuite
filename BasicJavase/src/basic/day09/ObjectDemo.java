package basic.day09;

public class ObjectDemo {
	public static void main(String[] args) {
		Point2  p = new Point2();
		String str = p.toString();
		System.out.println(str);//basic.day09.Point2@9304b1
		System.out.println(p);//basic.day09.Point2@9304b1,java默认调用p.toString()
		/**
		  	打印对象信息.Object.toString() 返回全限定名＠hashCode()
		  	全限定名：package.classname
		  	hashCode:是内存地址经过转换得到的一个整数，但不是内存地址
		  	java(sun)建议覆盖掉toString()!
		  	覆盖为对象的文本描述，如（）
		 */
		
	}
}
class Point2 /** extends Object*/ { //java类默认继承于Object,啥都是东西
	
}
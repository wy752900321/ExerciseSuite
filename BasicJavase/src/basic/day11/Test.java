package basic.day11;

/**String的，intern()方法
	它遵循以下规则：对于任意两个字符串 s 和 t，当且仅当 s.equals(t) 为 true 时，
	s.intern() == t.intern() 才为 true。 
	一个字符串，内容与此字符串相同，但一定取自具有唯一字符串的池。
	这种规则叫“字符串扣留”。用于检查当前字符串是否惟一。也可省内存。
*/
public class Test {
public static void main(String[] args) {
	String st = "Welcom to ";
	System.out.println(st.charAt(2));//返回指定位置的字符串
	String st1 = "beijing";
	System.out.println(st.concat(st1));//连接两个字符串
	System.out.println(st1.substring(4));//从第几个位置提取字符串
	System.out.println(st1.substring(2,4));//从第二个提取到第四个字符串
	String st2 = null ;//String不赋值的话，可以另其等于null，不然使用时出错
	if(st2==null){//用这个语句测试String变量是否指向了某值
		System.out.println("st1 does not refer to anything!");
	}
	
	String string1 = "Too many ";
	String string2 = "cooks";
	String string3 = "Too many cooks";
	string1+=string2;
	string1=string1.intern();
	System.out.println(string1);//Too manycooks

	System.out.println(string1==string3);//true
}
}

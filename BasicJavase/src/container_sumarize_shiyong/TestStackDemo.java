package container_sumarize_shiyong;

import java.util.Stack;

/**Stack类
 	Vector的子类，模拟栈
 	在见面浏览器中有一个后退按钮，每次点击后退都会回到上一步操作，实际上就是一个栈的应用，
 	类似的还有Office工具的撤销操作等，都是采用一个先进后出的操作。
 */
public class TestStackDemo {
public static void main(String[] args) {
	Stack s = new Stack();
	s.push("java");//把项压入堆栈顶部,首次创建堆栈时，它不包含项
	s.push("C++");
	s.push("VB");
	System.out.println(s);//[java, C++, VB]，输出顺序为入栈的顺序
	
	//访问第一个元素，但是不让第一个元素出栈（pop）
	System.out.println(s.peek());//VB,查看堆栈顶部的对象，但不从堆栈中移除它。
	System.out.println(s);//[java, C++, VB]
	
	//将第一个元素压出栈
	System.out.println(s.pop());//VB,移除堆栈顶部的对象，并作为此函数的值返回该对象
	System.out.println(s);//[java, C++]
	
	//返回对象在堆栈中的位置
	System.out.println(s.search("java"));//2
	System.out.println(s.search("C++"));//1
}
}

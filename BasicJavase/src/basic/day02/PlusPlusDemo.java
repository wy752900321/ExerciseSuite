package basic.day02;

/**自增运算++ Plus Plus C++/C Plus Plus CPP*/
public class PlusPlusDemo {

	public static void main(String[] args) {
		
		int a = 1;
		a++;
		System.out.println(a);//2
		++a;
		System.out.println(a);//3
		a = 1;
		int b = a++;
		/*
		 * 后++ 
		 * 		1)取a的值1作为当前表达式a++的值1
		 * 		2）将a的值增加1，a为2
		 * 		3)执行赋值运输将表达式a++的值1 赋值给b ,b 为 1
		 */
		System.out.println("a="+a+",b="+b);//a=2,b=1
		
		a = 1;
		b = ++a;
		/*
		 * 前++ 
		 * 		1)先将a的值增加1，a为2
		 * 		2）将a值2作为表达式++a的值2
		 * 		3)执行赋值运算，将++a的值2，赋值给b,b为2
		 */
		System.out.println("a="+a+",b="+b);//a=2,b=2
		
		a = 1;
		a = a++;
		/*
		 * 后++ 
		 * 		1)取a的值1作为当前表达式a++的值1
		 * 		2）将a的值增加1，a为2
		 * 		3)执行赋值运输将表达式a++的值1 赋值给b ,b 为 1
		 */
		System.out.println("a="+a);//a=1
		
		
		a = 1;
		a = ++a;
		/*
		 * 前++ 
		 * 		1)先将a的值增加1，a为2
		 * 		2）将a值2作为表达式++a的值2
		 * 		3)执行赋值运算，将++a的值2，赋值给b,b为2
		 */
		System.out.println("a="+a);//a=2
		
		int i = 0;
		System.out.println(i++%3);//0
		System.out.println(i++%3);//1
		System.out.println(i++%3);//2
		System.out.println(i++%3);//0
		System.out.println(i++%3);//1
		System.out.println(i++%3);//2
		System.out.println(i++%3);//0
		System.out.println(i++%3);//1
		System.out.println(i++%3);//2

		String[] names = {"春哥","曾哥","葛大爷"};
		System.out.println(names[i++%3]);//春哥
		System.out.println(names[i++%3]);//曾哥
		System.out.println(names[i++%3]);//葛大爷
		System.out.println(names[i++%3]);//春哥
		System.out.println(names[i++%3]);//曾哥
		System.out.println(names[i++%3]);//葛大爷
		System.out.println(names[i++%3]);//葛大爷
		System.out.println(names[i++%3]);//春哥
		System.out.println(names[i++%3]);//曾哥
		System.out.println(names[i++%3]);//葛大爷

		
	}

}

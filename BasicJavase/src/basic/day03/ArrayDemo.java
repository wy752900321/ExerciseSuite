package basic.day03;

public class ArrayDemo {

	public static void main(String[] args) {
		//声明数组变量（代词),数组变量是引用类型
		String[] names;
		int[] ary;
		double[] ary1;
//		System.out.println(ary[0]);//编译错误，ary没有初始化+6
		//null 空，没有
		ary = null;//初始化ary为null
//		System.out.println(ary[0]);//运行异常，java.lang.NullPointerException
		//创建(初始化）数组对象，必须指定数组大小(元素数量)
		//数组对象大小不可变(固定的)
		//数组下标(序号)：0、1........length-1
		//数组的元素是自动初始化的，值为"零值"：0,0.0,\u0000,false,null
		ary = new int[3];
		System.out.println(ary[0]);//0
		
		//System.out.println(ary[3]
		//选择输出结果：A编译错 B.运行异常 C.0	D.null
//		ary5[1] = 8;//写数组元素
//		System.out.println(ary5[0]);
//		System.out.println(ary5[1]);
//		System.out.println(ary5[2]);
//		int[] ary6 = ary5
		int ary5[];
		ary5 = new int[]{7,8,9,10};
		// 		-x ->{0,8,0}
		//	ary5-->{7,8,9,10}
		System.out.println(ary5[0]);
		System.out.println(ary5[1]);
		System.out.println(ary5[2]);
		System.out.println(ary5[3]);
		
		//不建议使用的声明数组变量的写法
		int ary8[];//等价于int[] ary8,就是为了C语言习惯兼容。
		
		//访问数组的长度.length属性
		System.out.println(ary5.length);//4
		//ary5.length  = 8;//编译错误，不能修改数组长度
		//关于关键字：new , if ,int 等
		//关键字不能用来命名
		//50个关键字
		//保留字(保留关键字，java留下的)(goto const)
		//不是关键字：null,true ,false是字面量
	}

}

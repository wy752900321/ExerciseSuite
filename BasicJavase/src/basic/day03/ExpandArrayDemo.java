package basic.day03;

import java.util.Arrays;

public class ExpandArrayDemo {

	/**
	 * 数组扩容算法
	 */
	public static void main(String[] args) {
		//数组对象的大小是不能改变的！
		//在实际应用中需要提供能够修改大小的数组！
		//可以采用复制数组对象到新的数组中，新数组的长度超过原数组
		//变通实现数组的容量改变
		int[] ary1 = {6,7,8};
		int[] temp = Arrays.copyOf(ary1, ary1.length+1);
		//temp = {6,7,8,0};
		ary1 = temp;//抛弃原数组
		ary1[ary1.length-1] = 9;
		System.out.println(Arrays.toString(ary1));
		
		ary1 = Arrays.copyOf(ary1, ary1.length+1);
		ary1[ary1.length-1]=10;
		System.out.println(Arrays.toString(ary1));
	}

}

package basic.day04;

import java.util.Arrays;

/**
 2) 冒泡排序
  原理: a 逐一比较数组中相邻的两个元素, 如果后面
         的数字小于前面的数字, 就交换先后元素.
       b 经过一个轮次的比较, 一定有一个最大的排
         在最后的位置.
       c 每次比较剩下的元素, 经过n-1次比较, 可以
         实现排序 
         	i代表次数
			j代表比较位置
 */
public class SortDemo02 {


	public static void main(String[] args) {
		int[] ary = {8,2,3,7,1};
		bobuble(ary);
		System.out.println(Arrays.toString(ary));
		

	}
	public static void bobuble(/*final*/ int[] ary){//加上final，数组正常运行
		for(int i = 0;i<ary.length-1;i++){
			for(int j=0;j<ary.length-i-1;j++){
				System.out.print(Arrays.toString(ary));
				System.out.print(" i=" +i);
				System.out.print(" j=" +j);
				System.out.print(" j+1=" +(j+1));
				System.out.print(" [j]=" +ary[j]);
				System.out.print(" [j+1]" +ary[j+1]);
				System.out.print(" [j]>[j+1]" +(ary[j]>ary[j+1]));
				if(ary[j]>ary[j+1]){
					System.out.print(""+ary[j]+"<->"+ary[j+1]);
					int temp = ary[j];
					ary[j] = ary[j+1];
					ary[j+1] = temp;
				}
					System.out.println();
			}
		}
	}
}
/**
	简单说: 比较相邻元素,大的向后交换
	原理说明:
	ary={8,2,3,7,1}
	ary={2,8,3,7,1}
	ary={2,3,8,7,1}
	ary={2,3,7,8,1}
	ary={2,3,7,1|8}
	ary={2,3,7,1|8}
	ary={2,3,7,1|8}
	ary={2,3,1|7,8}
	ary={2,3,1|7,8}
	ary={2,1|3,7,8}
	ary={1,2,3,7,8}

	 ary        i  j j+1  ary[j] ary[j+1] [j]>[j+1] [j]<->[j+1]
	{8,2,3,7,1} 0 0  1    8       2       true      8<->2
	{2,8,3,7,1} 0 1  2    8       3       true      8<->3
	{2,3,8,7,1} 0 2  3    8       7       true      8<->7
	{2,3,7,8,1} 0 3  4    8       1       true      8<->1
	{2,3,7,1|8} 1 0  1    2       3       false     
	{2,3,7,1|8} 1 1  2    3       7       false 
	{2,3,7,1|8} 1 2  3    7       1       true      7<->1
	{2,3,1|7,8} 2 0  1    2       3       false
	{2,3,1|7,8} 2 1  2    3       1       true      3<->1
	{2,1|3,7,8} 3 0  1    2       1       true      2<->1
	{1,2,3,7,8}
	i = 0~ < ary.length-1
	 j = 0~ < ary.length - i -1;  
	   if([j]>[j+1]){
		    [j]<->[j+1]
	   }
*/
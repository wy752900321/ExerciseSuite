package basic.day04;

import java.util.Arrays;

public class SortDemo01 {

	/**
		 1) 选择排序
   原理:a 将数组中的每个元素,与第一个元素比较
          如果这个元素小于第一个元素, 就将这个
         两个元素交换.
       b 每轮使用a的规则, 可以选择出一个最小元素
        放到第一个位置.
       c 经过n-1轮比较完成排序
	   d 代表第一个数据的位置
	   e 代表后部每一个数据的位置+..
   简单说: 每轮选择最小的放到前面.
      i 代表第一个数                       据的位置
	   j 代表后部每一个数据的位置
	 */

	public static void main(String[] args) {
		int[] ary = {6,9,2,4,1,5};
		selectionSort(ary);
		System.out.println(Arrays.toString(ary));
		

	}
	public static void selectionSort(int[] ary){
		for(int i = 0;i<ary.length-1;i++){
			for(int j=i+1;j<ary.length;j++){
				if(ary[i]>ary[j]){
					int t = ary[i];
					ary[i] = ary[j];
					ary[j] = t;
				}
			}
		}
	}
}
/**
 	｛8,2，3，7，1}	i	j	ary[i] ary[j] ary[i]>ary[j] [i]<->[j]
	｛8|2，3，7，1｝	0	1	8		2		true		8<->2
	｛2|8，3，7，1｝	0	2	2		3		false		
	｛2|8，3，7，1｝	0	3	2		7		false		
	｛2|8，3，7，1｝	0	4	2		1		true		2<->1
	｛1,8|3，7，2｝	1	2	8		3		true		8<->3
	｛1,3|8，7，2｝	1	3	3		7		false
	｛1,3|8，7，2｝	1	4	3		2		true		3<->2
	｛1,2,8|7，3｝	2	3	8		7		true		8<->7
	｛1,2,7|8，3｝	2	4	7		3		true		7<->3
	｛1,2,3,8|7｝	3	4	8		7		true		8<->7
	｛1,2,3,7,8｝	,,,,,,,,,,,,
 */
/**
	 	  原理说明:
	   ary={8,2,3,7,1} 
	   ary={1|8,3,7,2}
	   ary={1,2|8,7,3}
	   ary={1,2,3|8,7}
	   ary={1,2,3,7|8}
	   代码分析:
	
	   ary      i j ary[i] ary[j] ary[i]>ary[j] [i]<->[j]
	{8|2,3,7,1} 0 1   8      2        true        8<->2
	{2|8,3,7,1} 0 2   2      3        false
	{2|8,3,7,1} 0 3   2      7        false
	{2|8,3,7,1} 0 4   2      1        true        2<->1
	{1,8|3,7,2} 1 2   8      3        true        8<->3
	{1,3|8,7,2} 1 3   3      7        false        
	{1,3|8,7,2} 1 4   3      2        true        3<->2
	{1,2,8|7,3} 2 3   8      7        true        8<->7
	{1,2,7|8,3} 2 4   7      3        true        7<->3
	{1,2,3,8|7} 3 4   8      7        true        8<->7
	{1,2,3,7,8}   
	  i= 0 ~ < ary.length - 1;
	    j=i+1 ~ <ary.length
		  if(ary[i]>ary[j]){
		  	int t=ary[i];ary[i]=ary[j];ary[j]=t;
		  }
	      
 */

package basic.day04;

import java.util.Arrays;

/**
	3) 插入排序
  原理: a 将数组分为两部分, 将后部分的第一张逐一
         与前部分每一张比较, 如果当前元素小, 就
         放在前边
        temp 代表取出的待插入元素
   		i 代表后组待插入元素 位置
   		j 代表前组每个元素的位置
 */
public class SortDemo03 {


	public static void main(String[] args) {
		int[] ary = {8,2,3,7,1};
		insertSort(ary);
		System.out.println(Arrays.toString(ary));
		

	}
	//i代表待插入的元素，j代表前边的元素。temp临时的 取出的
	public static void insertSort(int[] ary){
		int i,j,temp;
		for(i=1;i<ary.length;i++){
			temp = ary[i];
			for(j=i-1;j>=0&& temp<ary[j];j--){
				//move ary[j] ->ary[j++1]
				ary[j+1] = ary[j];
			}
			ary[j+1]=temp;
		}
	}
}

/**
	  原理说明:
   temp = 1
  {8|2,3,7,1}
  {2,8|3,7,1}
  {2,3,8|7,1}
  {2,3,7,8|1}
  {2,3,7,7|8}
  {2,3,3,7|8}
  {2,2,3,7|8}
  {1,2,3,7|8}


                                     (移动)     插入
   ary      i  t  j  ary[j]  t<[j] [j]->[j+1] t->[j+1]
{8|2,3,7,5} 1  2  0    8     true   8->[j+1]   
{8|8,3,7,5} 1  2 -1                            2->[j+1]
{2,8|3,7,5} 2  3  1    8     true   8->[j+1]
{2,3|8,7,5} 2  3  0    2     false             3->[j+1]
{2,3,8|7,5} 3  7  2    8     true   8->[j+1]
{2,3,7|8,5} 3  7  2    3     false             7->[j+1]
{2,3,7,8|5} 4  5  3    8     true   8->[j+1] 
{2,3,7,5|8} 4  5  2    7     true   7->[j+1] 
{2,3,7,7|8} 4  5  1    3     false             5->[j+1]
{2,3,5,7|8} 5
 
 i= 1 ~ <ary.length, i++
	 t = [i];
		 j= i-1 ~ >=0, j--
		 if(t<[j]){
		 	[j]->[j+1] //移动
		 }else{
		  	break j;
		 }
	 t->[j+1]//插入
 */
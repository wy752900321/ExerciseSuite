package basic.day04;

import java.util.Arrays;
import java.util.Random;

public class SortAPIDemo {

	/**
	 * 排序算法,测试程序运行快慢。System.currentTimeMillis()
	 */
	public static void main(String[] args) {
		//int[] ary = {4,1,6,8,9,10}
		int[] ary = new int[10000];//10000 * 4 Byte
		for(int i= 0;i<ary.length;i++){
			Random random = new Random();
			ary[i]=random.nextInt();
		}
		int[] ary1 = Arrays.copyOf(ary, ary.length);
		
		long t1 = System.currentTimeMillis();
		Arrays.sort(ary);
		long t2 = System.currentTimeMillis();
		SortDemo03.insertSort(ary1);
		long t3 = System.currentTimeMillis();
		
		System.out.println(Arrays.equals(ary, ary1));
		
		System.out.println(t2-t1);
		System.out.println(t3-t2);
//		System.out.println(Arrays.toString(ary));
		
//		int index = Arrays.binarySearch(ary, key);
//		System.out.println(key+"index:"+index);
		

	}

}

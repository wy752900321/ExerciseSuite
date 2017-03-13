package basic.day03.practice;

import java.util.Arrays;
import java.util.Scanner;

public class LotteryDrawing {

	/**
	 * 数组排序，抽数字游戏
	 */
	public static void main(String[] args) {
		
//		int[] numbers = new int[100];
//		for(int i=0;i<numbers.length;i++)
//			numbers[i]=i+1;
//		int[] result = new int[6];//抽出来的数值
//		/*
//		 * Math.random方法将返回一个0~1之间（含0、不含1）的随机浮点数。
//		 * 用n乘以这个浮点数，就可得到从0～n-1之间的一个随机数
//		 */
//		int r = (int)(Math.random()*100);
//		result[i] = numbers[r];
		
		/*
		 	每次抽取的都是下标，而不是实际的值
		 */
		Scanner in = new Scanner(System.in);
		System.out.println("How many numbers do you need to draw?");
		int n = in.nextInt();
		
		System.out.println("What is the highest number you can draw?");
		int k = in.nextInt();
		
		//fill an array with numbers 1,2,3,4,5......n
		int[] numbers = new int[n];
		for(int i=0;i<numbers.length;i++){
			numbers[i]=i+1;
		}
		
		//draw k numbers and put them into a second array
		int[] result = new int[k];
		for(int i=0;i<result.length;i++){
			
			//make a random index between 0 and n-1
			int r = (int)(Math.random()*n);
			
			//pick the element at the random location
			//将result的第i个元素设置为numbers[r]存放的数值
			result[i] = numbers[r];
			
			//move the last element into random location
			//因为所抽奖的数值不能一样，将数组最后一个值改成number[r],并将n-1
			numbers[r] =numbers[n-1];
			n--;
		}
		//print the sorted array
		Arrays.sort(result);
		System.out.println("Bet the following combination.It'll make you rich!");
		for(int r : result)
			System.out.println(r);
	}

}

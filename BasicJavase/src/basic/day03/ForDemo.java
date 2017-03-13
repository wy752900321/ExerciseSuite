package basic.day03;

import java.io.IOException;

public class ForDemo {

	public static void main(String[] args){
		
		 //10以内的偶数和
		int sum = 0;
		for(int i = 0;i<10;i+=2){
			sum+=i;
		}
		System.out.println(sum);
		
			//10以内的奇数和
			int sum2 = 0;
			for(int j = 1;j<10;j+=2){
				sum2+=j;
			}
			System.out.println(sum2);
		
	}
	
}
	
/*
*sum	i	i<10
*0		0	true
*0		2	true
*2		4	true
*6		6   true
*12		8	true
*20		10	false
*/
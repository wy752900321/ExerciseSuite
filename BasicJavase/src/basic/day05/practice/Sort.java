package basic.day05.practice;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		//—°‘Ò≈≈–Ú
		int temp=0;
		int[] ary = {9,5,3,4};
		for(int i=0;i<ary.length-1;i++){
			for(int j=i+1;j<ary.length;j++){
				if(ary[i]>ary[j]){
					temp = ary[i];
					ary[i] =ary[j];
					ary[j]=temp;
				}
			}
		}
		System.out.println(ary[0]);
		System.out.println(ary[1]);
		System.out.println(ary[2]);
		System.out.println(ary[3]);
		System.out.println(Arrays.toString(ary));
	}

}

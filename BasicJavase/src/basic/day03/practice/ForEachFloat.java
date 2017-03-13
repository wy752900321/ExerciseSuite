package basic.day03.practice;

import java.util.Random;

public class ForEachFloat {
	/*
	 * suppose you have an array of float and you¡¯d like to select each element
	 */
	public static void main(String[] args) {

		Random rand = new Random(47);
		float f[] = new float[10];
		for(int i=0;i<10;i++){
			f[i] = rand.nextFloat();
		//This defines a variable x of type float and 
		//sequentially assigns each element of f to x.
		for(float x : f)
			System.out.println(x);
		}
	}

}

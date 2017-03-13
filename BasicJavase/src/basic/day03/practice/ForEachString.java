package basic.day03.practice;

public class ForEachString {

	public static void main(String[] args) {
		/*
		 * String class has a method toCharArray( ) that returns an 
		 * array of char, so you can easily
		 *iterate through the characters in a string:
		 */
		for(char c : "An African Swallow".toCharArray())
			System.out.print(c+" ");

	}

}

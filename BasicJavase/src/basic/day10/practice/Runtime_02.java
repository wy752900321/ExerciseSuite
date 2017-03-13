package basic.day10.practice;

public class Runtime_02 {
	public static void main(String[] args) {

		int a[] = new int[5];
		
		for(int i=0;i<10;i++){
			a[i]=i+1;
			System.out.println(""+a[i]);//java.lang.ArrayIndexOutOfBoundsException:
		}
	}
}
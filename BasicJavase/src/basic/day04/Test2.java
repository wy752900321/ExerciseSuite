package basic.day04;

import java.util.Arrays;

	/**
	 * ÷‹ƒ©øº ‘Ã‚£¨√∞≈›≈≈–Ú
	 */
public class Test2 {

	public static void main(String[] args) {
		int arry[] ={7,8,4,6};
		bubbleSort(arry);
		System.out.println(Arrays.toString(arry));

	}
	public static void bubbleSort(int[] arry) {
	    int len = arry.length;
	    for (int i = 1; i < len; i++) {
	        boolean asc = true;
	 
	        for (int j = len - 1; j >= i; j--) {
	        	  if (arry[j] < arry[j - 1]) {
	        	    swap(arry, j, j - 1);
	        	    asc = false;
	        	  }
	        	}
	 
	 
	   if (asc)  return;
	    }
	}
	private static void swap(int[] arry, int i, int j) {
	    int temp = arry[i];
	    arry[i] = arry[j];
	    arry[j] = temp;
	}

}

/**
 A.for (int j = len-1; j > i; j--) {
  if (arry[j] < arry[j - 1]) {
    swap(arry, j, j - 1);
    asc = false;
  }

B.for (int j = len - 1; j >= i; j--) {
  if (arry[j] < arry[j - 1]) {
    swap(arry, j, j - 1);
    asc = false;
  }
}

C.for (int j = len - 1; j >= i; j--) {
  if (arry[j] > arry[j - 1]) {
    swap(arry, j, j - 1);
    asc = false;
  }
}

D.for (int j = len - 1; j >= i; j--) {
  if (arry[j] < arry[j - 1]) {
    swap(arry, j, j - 1);
    asc = true;
  }
}
*/

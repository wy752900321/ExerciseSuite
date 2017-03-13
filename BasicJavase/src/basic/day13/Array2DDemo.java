package basic.day13;

/**二维数组
	java没有真正的二维数组(有伪装的)
	java的二维数组是一维数组的一维数组，元素是数组的一维数组
 */
public class Array2DDemo {
public static void main(String[] args) {
	int[][] ary = {{1,2},{2,3},{4,5,5}};
	int[] ary1 = ary[1];
	System.out.println(ary1[0]);//2
	System.out.println(ary1[1]);//3
	
	ary[1] = new int[]{8,9};
	int[][] ary3 = {null,null,null};//new int[3][]
	int[][] ary4 = {null,{1,2},null};
}
}

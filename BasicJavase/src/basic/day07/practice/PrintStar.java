package basic.day07.practice;

public class PrintStar {

	/**
	15、在屏幕上打印出n行的金字塔图案，如，若n=5,则图案如下：
		        *
		       ***
		      *****
		     *******
		    *********
	 */
	//打印金字塔图案
	public static void main(String[] args) {
		for(int i=1;i<=5;i++){//i表示行数
			//打印空格
			for(int k=0;k<5-i;k++){
				System.out.print("");
			}
			//打印星星
			for(int j=0;j<2*i-1;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}

}

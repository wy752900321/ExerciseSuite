package basic.day04.practice;

public class ArraySort01 {

	/**
	 *对整形数组按照由小到大的顺序进行排序
	 *采用了冒泡算法进行了排序
	 */
	public static void main(String[] args) {
		int score[] = {67,89,87,69,90,100,75,90};
		for(int i=1;i<score.length;i++){
			for(int j=0;j<score.length;j++){
				if(score[i]<score[j]){
					int temp = score[i];
					score[i] = score[j];
					score[j] = temp;
				}
			}
			System.out.print("第"+i+"次排序的结果：\t");
			for(int j=0;j<score.length;j++){
				System.out.println(score[j]+"\t");
			}
			System.out.print(" ");
		}
		for(int i=0;i<score.length;i++){
			System.out.print(score[i]+"\t");
		}
	}

}

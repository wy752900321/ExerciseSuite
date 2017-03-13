package basic.day04.practice;

public class ArrayCompare {

	/**
	 * 求数组中的最大和最小值
	 */
	public static void main(String[] args) {
		int score[] = { 67,89,87,69,90,100,75,90};//表态初始化数组
		int max = 0;//定义变量保存最大值
		int min = 0;//定义变量保存最小值
		max = min = score[0];//把第一个元素的内容赋值给max和min
		for (int x = 0;x<score.length;x++){
			if(score[x]>max){
				max = score[x];
			}
			if(score[x]<min){
				min = score[x];
			}
		}
		System.out.println("最大值："+max);
		System.out.println("最小值："+min);

	}

}

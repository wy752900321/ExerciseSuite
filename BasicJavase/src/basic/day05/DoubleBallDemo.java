package basic.day05;

import java.util.Arrays;
import java.util.Random;

/**重点作业讲解
 * 双色球,取不同东西不经典算法。重要
 */
public class DoubleBallDemo {
	
	public static void main(String[] args) {
		String[] balls = gen();
		System.out.println(Arrays.toString(balls));
	}
	/** 生成一个双色球彩票号码*/
	public static String[] gen(){
		String[] pool = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17",
				"18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33"};
		boolean[] used =  new boolean[pool.length];//使用标记，每一个都是false
		Random random = new Random();
		String[] balls = new String[6];
		int i = 0;//代表生成的结果球的序号
		while(true){
			int index  = random.nextInt(pool.length);
			if(used[index]){		//如果使用了这个序号
				continue;			//继续下次循环
			}
			balls[i++]=pool[index];//取出一个球放到balls中，第一次放在0位置，以后不断加一
			used[index]=true;
			if(i==balls.length){
				break;
			}
		}
		Arrays.sort(balls);
		balls=(String[]) Arrays.copyOf(balls, balls.length+1);
		balls[i++]=pool[random.nextInt(16)];
		return balls;
	}

}

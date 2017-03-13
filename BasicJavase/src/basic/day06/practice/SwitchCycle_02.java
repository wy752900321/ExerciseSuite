package basic.day06.practice;

public class SwitchCycle_02 {
	public static void main(String[] args) {
		int level;
		level = (int) (Math.random() * 100);
		switch (level / 10) {
		case 6:
			System.out.println(level + "：一个刚刚合格的分数，还需在努力哦！");
			break;
		case 7:
			System.out.println(level + "：一个评为良的分数，还要加把劲啊！");
			break;
		case 8:
			System.out.println(level + "：一个评为良好的分数，加油啊！");
			break;
		case 9:
			System.out.println(level + "：一个优秀分数，你好棒啊！");
			break;
		default:
			System.out.println(level + "：一个不合格的分数，要十分努力才行！");
			break;
		}
	}
}
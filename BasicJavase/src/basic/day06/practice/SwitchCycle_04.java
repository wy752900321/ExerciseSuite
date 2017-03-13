package basic.day06.practice;

public class SwitchCycle_04 {
	public static void main(String args[]) {
		int m = 8;
		String s;					// s表示季节
		switch (m) {				// 这里m变量表示月份
		case 12:
		case 1:
		case 2:
			s = "Winter";			// 冬季
			break;
		case 3:
		case 4:
		case 5:
			s = "Spring";			// 春季
			break;
		case 6:
		case 7:
		case 8:
			s = "Summer";			// 夏季
			break;
		case 9:
		case 10:
		case 11:
			s = "Autumn";			// 秋季
			break;
		default:
			s = "Bogus Month";		// 这个月份是错误的
		}
		System.out.println("August is in the " + s + ".");
	}
}

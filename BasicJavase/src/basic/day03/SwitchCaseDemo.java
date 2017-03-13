package basic.day03;

public class SwitchCaseDemo {

	/**
	 * switch Demo
	 */
	public static void main(String[] args) {
		int score = 100;
		String level;
		switch(score/10){
		case 10:
		 case 9:
			level= "优";break;
		case 8:
			level="良";	break;
		case 7:
			level="中"; break;
		default:	
			level="不及格"; break;
		}
	
		System.out.println(level);

	}

}

package basic.day08.snake;

import java.util.Scanner;

public class WormDemo {
	public static void main(String[] args) {
		final WormPane pane = new WormPane();
		final Worm worm = pane.getWorm();
		
		Scanner s = new Scanner(System.in);
		while(true){
			pane.print();
			System.out.println(worm);
			String dir = s.nextLine();
			
			if(dir.equalsIgnoreCase("l")){
				worm.step(Worm.LEFT);
			}else if(dir.equalsIgnoreCase("r")){
				worm.step(Worm.RIGHT);
			}else if(dir.equalsIgnoreCase("q")){
				System.out.println("Bye ^_^");
				break;
			}else{
				worm.step();
			}
		}
	}
}

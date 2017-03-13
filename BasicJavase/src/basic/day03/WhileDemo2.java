package basic.day03;

public class WhileDemo2 {

	/**
	 * ÆË¿Ë
	 */
	public static void main(String[] args) {
		int i = 0;
		while(i<54){
			System.out.println(i++%3);
			if(i%3==0){
				System.out.println();
			}
		}
	}
}
/*
 * i	i<54	i++%3	i%3==0
 * 0	true	0		false
 * 1	true	1		false
 * 2	true	2		true
 * 3	true	0		false
 * 4	true	1		false
 * 5	true	2		false
 * 6	true	0		true
 * 7	true	1		false
 * 8	true	2		false
 * 9	true	0		true
 * ....
 * 53	true	
 * 54	false
 */

package basic.day02.practice;

/**
 *利用for循环打印 9*9  表?
1*1=1
1*2=2  2*2=4
1*3=3  2*3=6  3*3=9
1*4=4  2*4=8  3*4=12  4*4=16
1*5=5  2*5=10  3*5=15  4*5=20  5*5=25
1*6=6  2*6=12  3*6=18  4*6=24  5*6=30  6*6=36
1*7=7  2*7=14  3*7=21  4*7=28  5*7=35  6*7=42  7*7=49
1*8=8  2*8=16  3*8=24  4*8=32  5*8=40  6*8=48  7*8=56  8*8=64
1*9=9  2*9=18  3*9=27  4*9=36  5*9=45  6*9=54  7*9=63  8*9=72  9*9=81
 */

public class NineNine {

	public static void main(String[] args) {
		for(int i=1;i<10;i++){
			for(int j=1;j<10;j++){
				if(j>i) break;
				System.out.print(" "+j+"X"+i+"="+i*j);
			}
			System.out.println();
		}
		
	}
	
//    public static void main(String[]args){
//        for (int j=1;j<10;j++){
//            for(int k=1;k<10;k++) {   //老师的做法，判断语句里的 k<=j，省去下列的if语句。
//                if(k>j) break;       //此处用 continue也可以，只是效率低一点
//                System.out.print(" "+k+"X"+j+"="+j*k);
//             }
//            System.out.println();
//            }
//        }
	

}

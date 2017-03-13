package test;

public class ShapeDemo {
	public static void main(String[] args) {
/*		Shape s = new Circle(3,4,5);
		Point p = new Point(6,8);
		System.out.println(s.area());
		System.out.println(s.contains(p));
		
		Shape s1 = new Rect(1,2,4,5);
		Point p1 = new Point(3,3);
		System.out.println(s1.area());
		System.out.println(s1.contains(p1));*/
		
		Shape s = new Circle(5,5,3);
		Shape s1 = new Rect(1,2,4,5);
		
		print(s);
		print(s1);	
	}
	public static void print(Shape s){
		for(int y=0;y<10;y++){
			for(int x=0;x<20;x++){
				if(s.contains(x,y)){
					System.out.print("*");
				}else{
					System.out.print("");
				}
			}
			System.out.println();
		}
	}
}

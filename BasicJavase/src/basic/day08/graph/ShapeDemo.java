package basic.day08.graph;


public class ShapeDemo {

	public static void main(String[] args) {
		Shape[] shapes = new Shape[2];
		shapes[0] = new Circle(3,4,5);//圆心正好过圆点的圆
		shapes[1] = new Rectangle(4,4,8,6);
		/**多态：是继承中的现象
		 		1.父类型的子类型实例是多种多样的！
		 		2.具体对象的行为（方法）随着对象和参数类型发生变化
		 			如：图形是多态的，计算图形面积方法是多态的
		 		3.方法的多态可以通过方法覆盖和动态绑定现象支持的
		 */
		Shape s = shapes[0];
		System.out.println(s.area());//圆面积
		s = shapes[1];
		System.out.println(s.area());//矩形面积
		print(s);
		print(new Circle(8,8,6));
	}
	public static void print(Shape s){//多态的打印方法
		for(int y=0;y<40;y++){//控制行，就是纵坐标y,x是列,y是行
			for(int x=0;x<40;x++){//控制列，就是横坐标x
				if(s.contains(x,y)){//如果坐标在图形范围内就输出“0”
					System.out.print("0");//不要输出回车
				}else{
					System.out.print("");//空白位置输出空格！不是空串
				}
			}
			System.out.println();//一行输出一个回车
		}
	}
}

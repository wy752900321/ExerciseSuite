package basic.day06;

public class Point {
	/**点 类型*/
		int x;
		int y;
		/**构造器：初始化一个对象实例的过程
		 *语法要求：
		 *		A.构造器名词必须与类名一致
		 *		B.不能定义返回值
		 *		C.可以有参数，参数是初始化对象的前提条件
		 *在这个构造器中：参数x,y是初始化一个点对象的前提条件
		 */
		public Point(int x,int y){//Point(int)
			//this代表当前对象
			System.out.println("this.x="+this.x+",="+x);
			this.x=x;
			this.y=y;
			//方法签名：方法名＋参数类型列表（与参数名无关）
		//编译错误，与Point(int x)具有相同的方法签名：Point(int)
		}
		
		/**重载构造器，构造器代表初始化对角线上的点
		 * 重载的构造器：参数列表不同（参数类型，参数个数，参数顺序）
		 */
		
		public Point(int x){//Point(int)
			//this()调用的其他构造器
//		 this(x,x);
			this.x = x;
			this.y = x;
		}
		/*
		 * 方法，功能：计算当前点到原点的距离
		 * 是属于对象的方法，必须在对象上调用，this代表当前对象
		 * this经常可以省略
		 */
		
		public double distance(){
			//当前对象的引用
//			return Math.sqrt(this.x*this.x*+this.y*this.y);
			return Math.sqrt(x*x*+y*y);
		}
		/**计算当前点（this)到加外一点(other)的距离*/
		public double distance(Point other){
			return this.distance(other.x,other.y);//重用方法
		}
		/**计算当前点(this)到一个坐标(x,y)的距离*/
		public double distance(int x,int y){
			return Math.sqrt((this.x-x)*(this.x-x))+(this.y-y)*(this.y*y);
		}
}

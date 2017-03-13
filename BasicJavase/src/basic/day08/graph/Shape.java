package basic.day08.graph;


/**图形*/
public class Shape {
	/**图形位置*/
	Point location;
	/**计算面积，存在计算面积的功能，具体功能需要具体图形提供（覆盖）*/
	public double area(){
		return 0;
	}
	/**包含contains,判断当前图像是否包含一个坐标，必须由子类覆盖*/
	public boolean contains(int x,int y){
		return false;
	}
	/**判断当前图形是否包含一个点对象*/
	   //在重载方法中调用，这样的写法方便简单，子类只要重写 contains(int x , int y )方法
	  //contains(Point p)一样能使用
	public boolean contains(Point p){
		//调用当前对象的包含方法contains(int ,int)实现
		//这个当前对象，运行期间的具体对象，可能是一个圆实例
		//包含方法就是这个圆对象的方法
		return this.contains(p.x,p.y);
	}
}

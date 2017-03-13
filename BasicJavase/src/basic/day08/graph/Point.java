package basic.day08.graph;

/**点*/
public class Point {
	int x;
	int y;
	public Point(){
	}
	/**创建一个点必须以坐标(x,y)为前提*/
	public Point(int x ,int y){
		this.x=x;
		this.y=y;
	}
	/**计算当前点到一个坐标的距离*/
	public double distance(int x,int y){
		return Math.sqrt(this.x-x)*(this.x-x)+(this.y-y)*(this.y-y);
	}
	public double distance(Point other){
		return this.distance(other.x,other.y);
	}
	public double distance(){
		return this.distance(0,0);
	}
}

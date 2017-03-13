package basic.day09.packages;


/**
 *implements实现，（本质是继承）。java一个类只能继承一个父类
 *但可以实现多个接口，表达即是也是的关系：
 *QQ即是Car，也是Product,也是Object(东西)
 *
 *具体类实现接口要实现全部的抽象方法（接口方法）
 */
public class QQ extends Object implements Car,Product {
	public String getType() {
		return TYPE_A;//TYPE_A继承与Car
	}

	public void run() {
		System.out.println("跑了");
	}

	public void stop() {
		System.out.println("停了");
	}

	public double getPrice() {
		return 29999;
	}

}

package basic.day09.packages;

/**
 * java在编译期间按照“变量的类型“检查方法和属性
 */
public class QQDemo {
	public static void main(String[] args) {
		QQ qq = new QQ();
		// Car car = new Car();//不能创建接口实例Cannot instantiate the type Car
		Car car = qq;// 接口可以定义变量，引用具体实现类的实例（对象）
		car.run();
		car.stop();

		// 编译期间按类型检查
		Product p = qq;
		// System.out.println(car.getPrice());//编译错误，Car类型上没有getPrice()方法
		System.out.println(p.getPrice());

	}
}

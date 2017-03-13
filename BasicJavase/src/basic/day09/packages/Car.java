package basic.day09.packages;

/**抽象的汽车
 * 接口是纯抽象概念
 * 接口中只可以定义抽象方法和常量
 **/
public interface Car {
	/**public static */String TYPE_A = "A";
	/**public static */String TYPE_B = "B";	
	/**public static */String TYPE_C = "C";
	/**获取汽车级别：A B C*/
	/*public abstract */String getType();
	void run();
	void stop();
}

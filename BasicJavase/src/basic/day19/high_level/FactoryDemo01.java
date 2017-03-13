package basic.day19.high_level;

/**
 * 工厂设计模式 将反射应用到工厂模式上 使其在增加子类时可以不用做任何的修改，就可以达到功能的扩充。
 */
interface Fruit { // 水果接口
	public void eat();// 吃水果
}

class Apple implements Fruit {// 定义苹果
	public void eat() {// 覆写抽象方法
		System.out.println("**吃苹果。");
	}
}

class Orange implements Fruit {// 定义橘子
	public void eat() {
		System.out.println("**吃橘子");
	}
}

class Factory {
	public static Fruit getInstance(String className) {// 取得接口实例
		Fruit fruit = null;// 定义接口对象
		try {
			fruit = (Fruit) Class.forName(className).newInstance();// 实例化对象
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fruit;
	}
}

public class FactoryDemo01 {

	public static void main(String[] args) {
		// 通过工厂类取得接口实例，传入完整的包.类名称
		Fruit f = Factory.getInstance("basic.day19.high_level.Apple");
		if (f != null) {// 判断是否取得接口实例
			f.eat();// 调用方法
		}
	}
}

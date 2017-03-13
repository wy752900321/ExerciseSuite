package basic.day19.high_level;

import java.util.Properties;
/**
 * fruit.properties
 * 在属性文件中使用apple和orange表示完整的包.类名称，这样在使用时直接通过属性名称即可
 */
public class FactoryDemo02 {
	public static void main(String[] args) {
		Properties pro = Init.getPro();//初始化属性类
		//通过工厂类取得接口实例，通过属性的key传入完整的包.类名称
		Fruit f = Factory.getInstance(pro.getProperty("apple"));
		if(f != null){//判断是否取得接口实例
			f.eat();//调用方法
		}
	}
}

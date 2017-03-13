package basic.day19.agent;
/**
 * 定义真实主题实现类
 * 此类定义了接口及真实主题类，这样在操作时直接将真实主题类的对象传入到
 * MyInvocationHandler类的bind()方法中即可
 */
public class RealSubject implements Subject {//真实实现类

	public String say(String name, int age) {//覆写say()方法
		return "姓名:"+name+",年龄："+age;  //返回信息
	}

}

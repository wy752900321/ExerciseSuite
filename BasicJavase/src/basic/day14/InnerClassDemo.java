package basic.day14;

import basic.day14.Goo.Koo;

public class InnerClassDemo {
	public static void main(String[] args) {
		Goo g1 = new Goo();
		// Koo koo = new Koo();//编译错误，必须创建Goo实例，利用实例创建
		Koo koo1 = g1.new Koo();
		Koo koo2 = g1.new Koo();
		koo1.test();
		koo2.test();
		// 多个成员内部类共享同一个外部类实例的属性，
		// 如：koo1和koo2共享同一个g1对象的属性
		Goo g2 = new Goo();
		g2.a = 8;
		Koo k1 = g2.new Koo();
		Koo k2 = g2.new Koo();
		k1.test();
		k2.test();
	}
}

class Goo {
	int a = 1;

	class Koo {// 成员内部类，不加static为成员内部类，加static是静态内部类
		public void test() {
			System.out.println(a);
		}
	}
}
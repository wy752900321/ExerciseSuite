package basic.day19.zhuangshiqi;
//装饰器模式示例
public class Test {
	public static void main(String[] args) {
//		Coffee coffee = new Coffee();
//		Drink drink = new Sugar_Coffee(coffee);
		
		Drink drink = new Sugar_Coffee(new Coffee());
		double price=drink.cost();
		System.out.println(price);
	}
}

package basic.day12;

public class ShopDemo {

	public static void main(String[] args) {
		Shop<Pet> petShop = new Shop<Pet>(new Pet("旺财"));
		Shop<Food> foodShop = new Shop<Food>(new Food("面包"));
//		Shop<Food> foodShop = new Shop<Food>(new Food("旺旺"));//泛型
		Pet dog = petShop.buy();
		System.out.println(dog.name);
		Food food  = foodShop.buy();
		System.out.println(food.type);//面包
		Shop<Object> shop = new Shop<Object>(new Food("面包"));//特例情况
		Shop s = new Shop(new Food("饺子"));//不写泛型，默认调用object,不过会有警告
		
	}

}
class Shop <P>{			// p = product
	P p;
	public Shop(P p){
		this.p = p;
	}
	public P buy(){
		return p;
	}
}
class Pet{
	String name;
	public Pet(String name){
		this.name = name;
	}
}
class Food{
	String type;
	public Food(String type){
		this.type = type;
	}
}
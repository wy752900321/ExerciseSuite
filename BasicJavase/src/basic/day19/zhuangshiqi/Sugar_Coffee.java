package basic.day19.zhuangshiqi;

public class Sugar_Coffee extends Drink_Add {
	private Drink drink;
	public Sugar_Coffee(Drink drink){
		this.drink=drink;
	}
	@Override
	public String getName() {
		return drink.name+"sugar";
	}

	@Override
	public double cost() {
		return drink.cost()+5.0;
	}

}

package entity;

public class Sale {
	private String name;
	private int qty;
	public Sale(String name, int qty) {
		super();
		this.name = name;
		this.qty = qty;
	}
	public Sale() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
}

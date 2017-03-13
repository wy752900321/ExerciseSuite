package cn.itcast.domain;
/**
 * 要购买的图书明细目录
 *  购物车存放图书的详细条目
 */
public class BookItem {
	private Book book;
	private int quantity;//数量
	private double totalprice;//总价格
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	
}

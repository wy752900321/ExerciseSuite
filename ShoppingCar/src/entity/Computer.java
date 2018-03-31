package entity;

/*
 create table t_computer(
 id int primary key auto_increment,
 model varchar(50),
 pic varchar(50),
 prodInfo varchar(255),
 price double
 )
 * */
public class Computer {
	private long id;
	private String model;
	private String pic;
	private String prodInfo;
	private double price;

	public Computer() {

	}

	public Computer(String model, String pic, String prodInfo,
			double price) {
		this.model = model;
		this.pic = pic;
		this.prodInfo = prodInfo;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getProdInfo() {
		return prodInfo;
	}

	public void setProdInfo(String prodInfo) {
		this.prodInfo = prodInfo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return prodInfo;
	}
	
}

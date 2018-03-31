package org.tarena.dang.entity;
/**
  	CREATE TABLE d_product (
	  id int(12) NOT NULL auto_increment,
	  product_name varchar(100) NOT NULL,
	  description varchar(100) default NULL,
	  add_time bigint(20) default NULL,
	  fixed_price double NOT NULL,
	  dang_price double NOT NULL,
	  keywords varchar(200) default NULL,
	  has_deleted int(1) NOT NULL default '0',
	  product_pic varchar(200) default NULL,
	  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
@SuppressWarnings("serial")
public class Product implements java.io.Serializable{
	private int id;	//产品ID
	private String product_name;//产品名
	private String description;//描述
	private long add_time;//添加时间
	private double fixed_price;//定价
	private double dang_price;//当当价
	private String keywords;//关键定
	private boolean has_deleted;//是否初删除
	private String product_pic;//产品图片
	private int saleCount;//销量
	public int getSaleCount() {
		return saleCount;
	}
	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String productName) {
		product_name = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getAdd_time() {
		return add_time;
	}
	public void setAdd_time(long addTime) {
		add_time = addTime;
	}
	public double getFixed_price() {
		return fixed_price;
	}
	public void setFixed_price(double fixedPrice) {
		fixed_price = fixedPrice;
	}
	public double getDang_price() {
		return dang_price;
	}
	public void setDang_price(double dangPrice) {
		dang_price = dangPrice;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public boolean isHas_deleted() {
		return has_deleted;
	}
	public void setHas_deleted(boolean hasDeleted) {
		has_deleted = hasDeleted;
	}
	public String getProduct_pic() {
		return product_pic;
	}
	public void setProduct_pic(String productPic) {
		product_pic = productPic;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}

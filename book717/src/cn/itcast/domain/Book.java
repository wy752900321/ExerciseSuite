package cn.itcast.domain;

public class Book {
	private String id;
	private String name;
	private double price;
	private String author;
	private String image;
	private String description;
	private Category category;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
/*
 	create table book
(
	id varchar(40) primary key,
	name varchar(40) not null unique,	#书名
	price decimal (8,2) not null,	#价格
	author varchar(40) not null,	#作者
	image varchar(255) not null,		#图片的位置和图片的名称
	description varchar(255),		#描述
	category_id varchar(40),		#类别id
	constraint category_id_FK foreign key(category_id) references category(id)
);
*/

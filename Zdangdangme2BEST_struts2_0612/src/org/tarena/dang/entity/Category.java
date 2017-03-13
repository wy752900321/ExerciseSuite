package org.tarena.dang.entity;

import java.util.List;

/**
 	DROP TABLE IF EXISTS d_category;
	CREATE TABLE d_category (
	  id int(12) NOT NULL auto_increment,
	  turn int(10) NOT NULL,
	  en_name varchar(200) NOT NULL,
	  name varchar(200) NOT NULL,
	  description varchar(200),
	  parent_id int(10),
	  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Category {
	private int id;	//类别ID
	private int turn;//顺序
	private String en_name;//英文名字
	private String name;//中文名字
	private String description;//描述
	private int parent_id;//父类别
	
	//追加属性，用于存储相关的子类别
	private List<Category> subCats;
	//追加属性,用于存储该类别包含所少个商品
	private int pnum;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public String getEn_name() {
		return en_name;
	}

	public void setEn_name(String enName) {
		en_name = enName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parentId) {
		parent_id = parentId;
	}

	public List<Category> getSubCats() {
		return subCats;
	}

	public void setSubCats(List<Category> subCats) {
		this.subCats = subCats;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	
}

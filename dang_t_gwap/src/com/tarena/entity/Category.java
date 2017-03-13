package com.tarena.entity;

import java.io.Serializable;
import java.util.List;

/**
 * d_category
 * 
 * @author soft01
 * 
 */
public class Category implements Serializable {
	private static final long serialVersionUID = 9014821489750268404L;

	// property
	private int id;
	private int turn;
	private String enName;
	private String name;
	private String description;
	private int parentId;
	// 追加属性
	private List<Category> subCats;
	// 当前类别包含的产品数量
	private int pnum = 1;

	// override Object's toString,equals,hashCode
	@Override
	public String toString() {
		return "Category [description=" + description + ", enName=" + enName
				+ ", id=" + id + ", name=" + name + ", parentId=" + parentId
				+ ", turn=" + turn + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (obj instanceof Category) {
			Category category = (Category) obj;
			return category.id == this.id;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return id;
	}

	// getter and setter
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

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
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

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public void setSubCats(List<Category> subCats) {
		this.subCats = subCats;
	}

	public List<Category> getSubCats() {
		return subCats;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public int getPnum() {
		return pnum;
	}
}

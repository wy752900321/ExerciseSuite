package com.tarena.entity.exet;

import java.util.List;

import com.tarena.entity.AbstractCategory;

public class Category extends AbstractCategory {

	public Category() {

	}

	// 子类别
	private List<Category> cateChild;
	// 类别下的产品
	private Product product;
	// 一个类别下的产品的数量
	private Integer count;

	public List<Category> getCateChild() {
		return cateChild;
	}

	public void setCateChild(List<Category> cateChild) {
		this.cateChild = cateChild;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}

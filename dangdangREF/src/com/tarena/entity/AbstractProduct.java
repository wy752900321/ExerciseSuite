package com.tarena.entity;

import java.io.Serializable;

public abstract class AbstractProduct implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String productName;// 产品名字
	private String description;// 产品描述
	private Long addTime;// 添加产品的时间
	private Double fixedPrice;// 固定价格
	private Double dangPrice;// 当当价格
	private String keywords;// 关键搜索
	private Integer hasDeleted = 0;// 是否删除
	private String productPic;// 产品图片

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getAddTime() {
		return addTime;
	}

	public void setAddTime(Long addTime) {
		this.addTime = addTime;
	}

	public Double getFixedPrice() {
		return fixedPrice;
	}

	public void setFixedPrice(Double fixedPrice) {
		this.fixedPrice = fixedPrice;
	}

	public Double getDangPrice() {
		return dangPrice;
	}

	public void setDangPrice(Double dangPrice) {
		this.dangPrice = dangPrice;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Integer getHasDeleted() {
		return hasDeleted;
	}

	public void setHasDeleted(Integer hasDeleted) {
		this.hasDeleted = hasDeleted;
	}

	public String getProductPic() {
		return productPic;
	}

	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}

}

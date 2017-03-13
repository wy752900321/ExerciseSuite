package com.tarena.entity;

import java.io.Serializable;

public abstract class AbstractItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer orderId;// 订单id
	private Integer productId;// 产品id
	private String productName;// 产品名字
	private Double dangPrice; // 当当价格
	private Integer productNum; // 产品数量
	private Double amount;// 小计

	public AbstractItem() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getDangPrice() {
		return dangPrice;
	}

	public void setDangPrice(Double dangPrice) {
		this.dangPrice = dangPrice;
	}

	public Integer getProductNum() {
		return productNum;
	}

	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}

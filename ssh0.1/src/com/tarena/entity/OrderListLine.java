package com.tarena.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 一个页面上需要好几个表上的某些字段，我们可以把它们抽取出一个类
 * @author soft01
 *
 */
public class OrderListLine {	
	private Integer id;
	private String nickname;
	private Date orderTime;
	private BigDecimal totalPrice;//精度高
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
}

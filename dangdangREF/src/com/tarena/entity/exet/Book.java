package com.tarena.entity.exet;

import com.tarena.entity.AbstractBook;

public class Book extends AbstractBook {

	public Book() {

	}

	private double savePrice = 0;
	private boolean bool = false;

	public double getSavePrice() {
		return this.getFixedPrice() - this.getDangPrice();
	}

	public void setSavePrice(double savePrice) {
		this.savePrice = savePrice;
	}

	public boolean isBool() {
		return bool;
	}

	public void setBool(boolean bool) {
		this.bool = bool;
	}

}

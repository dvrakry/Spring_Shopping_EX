package com.shop.domain;

import java.util.Date;

public class CartVO {
	
	private int cartNum;
	private String userId;
	private int gdsNum;
	private int cartStock;
	private Date addDate;
	
	public int getCartNum() {
		return cartNum;
	}
	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	int getGdsNum() {
		return gdsNum;
	}
	void setGdsNum(int gdsNum) {
		this.gdsNum = gdsNum;
	}
	int getCartStock() {
		return cartStock;
	}
	void setCartStock(int cartStock) {
		this.cartStock = cartStock;
	}
	Date getAddDate() {
		return addDate;
	}
	void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	
	

}

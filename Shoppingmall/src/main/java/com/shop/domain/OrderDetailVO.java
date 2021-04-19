package com.shop.domain;


public class OrderDetailVO {
	
	private int orderDetailsNum;
	private String orderId;
	private int gdsNum;
	private int cartStock;
	int getOrderDetailsNum() {
		return orderDetailsNum;
	}
	void setOrderDetailsNum(int orderDetailsNum) {
		this.orderDetailsNum = orderDetailsNum;
	}
	String getOrderId() {
		return orderId;
	}
	void setOrderId(String orderId) {
		this.orderId = orderId;
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
	
	

}

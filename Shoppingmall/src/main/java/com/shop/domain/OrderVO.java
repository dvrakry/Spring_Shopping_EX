package com.shop.domain;

import java.util.Date;

public class OrderVO {
	
	private String orderId;
	private String userId;
	private String orderRec;
	private String userAddr1;
	private String userAddr2;
	private String userAddr3;
	private String orderPhon;
	private int amount;
	private Date orderDate;
	String getOrderId() {
		return orderId;
	}
	void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	String getUserId() {
		return userId;
	}
	void setUserId(String userId) {
		this.userId = userId;
	}
	String getOrderRec() {
		return orderRec;
	}
	void setOrderRec(String orderRec) {
		this.orderRec = orderRec;
	}
	String getUserAddr1() {
		return userAddr1;
	}
	void setUserAddr1(String userAddr1) {
		this.userAddr1 = userAddr1;
	}
	String getUserAddr2() {
		return userAddr2;
	}
	void setUserAddr2(String userAddr2) {
		this.userAddr2 = userAddr2;
	}
	String getUserAddr3() {
		return userAddr3;
	}
	void setUserAddr3(String userAddr3) {
		this.userAddr3 = userAddr3;
	}
	String getOrderPhon() {
		return orderPhon;
	}
	void setOrderPhon(String orderPhon) {
		this.orderPhon = orderPhon;
	}
	int getAmount() {
		return amount;
	}
	void setAmount(int amount) {
		this.amount = amount;
	}
	Date getOrderDate() {
		return orderDate;
	}
	void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	

}

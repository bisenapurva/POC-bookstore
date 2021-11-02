package com.bookstore.order.bean;

public class CartBean {
private long productId;
private long userId;
private int qty;
private double price;
private String productName;

public Long getProductId() {
	return productId;
}
public void setProductId(Long productId) {
	this.productId = productId;
}
public Long getUserId() {
	return userId;
}
public void setUserId(Long userId) {
	this.userId = userId;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}

public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public void setProductId(long productId) {
	this.productId = productId;
}
public void setUserId(long userId) {
	this.userId = userId;
}

public CartBean(long productId, long userId, int qty, double price, String productName) {
	super();
	this.productId = productId;
	this.userId = userId;
	this.qty = qty;
	this.price = price;
	this.productName = productName;
}
public CartBean() {
	super();
}


}

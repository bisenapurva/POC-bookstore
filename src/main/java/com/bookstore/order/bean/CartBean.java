package com.bookstore.order.bean;

public class CartBean {
private long productId;
private long userId;
private int qty;
private double price;

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
public CartBean(Long productId, Long userId, int qty, double price) {
	super();
	this.productId = productId;
	this.userId = userId;
	this.qty = qty;
	this.price = price;
}
public CartBean() {
	super();
}


}

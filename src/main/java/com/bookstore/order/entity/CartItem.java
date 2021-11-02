package com.bookstore.order.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Double price;
	private int qty;
	private Long productId;
	private Long userId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
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
	public CartItem(int id, Double price, int qty, Long productId, Long userId) {
		super();
		this.id = id;
		this.price = price;
		this.qty = qty;
		this.productId = productId;
		this.userId = userId;
	}
	public CartItem() {
		super();
	}
	
}

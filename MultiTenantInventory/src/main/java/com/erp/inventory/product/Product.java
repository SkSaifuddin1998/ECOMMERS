package com.erp.inventory.product;

public class Product {

	private String productId;
	private String productName;

	public Product(String productId, String productName) {
		this.productId = productId;
		this.productName = productName;
	}

	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}
}
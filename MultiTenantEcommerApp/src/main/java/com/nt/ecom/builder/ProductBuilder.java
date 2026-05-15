package com.nt.ecom.builder;

import com.nt.ecom.product.Product;

public class ProductBuilder {

	private final Product product;

	public ProductBuilder() {
		product = new Product();
	}

	public ProductBuilder name(String name) {
		product.setProductName(name);
		return this;
	}

	public ProductBuilder price(Double price) {
		product.setPrice(price);
		return this;
	}

	public ProductBuilder quantity(Integer quantity) {
		product.setQuantity(quantity);
		return this;
	}

	public Product build() {
		return product;
	}
}
package com.erp.inventory.strategy;

import com.erp.inventory.product.Product;
import com.erp.inventory.strategy.PricingStrategy;

public class BranchProductPricing {

	private Product product;

	private double sellingPrice;

	private PricingStrategy pricingStrategy;

	public BranchProductPricing(Product product, double sellingPrice, PricingStrategy pricingStrategy) {

		this.product = product;

		this.sellingPrice = sellingPrice;

		this.pricingStrategy = pricingStrategy;
	}

	// DYNAMIC PRICE
	public double getFinalPrice() {

		return pricingStrategy.calculatePrice(sellingPrice);
	}

	// UPDATE DISCOUNT RUNTIME
	public void updateStrategy(PricingStrategy pricingStrategy) {

		this.pricingStrategy = pricingStrategy;
	}

	public Product getProduct() {
		return product;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}
}
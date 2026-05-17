package com.erp.inventory.entry;

import com.erp.inventory.product.Product;
import com.erp.inventory.strategy.BranchProductPricing;
import com.erp.inventory.strategy.FlatDiscountStrategy;
import com.erp.inventory.strategy.NoDiscountStrategy;
import com.erp.inventory.strategy.PercentageDiscountStrategy;

public class PricingApplication {

	public static void main(String[] args) {

		// PRODUCT
		Product laptop = new Product("P101", "Laptop", null);

		// =====================================
		// INITIAL PRICE
		// =====================================

		BranchProductPricing pricing = new BranchProductPricing(laptop, 50000, new NoDiscountStrategy());

		System.out.println("\nWITHOUT DISCOUNT : " + pricing.getFinalPrice());

		// =====================================
		// PERCENTAGE DISCOUNT
		// =====================================

		pricing.updateStrategy(new PercentageDiscountStrategy(10));

		System.out.println("\n10% DISCOUNT : " + pricing.getFinalPrice());

		// =====================================
		// FLAT DISCOUNT
		// =====================================

		pricing.updateStrategy(new FlatDiscountStrategy(5000));

		System.out.println("\nFLAT DISCOUNT : " + pricing.getFinalPrice());
	}
}
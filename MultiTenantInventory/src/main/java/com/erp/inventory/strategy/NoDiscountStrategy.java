package com.erp.inventory.strategy;

public class NoDiscountStrategy implements PricingStrategy {

	@Override
	public double calculatePrice(double sellingPrice) {

		return sellingPrice;
	}
}
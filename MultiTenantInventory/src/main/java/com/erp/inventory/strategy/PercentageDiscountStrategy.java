package com.erp.inventory.strategy;

public class PercentageDiscountStrategy implements PricingStrategy {

	private double discountPercentage;

	public PercentageDiscountStrategy(double discountPercentage) {

		this.discountPercentage = discountPercentage;
	}

	@Override
	public double calculatePrice(double sellingPrice) {

		return sellingPrice - (sellingPrice * discountPercentage / 100);
	}
}
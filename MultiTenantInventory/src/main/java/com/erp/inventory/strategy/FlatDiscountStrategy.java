package com.erp.inventory.strategy;

public class FlatDiscountStrategy implements PricingStrategy {

	private double flatDiscount;

	public FlatDiscountStrategy(double flatDiscount) {

		this.flatDiscount = flatDiscount;
	}

	@Override
	public double calculatePrice(double sellingPrice) {

		return sellingPrice - flatDiscount;
	}
}
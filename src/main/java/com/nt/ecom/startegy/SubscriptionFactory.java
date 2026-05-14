package com.nt.ecom.startegy;

public class SubscriptionFactory {

	public static SubscriptionPlan getPlan(String planType) {

		return switch (planType.toUpperCase()) {

		case "FREE" -> new FreePlan();

		case "BASIC" -> new BasicPlan();

		case "PREMIUM" -> new PremiumPlan();

		default -> throw new RuntimeException("Invalid Plan");
		};
	}
}
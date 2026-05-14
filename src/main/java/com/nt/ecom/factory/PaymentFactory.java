package com.nt.ecom.factory;

public class PaymentFactory {

	public static PaymentGateway getGateway(String type) {

		return switch (type) {

		case "UPI" -> new UpiPayment();

		case "STRIPE" -> new StripePayment();

		default -> throw new RuntimeException("Invalid Gateway");
		};
	}
}
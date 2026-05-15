package com.nt.ecom.factory;

public class StripePayment implements PaymentGateway {

	@Override
	public void pay(Double amount) {

		System.out.println("Stripe Payment : " + amount);
	}
}
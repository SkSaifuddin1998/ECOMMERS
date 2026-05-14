package com.nt.ecom.factory;

public class UpiPayment implements PaymentGateway {

	@Override
	public void pay(Double amount) {

		System.out.println("UPI Payment : " + amount);
	}
}
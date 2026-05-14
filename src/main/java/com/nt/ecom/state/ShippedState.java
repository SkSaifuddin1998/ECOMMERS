package com.nt.ecom.state;

public class ShippedState implements OrderState {

	@Override
	public void next(OrderContext context) {

		System.out.println("Order Delivered");
	}
}
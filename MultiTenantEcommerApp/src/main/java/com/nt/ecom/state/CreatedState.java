package com.nt.ecom.state;

public class CreatedState
        implements OrderState {

    @Override
    public void next(OrderContext context) {

        System.out.println("Order Paid");

        context.setState(new ShippedState());
    }
}
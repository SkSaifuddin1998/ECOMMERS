package com.nt.ecom.state;
public class OrderContext {

    private OrderState state;

    public OrderContext() {
        this.state = new CreatedState();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void next() {
        state.next(this);
    }
}
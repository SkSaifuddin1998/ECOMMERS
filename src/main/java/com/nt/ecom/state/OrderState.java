package com.nt.ecom.state;

public interface OrderState {

    void next(OrderContext context);
}
package com.nt.ecom.chain;

import com.nt.ecom.product.Product;

public abstract class ApprovalHandler {

    protected ApprovalHandler next;

    public void setNext(ApprovalHandler next) {
        this.next = next;
    }

    public abstract void approve(Product product);
}
package com.nt.ecom.chain;

import com.nt.ecom.product.Product;

public class FinanceApproval
        extends ApprovalHandler {

    @Override
    public void approve(Product product) {

        System.out.println(
                "Finance Approved");

        if(next != null) {
            next.approve(product);
        }
    }
}
package com.nt.ecom.chain;

import com.nt.ecom.product.Product;

public class CatalogApproval
        extends ApprovalHandler {

    @Override
    public void approve(Product product) {

        System.out.println(
                "Catalog Approved");

        if(next != null) {
            next.approve(product);
        }
    }
}
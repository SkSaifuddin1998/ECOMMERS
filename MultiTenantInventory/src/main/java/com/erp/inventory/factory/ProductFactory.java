package com.erp.inventory.factory;

import com.erp.inventory.composite.CategoryComponent;
import com.erp.inventory.product.Product;

public class ProductFactory {

    public static Product createProduct(
            String productId,
            String productName,
            CategoryComponent category
    ) {

        return new Product(
                productId,
                productName,
                category
        );
    }
}
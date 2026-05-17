package com.erp.inventory.product;

import com.erp.inventory.composite.CategoryComponent;

public class Product {

    private String productId;
    private String productName;

    // CATEGORY MAPPING
    private CategoryComponent category;

    public Product(String productId,
                   String productName,
                   CategoryComponent category) {

        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public CategoryComponent getCategory() {
        return category;
    }

    @Override
    public String toString() {

        return "Product Id : "
                + productId
                + " Product Name : "
                + productName
                + " Category : "
                + category.categoryName;
    }
}

package com.erp.inventory.observer;

import com.erp.inventory.product.Product;

// =======================================================
// INVENTORY ITEM
// =======================================================

public class InventoryItem {

    private Product product;
    private int quantity;

    public InventoryItem(Product product,
                         int quantity) {

        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int qty) {

        this.quantity += qty;
    }

    public void removeQuantity(int qty) {

        this.quantity -= qty;
    }
}

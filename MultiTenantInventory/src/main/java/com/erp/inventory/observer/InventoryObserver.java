package com.erp.inventory.observer;

import com.erp.inventory.product.Product;

public interface InventoryObserver {

	void update(String branchName, Product product, int quantity);
}
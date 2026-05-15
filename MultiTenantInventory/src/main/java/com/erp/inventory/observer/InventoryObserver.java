package com.erp.inventory.observer;

import com.erp.inventory.product.Product;

interface InventoryObserver {

	void update(String branchName, Product product, int quantity);
}
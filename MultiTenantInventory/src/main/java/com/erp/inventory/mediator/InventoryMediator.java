package com.erp.inventory.mediator;

import com.erp.inventory.observer.BranchInventory;
import com.erp.inventory.product.Product;

public interface InventoryMediator {

	void transferStock(BranchInventory fromBranch, BranchInventory toBranch, Product product, int quantity);
}
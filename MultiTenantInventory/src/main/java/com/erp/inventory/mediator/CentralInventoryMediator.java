package com.erp.inventory.mediator;

import com.erp.inventory.observer.BranchInventory;
import com.erp.inventory.product.Product;

// =======================================================
// CENTRAL INVENTORY MEDIATOR
// =======================================================

public class CentralInventoryMediator implements InventoryMediator {

	@Override
	public void transferStock(BranchInventory fromBranch, BranchInventory toBranch, Product product, int quantity) {

		System.out.println("\n===== STOCK TRANSFER =====");

		fromBranch.removeStock(product, quantity);

		toBranch.addStock(product, quantity);

		System.out.println("\nTRANSFER COMPLETED");
	}
}
package com.erp.inventory.mediator;

import com.erp.inventory.observer.BranchInventory;
import com.erp.inventory.product.Product;

public class CentralInventoryMediator implements InventoryMediator {

	@Override
	public void transferStock(BranchInventory fromBranch, BranchInventory toBranch, Product product, int quantity) {

		System.out.println("\nTRANSFER STARTED");

		fromBranch.removeStock(product, quantity);

		toBranch.addStock(product, quantity);

		System.out.println("TRANSFER COMPLETED :: " + fromBranch.getBranchName() + " -> " + toBranch.getBranchName());
	}
}
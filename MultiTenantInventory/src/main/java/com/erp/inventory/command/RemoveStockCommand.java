package com.erp.inventory.command;

import com.erp.inventory.observer.BranchInventory;
import com.erp.inventory.product.Product;

// =======================================================
// REMOVE STOCK COMMAND
// =======================================================

public class RemoveStockCommand implements InventoryCommand {

	private BranchInventory branchInventory;
	private Product product;
	private int quantity;

	public RemoveStockCommand(BranchInventory branchInventory, Product product, int quantity) {

		this.branchInventory = branchInventory;
		this.product = product;
		this.quantity = quantity;
	}

	@Override
	public void execute() {

		branchInventory.removeStock(product, quantity);
	}
}
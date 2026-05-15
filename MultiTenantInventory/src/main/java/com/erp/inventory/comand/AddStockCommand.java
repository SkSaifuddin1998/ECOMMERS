package com.erp.inventory.comand;

import com.erp.inventory.observer.BranchInventory;
import com.erp.inventory.product.Product;

public class AddStockCommand implements InventoryCommand {

	private BranchInventory branchInventory;
	private Product product;
	private int quantity;

	public AddStockCommand(BranchInventory branchInventory, Product product, int quantity) {

		this.branchInventory = branchInventory;
		this.product = product;
		this.quantity = quantity;
	}

	@Override
	public void execute() {

		branchInventory.addStock(product, quantity);
	}
}
package com.erp.inventory.observer;

import java.util.HashMap;
import java.util.Map;

import com.erp.inventory.product.Product;

// =======================================================
// BRANCH INVENTORY
// =======================================================

public class BranchInventory {

	private Branch branch;

	// PRODUCT ID -> INVENTORY ITEM
	private Map<String, InventoryItem> inventory = new HashMap<>();

	private InventoryObserver observer;

	public BranchInventory(Branch branch, InventoryObserver observer) {

		this.branch = branch;
		this.observer = observer;
	}

	// ADD STOCK
	public void addStock(Product product, int quantity) {

		InventoryItem item = inventory.get(product.getProductId());

		if (item == null) {

			item = new InventoryItem(product, quantity);

			inventory.put(product.getProductId(), item);

		} else {

			item.addQuantity(quantity);
		}

		observer.update(branch.getBranchName(), product, quantity);

		System.out.println("\nSTOCK ADDED :: " + product.getProductName() + " Qty : " + quantity);
	}

	// REMOVE STOCK
	public void removeStock(Product product, int quantity) {

		InventoryItem item = inventory.get(product.getProductId());

		if (item != null && item.getQuantity() >= quantity) {

			item.removeQuantity(quantity);

			observer.update(branch.getBranchName(), product, -quantity);

			System.out.println("\nSTOCK REMOVED :: " + product.getProductName() + " Qty : " + quantity);

		} else {

			System.out.println("\nINSUFFICIENT STOCK");
		}
	}

	// SHOW INVENTORY
	public void showInventory() {

		System.out.println("\n===== " + branch.getBranchName() + " INVENTORY =====");

		for (InventoryItem item : inventory.values()) {

			System.out.println("Product : " + item.getProduct().getProductName());

			System.out.println("Category : " + item.getProduct().getCategory().categoryName);

			System.out.println("Quantity : " + item.getQuantity());

			System.out.println("--------------------------");
		}
	}
}
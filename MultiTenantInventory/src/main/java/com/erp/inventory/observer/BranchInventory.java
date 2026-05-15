package com.erp.inventory.observer;

import java.util.HashMap;
import java.util.Map;

import com.erp.inventory.product.Product;

public class BranchInventory {

	private String branchName;

	private Map<String, Integer> localInventory = new HashMap<>();

	private InventoryObserver observer;

	public BranchInventory(String branchName, InventoryObserver observer) {

		this.branchName = branchName;
		this.observer = observer;
	}

	public void addStock(Product product, int quantity) {

		localInventory.put(product.getProductName(),

				localInventory.getOrDefault(product.getProductName(), 0) + quantity);

		System.out.println(branchName + " Added Stock : " + product.getProductName() + " Qty : " + quantity);

		observer.update(branchName, product, quantity);
	}

	public void removeStock(Product product, int quantity) {

		int currentQty = localInventory.getOrDefault(product.getProductName(), 0);

		if (currentQty >= quantity) {

			localInventory.put(product.getProductName(), currentQty - quantity);

			System.out.println(branchName + " Removed Stock : " + product.getProductName() + " Qty : " + quantity);

			observer.update(branchName, product, -quantity);
		} else {

			System.out.println("Insufficient Stock in " + branchName);
		}
	}

	public void showLocalInventory() {

		System.out.println("\nLOCAL INVENTORY : " + branchName);

		for (Map.Entry<String, Integer> entry : localInventory.entrySet()) {

			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

	public String getBranchName() {
		return branchName;
	}
}
package com.erp.inventory.observer;
// =======================================================

// SINGLETON DESIGN PATTERN
// CENTRAL INVENTORY SYSTEM
// =======================================================

import java.util.HashMap;
import java.util.Map;

import com.erp.inventory.product.Product;

public class CentralInventorySystem implements InventoryObserver {

	private static CentralInventorySystem instance;

	// PRODUCT -> TOTAL QUANTITY
	private Map<String, Integer> globalInventory = new HashMap<>();

	private CentralInventorySystem() {
	}

	public static synchronized CentralInventorySystem getInstance() {

		if (instance == null) {
			instance = new CentralInventorySystem();
		}

		return instance;
	}

	@Override
	public void update(String branchName, Product product, int quantity) {

		globalInventory.put(product.getProductId(),

				globalInventory.getOrDefault(product.getProductId(), 0) + quantity);

		System.out.println("\nCENTRAL INVENTORY UPDATED");

		System.out.println("Branch : " + branchName);

		System.out.println("Product : " + product.getProductName());

		System.out.println("Quantity : " + quantity);
	}

	public void showGlobalInventory() {

		System.out.println("\n===== GLOBAL INVENTORY =====");

		for (Map.Entry<String, Integer> entry : globalInventory.entrySet()) {

			System.out.println("Product Id : " + entry.getKey() + " Quantity : " + entry.getValue());
		}
	}
}
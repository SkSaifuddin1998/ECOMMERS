package com.erp.inventory.observer;

import java.util.HashMap;
import java.util.Map;

import com.erp.inventory.product.Product;

public class CentralInventorySystem implements InventoryObserver {

	private static CentralInventorySystem instance;

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

		globalInventory.put(product.getProductName(),

				globalInventory.getOrDefault(product.getProductName(), 0) + quantity);

		System.out.println("CENTRAL INVENTORY UPDATED :: " + branchName + " -> " + product.getProductName() + " Qty : "
				+ quantity);
	}

	public void showGlobalInventory() {

		System.out.println("\nGLOBAL INVENTORY");

		for (Map.Entry<String, Integer> entry : globalInventory.entrySet()) {

			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

	
}
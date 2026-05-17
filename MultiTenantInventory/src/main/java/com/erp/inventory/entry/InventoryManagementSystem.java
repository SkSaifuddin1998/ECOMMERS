package com.erp.inventory.entry;

import com.erp.inventory.command.AddStockCommand;
import com.erp.inventory.command.InventoryCommand;
import com.erp.inventory.composite.LeafCategory;
import com.erp.inventory.composite.ParentCategory;
import com.erp.inventory.factory.ProductFactory;
import com.erp.inventory.mediator.CentralInventoryMediator;
import com.erp.inventory.mediator.InventoryMediator;
import com.erp.inventory.observer.Branch;
import com.erp.inventory.observer.BranchInventory;
import com.erp.inventory.observer.CentralInventorySystem;
import com.erp.inventory.product.Product;

// =======================================================
// MAIN APPLICATION
// =======================================================

public class InventoryManagementSystem {

	public static void main(String[] args) {

		// ===================================================
		// CATEGORY HIERARCHY
		// ===================================================

		ParentCategory electronics = new ParentCategory("C1", "Electronics");

		ParentCategory mobiles = new ParentCategory("C2", "Mobiles");

		LeafCategory android = new LeafCategory("C3", "Android");

		LeafCategory iphone = new LeafCategory("C4", "iPhone");

		ParentCategory laptops = new ParentCategory("C5", "Laptops");

		LeafCategory gamingLaptop = new LeafCategory("C6", "Gaming Laptop");

		LeafCategory businessLaptop = new LeafCategory("C7", "Business Laptop");

		// ===================================================
		// PARENT CHILD CATEGORY MAPPING
		// ===================================================

		mobiles.add(android);
		mobiles.add(iphone);

		laptops.add(gamingLaptop);
		laptops.add(businessLaptop);

		electronics.add(mobiles);
		electronics.add(laptops);

		// ===================================================
		// SHOW CATEGORY TREE
		// ===================================================

		electronics.showCategoryHierarchy();

		// ===================================================
		// PRODUCTS
		// ===================================================

		Product samsung = ProductFactory.createProduct("P101", "Samsung S25", android);

		Product dell = ProductFactory.createProduct("P102", "Dell Alienware", gamingLaptop);

		// ===================================================
		// CENTRAL INVENTORY
		// ===================================================

		CentralInventorySystem centralInventory = CentralInventorySystem.getInstance();

		// ===================================================
		// BRANCH
		// ===================================================

		Branch kolkata = new Branch("B1", "Kolkata Branch");

		Branch delhi = new Branch("B2", "Delhi Branch");

		// ===================================================
		// BRANCH INVENTORY
		// ===================================================

		BranchInventory kolkataInventory = new BranchInventory(kolkata, centralInventory);

		BranchInventory delhiInventory = new BranchInventory(delhi, centralInventory);

		// ===================================================
		// COMMAND PATTERN
		// ===================================================

		InventoryCommand addSamsung = new AddStockCommand(kolkataInventory, samsung, 50);

		InventoryCommand addDell = new AddStockCommand(delhiInventory, dell, 20);

		addSamsung.execute();
		addDell.execute();

		// ===================================================
		// SHOW INVENTORY
		// ===================================================

		kolkataInventory.showInventory();

		delhiInventory.showInventory();

		// ===================================================
		// MEDIATOR PATTERN
		// STOCK TRANSFER
		// ===================================================

		InventoryMediator mediator = new CentralInventoryMediator();

		mediator.transferStock(kolkataInventory, delhiInventory, samsung, 10);

		// ===================================================
		// FINAL INVENTORY
		// ===================================================

		kolkataInventory.showInventory();

		delhiInventory.showInventory();

		centralInventory.showGlobalInventory();
	}
}
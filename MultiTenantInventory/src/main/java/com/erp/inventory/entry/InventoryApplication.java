package com.erp.inventory.entry;

import com.erp.inventory.comand.AddStockCommand;
import com.erp.inventory.comand.InventoryCommand;
import com.erp.inventory.mediator.CentralInventoryMediator;
import com.erp.inventory.mediator.InventoryMediator;
import com.erp.inventory.observer.BranchInventory;
import com.erp.inventory.observer.CentralInventorySystem;
import com.erp.inventory.product.Product;

public class InventoryApplication {

	public static void main(String[] args) {

		// CENTRAL INVENTORY
		CentralInventorySystem centralInventory = CentralInventorySystem.getInstance();

		// PRODUCTS
		Product laptop = new Product("P101", "Laptop");

		Product mobile = new Product("P102", "Mobile");

		// BRANCH INVENTORY
		BranchInventory kolkataBranch = new BranchInventory("Kolkata Branch", centralInventory);

		BranchInventory delhiBranch = new BranchInventory("Delhi Branch", centralInventory);

		// COMMAND PATTERN
		InventoryCommand addLaptopStock = new AddStockCommand(kolkataBranch, laptop, 50);

		InventoryCommand addMobileStock = new AddStockCommand(delhiBranch, mobile, 30);

		addLaptopStock.execute();

		addMobileStock.execute();

		// SHOW LOCAL INVENTORY
		kolkataBranch.showLocalInventory();

		delhiBranch.showLocalInventory();

		// MEDIATOR PATTERN
		InventoryMediator mediator = new CentralInventoryMediator();

		mediator.transferStock(kolkataBranch, delhiBranch, laptop, 10);

		// SHOW AFTER TRANSFER
		kolkataBranch.showLocalInventory();

		delhiBranch.showLocalInventory();

		// GLOBAL INVENTORY
		centralInventory.showGlobalInventory();
	}
}
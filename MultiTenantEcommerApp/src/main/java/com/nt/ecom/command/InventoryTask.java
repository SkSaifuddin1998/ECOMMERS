package com.nt.ecom.command;

public class InventoryTask implements DepartmentTask {

	@Override
	public void execute() {

		System.out.println("Inventory Department : " + "Stock Management");
	}
}
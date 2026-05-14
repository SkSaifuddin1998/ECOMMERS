package com.nt.ecom.command;

public class WarehouseTask implements DepartmentTask {

	@Override
	public void execute() {

		System.out.println("Warehouse Department Operations:");

		System.out.println("- Stock Management");

		System.out.println("- Product Storage");

		System.out.println("- Warehouse Tracking");
	}
}
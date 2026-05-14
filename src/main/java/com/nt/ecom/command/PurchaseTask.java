package com.nt.ecom.command;

public class PurchaseTask implements DepartmentTask {

	@Override
	public void execute() {

		System.out.println("Purchase Department Operations:");

		System.out.println("- Vendor Purchase");

		System.out.println("- Raw Material Procurement");

		System.out.println("- Purchase Approval");
	}
}
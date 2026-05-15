package com.nt.ecom.command;

public class SalesTask implements DepartmentTask {

	@Override
	public void execute() {

		System.out.println("Sales Department Operations:");

		System.out.println("- Product Sales");

		System.out.println("- Customer Order Processing");

		System.out.println("- Sales Reporting");
	}
}
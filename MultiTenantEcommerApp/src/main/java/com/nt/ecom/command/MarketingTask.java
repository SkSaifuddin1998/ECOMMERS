package com.nt.ecom.command;

public class MarketingTask implements DepartmentTask {

	@Override
	public void execute() {

		System.out.println("Marketing Department Operations:");

		System.out.println("- Campaign Management");

		System.out.println("- Advertisement");

		System.out.println("- Customer Promotion");
	}
}
package com.nt.ecom.command;

public class FinanceTask implements DepartmentTask {

	@Override
	public void execute() {

		System.out.println("Finance Department Operations:");

		System.out.println("- GST Calculation");

		System.out.println("- Invoice Generation");

		System.out.println("- Salary Processing");
	}
}
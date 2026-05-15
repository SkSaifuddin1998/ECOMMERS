package com.nt.ecom.command;

public class SupportTask implements DepartmentTask {

	@Override
	public void execute() {

		System.out.println("Support Department Operations:");

		System.out.println("- Ticket Handling");

		System.out.println("- Customer Complaint Resolution");

		System.out.println("- Chat Support");
	}
}
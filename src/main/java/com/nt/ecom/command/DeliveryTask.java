package com.nt.ecom.command;

public class DeliveryTask implements DepartmentTask {

	@Override
	public void execute() {

		System.out.println("Delivery Department Operations:");

		System.out.println("- Shipment Processing");

		System.out.println("- Delivery Tracking");

		System.out.println("- Route Management");
	}
}
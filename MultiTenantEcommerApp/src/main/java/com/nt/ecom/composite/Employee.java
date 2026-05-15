package com.nt.ecom.composite;

public class Employee implements OrganizationComponent {

	private final int employeeId;

	private final String employeeName;

	private final String role;

	public Employee(int employeeId, String employeeName, String role) {

		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.role = role;
	}

	public int getEmployeeId() {

		return employeeId;
	}

	@Override
	public void showDetails() {

		System.out.println("Employee Id : " + employeeId + " | Name : " + employeeName + " | Role : " + role);
	}

	@Override
	public void add(OrganizationComponent component) {

		throw new UnsupportedOperationException("Employee cannot add child");
	}

	@Override
	public void remove(OrganizationComponent component) {

		throw new UnsupportedOperationException("Employee cannot remove child");
	}
}
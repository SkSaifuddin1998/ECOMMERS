package com.nt.ecom.composite;

import java.util.ArrayList;
import java.util.List;

public class Branch implements OrganizationComponent {

	private final String branchName;

	private final String location;

	private final List<OrganizationComponent> departments = new ArrayList<>();

	public Branch(String branchName, String location) {

		this.branchName = branchName;
		this.location = location;
	}
	//Getter Methods 
	public String getBranchName() {
		return branchName;
	}

	public String getLocation() {
		return location;
	}

	public List<OrganizationComponent> getDepartments() {
		return departments;
	}
	  // FIND DEPARTMENT
		public Department findDepartment(String departmentName) {

			for (OrganizationComponent component : departments) {

				if (component instanceof Department d) {

					if (d.getDepartmentName().equalsIgnoreCase(departmentName)) {

						return d;
					}
				}
			}

			return null;
		}


	@Override
	public void showDetails() {

		System.out.println("\n--------------------------------");

		System.out.println("Branch : " + branchName);

		System.out.println("Location : " + location);

		System.out.println("--------------------------------");

		for (OrganizationComponent department : departments) {

			department.showDetails();
		}
	}

	// EXECUTE ALL DEPARTMENT TASKS
	public void executeBranchTasks() {

		System.out.println("\nExecuting Branch Tasks : " + branchName);

		for (OrganizationComponent component : departments) {

			if (component instanceof Department d) {

				d.performTask();
			}
		}
	}


	@Override
	public void add(OrganizationComponent component) {

		departments.add(component);
	}

	@Override
	public void remove(OrganizationComponent component) {

		departments.remove(component);
	}
}
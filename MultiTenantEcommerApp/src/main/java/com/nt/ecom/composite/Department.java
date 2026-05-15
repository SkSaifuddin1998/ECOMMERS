package com.nt.ecom.composite;

import java.util.ArrayList;
import java.util.List;

import com.nt.ecom.command.DepartmentTask;

public class Department implements OrganizationComponent {

	private final String departmentName;

	// COMPOSITE Design pattern
	private final List<OrganizationComponent> employees = new ArrayList<>();

	// COMMAND Design pattern
	private DepartmentTask task;

	public Department(String departmentName) {

		this.departmentName = departmentName;
	}
	
	public String getDepartmentName() {

	    return departmentName;
	}

	// ASSIGN TASK
	public void setTask(DepartmentTask task) {

		this.task = task;
	}

	// EXECUTE TASK
	public void performTask() {

		System.out.println("\nExecuting Department Task : " + departmentName);

		task.execute();
	}

	@Override
	public void showDetails() {

		System.out.println("\nDepartment : " + departmentName);

		for (OrganizationComponent employee : employees) {

			employee.showDetails();
		}
	}

	@Override
	public void add(OrganizationComponent component) {

		employees.add(component);
	}

	@Override
	public void remove(OrganizationComponent component) {

		employees.remove(component);
	}
	
	public Employee findEmployee(int employeeId) {

		for (OrganizationComponent component : employees) {

			if (component instanceof Employee e) {

				if (e.getEmployeeId() == employeeId) {

					return e;
				}
			}
		}

		return null;
	}
}
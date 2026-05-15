package com.nt.ecom.command;

public class HRTask implements DepartmentTask {

	@Override
	public void execute() {

		System.out.println("HR Department Operations:");

		System.out.println("- Employee Hiring");

		System.out.println("- Attendance Management");

		System.out.println("- Payroll Processing");
	}
}
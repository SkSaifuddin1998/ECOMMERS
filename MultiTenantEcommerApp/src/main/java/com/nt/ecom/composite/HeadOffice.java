package com.nt.ecom.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.nt.ecom.client.Client;
import com.nt.ecom.startegy.SubscriptionPlan;

public class HeadOffice implements OrganizationComponent {

	private final Client client;

	private final List<OrganizationComponent> branches = new ArrayList<>();

	private SubscriptionPlan plan;

	private int employeeCount;

	// CONSTRUCTOR
	public HeadOffice(Client client) {

		this.client = Objects.requireNonNull(client, "Client cannot be null");
	}

	// GET CLIENT
	public Client getClient() {

		return client;
	}

	// COMPANY NAME
	public String getCompanyName() {

		return client.getCompanyName();
	}

	// GET PLAN
	public SubscriptionPlan getPlan() {

		return plan;
	}

	// PURCHASE PLAN
	public void purchasePlan(SubscriptionPlan plan) {

		this.plan = Objects.requireNonNull(plan, "Plan cannot be null");

		System.out.println("\nPlan Purchased : " + plan.getPlanName());
	}

	// ADD BRANCH
	@Override
	public void add(OrganizationComponent component) {

		validateSubscription();

		validateBranchLimit();

		Objects.requireNonNull(component, "Branch cannot be null");

		branches.add(component);

		if (component instanceof Branch branch) {

			System.out.println("Branch Added : " + branch.getBranchName());
		}
	}

	// REMOVE BRANCH
	@Override
	public void remove(OrganizationComponent component) {

		branches.remove(component);
	}

	// FIND BRANCH
	public Optional<Branch> findBranch(String branchName) {

		return branches.stream()

				.filter(Branch.class::isInstance)

				.map(Branch.class::cast)

				.filter(branch -> branch.getBranchName().equalsIgnoreCase(branchName))

				.findFirst();
	}

	// REGISTER EMPLOYEE
	public void registerEmployee() {

		validateEmployeeLimit();

		employeeCount++;
	}

	// SHOW DETAILS
	@Override
	public void showDetails() {

		System.out.println("\n================================");

		System.out.println("Company : " + getCompanyName());

		System.out.println("Owner : " + client.getOwnerName());

		System.out.println("Plan : " + (plan != null ? plan.getPlanName() : "No Plan"));

		System.out.println("Employees : " + employeeCount);

		System.out.println("================================");

		branches.forEach(OrganizationComponent::showDetails);
	}

	// MONITOR BRANCHES
	public void monitorAllBranches() {

		System.out.println("\nMonitoring All Branches");

		branches.stream()

				.filter(Branch.class::isInstance)

				.map(Branch.class::cast)

				.forEach(Branch::executeBranchTasks);
	}

	// VALIDATE SUBSCRIPTION
	private void validateSubscription() {

		if (plan == null) {

			throw new IllegalStateException(

					"Please purchase a subscription plan");
		}
	}

	// VALIDATE BRANCH LIMIT
	private void validateBranchLimit() {

		if (branches.size() >= plan.maxBranches()) {

			throw new IllegalStateException(

					"Branch limit exceeded for plan : " + plan.getPlanName());
		}
	}

	// VALIDATE EMPLOYEE LIMIT
	private void validateEmployeeLimit() {

		if (employeeCount >= plan.maxEmployees()) {

			throw new IllegalStateException(

					"Employee limit exceeded for plan : " + plan.getPlanName());
		}
	}
}
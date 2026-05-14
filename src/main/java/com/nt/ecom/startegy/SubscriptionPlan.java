package com.nt.ecom.startegy;

public interface SubscriptionPlan {

	int maxBranches();

	int maxEmployees();

	String getPlanName();

	boolean hrAccess();

	boolean salesAccess();

	boolean financeAccess();

	boolean inventoryAccess();

	boolean supportAccess();

	boolean deliveryAccess();
}
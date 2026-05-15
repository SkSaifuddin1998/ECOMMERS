package com.nt.ecom.startegy;

public class FreePlan implements SubscriptionPlan {

	@Override
	public String getPlanName() {

		return "FREE";
	}

	@Override
	public int maxBranches() {

		return 2;
	}

	@Override
	public int maxEmployees() {

		return 5;
	}

	// =========================================
	// ACCESSIBLE MODULES
	// =========================================

	@Override
	public boolean hrAccess() {

		return true;
	}

	@Override
	public boolean salesAccess() {

		return true;
	}

	// =========================================
	// BLOCKED MODULES
	// =========================================

	@Override
	public boolean financeAccess() {

		return false;
	}

	@Override
	public boolean inventoryAccess() {

		return false;
	}

	@Override
	public boolean supportAccess() {

		return false;
	}

	@Override
	public boolean deliveryAccess() {

		return false;
	}
}
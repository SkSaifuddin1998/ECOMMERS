package com.nt.ecom.startegy;

public class PremiumPlan implements SubscriptionPlan {

	@Override
	public String getPlanName() {

		return "PREMIUM";
	}

	@Override
	public int maxBranches() {

		return 6;
	}

	@Override
	public int maxEmployees() {

		return 500;
	}

	@Override
	public boolean hrAccess() {

		return true;
	}

	@Override
	public boolean salesAccess() {

		return true;
	}

	@Override
	public boolean financeAccess() {

		return true;
	}

	@Override
	public boolean inventoryAccess() {

		return true;
	}

	@Override
	public boolean supportAccess() {

		return true;
	}

	@Override
	public boolean deliveryAccess() {

		return true;
	}
}
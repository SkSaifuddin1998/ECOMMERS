package com.erp.inventory.observer;
// =======================================================

// BRANCH ENTITY
// =======================================================

public class Branch {

	private String branchId;
	private String branchName;

	public Branch(String branchId, String branchName) {

		this.branchId = branchId;
		this.branchName = branchName;
	}

	public String getBranchName() {
		return branchName;
	}
}
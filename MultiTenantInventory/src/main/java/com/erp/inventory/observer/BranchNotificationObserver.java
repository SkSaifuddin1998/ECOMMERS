package com.erp.inventory.observer;

public class BranchNotificationObserver implements NotificationObserver {

	private String branchName;

	public BranchNotificationObserver(String branchName) {

		this.branchName = branchName;
	}

	@Override
	public void notifyUser(String message) {

		System.out.println("[" + branchName + "] " + message);
	}
}
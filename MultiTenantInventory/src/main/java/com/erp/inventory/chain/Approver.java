package com.erp.inventory.chain;

import com.erp.inventory.observer.TransferRequest;

public abstract class Approver {

	protected Approver nextApprover;

	public void setNextApprover(Approver nextApprover) {

		this.nextApprover = nextApprover;
	}

	public abstract void approve(TransferRequest request);
}
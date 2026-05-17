package com.erp.inventory.chain;

import com.erp.inventory.observer.TransferRequest;
import com.erp.inventory.observer.TransferStatus;

public class DirectorApprover extends Approver {

	@Override
	public void approve(TransferRequest request) {

		request.setStatus(TransferStatus.APPROVED);

		System.out.println("\nDIRECTOR APPROVED REQUEST : " + request.getRequestId());
	}
}
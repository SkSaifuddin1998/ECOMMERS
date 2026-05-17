package com.erp.inventory.chain;

import com.erp.inventory.observer.TransferRequest;
import com.erp.inventory.observer.TransferStatus;

public class ManagerApprover extends Approver {

	@Override
	public void approve(TransferRequest request) {

		if (request.getQuantity() <= 100) {

			request.setStatus(TransferStatus.APPROVED);

			System.out.println("\nMANAGER APPROVED REQUEST : " + request.getRequestId());

		} else {

			System.out.println("\nMANAGER ESCALATED REQUEST");

			if (nextApprover != null) {

				nextApprover.approve(request);
			}
		}
	}
}
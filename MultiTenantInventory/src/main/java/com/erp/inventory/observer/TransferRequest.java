package com.erp.inventory.observer;

import com.erp.inventory.product.Product;

public class TransferRequest {

    private String requestId;

    private Product product;

    private int quantity;

    private BranchInventory sourceBranch;

    private BranchInventory destinationBranch;

    private TransferStatus status;

    public TransferRequest(
            String requestId,
            Product product,
            int quantity,
            BranchInventory sourceBranch,
            BranchInventory destinationBranch
    ) {

        this.requestId = requestId;
        this.product = product;
        this.quantity = quantity;
        this.sourceBranch = sourceBranch;
        this.destinationBranch = destinationBranch;

        this.status = TransferStatus.PENDING;
    }

    public String getRequestId() {
        return requestId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public BranchInventory getSourceBranch() {
        return sourceBranch;
    }

    public BranchInventory getDestinationBranch() {
        return destinationBranch;
    }

    public TransferStatus getStatus() {
        return status;
    }

    public void setStatus(
            TransferStatus status) {

        this.status = status;
    }
}
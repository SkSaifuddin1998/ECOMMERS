package com.nt.ecom.startegy;

public class BasicPlan
        implements SubscriptionPlan {

    @Override
    public String getPlanName() {

        return "BASIC";
    }
    
    @Override
    public int maxBranches() {

        return 4;
    }

    @Override
    public int maxEmployees() {

        return 100;
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
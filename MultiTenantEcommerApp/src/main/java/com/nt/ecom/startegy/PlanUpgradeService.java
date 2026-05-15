package com.nt.ecom.startegy;

import com.nt.ecom.composite.HeadOffice;

public class PlanUpgradeService {

	public void upgradePlan(

			HeadOffice company,

			String newPlanType) {

		SubscriptionPlan oldPlan = company.getPlan();

		SubscriptionPlan newPlan = SubscriptionFactory.getPlan(newPlanType);

		if (oldPlan.getPlanName().equalsIgnoreCase(newPlan.getPlanName())) {

			System.out.println("Already using same plan");

			return;
		}

		company.purchasePlan(newPlan);

		System.out.println("\n================================");

		System.out.println("PLAN UPGRADED SUCCESSFULLY");

		System.out.println("Old Plan : " + oldPlan.getPlanName());

		System.out.println("New Plan : " + newPlan.getPlanName());

		System.out.println("================================");
	}
}
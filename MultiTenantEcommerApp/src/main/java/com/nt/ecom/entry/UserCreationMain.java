package com.nt.ecom.entry;

import com.nt.ecom.user.AccessManager;
import com.nt.ecom.user.Permission;
import com.nt.ecom.user.Role;
import com.nt.ecom.user.User;
import com.nt.ecom.user.UserFactory;

public class UserCreationMain {

	/*
	public static void main(String[] args) {

		// SUPER ADMIN
		User admin = UserFactory.createUser(

				1,

				"sujan",

				"admin123",

				Role.SUPER_ADMIN);

		// HR USER
		User hr = UserFactory.createUser(

				2,

				"rahul",

				"hr123",

				Role.HR_MANAGER);

		// SALES USER
		User sales = UserFactory.createUser(

				3,

				"amit",

				"sales123",

				Role.SALES_MANAGER);

		// DISPLAY USERS
		admin.showUser();

		hr.showUser();

		sales.showUser();

		// ACCESS CHECK
		AccessManager.checkAccess(

				admin,

				Permission.CREATE_BRANCH);

		AccessManager.checkAccess(

				hr,

				Permission.CREATE_BRANCH);

		AccessManager.checkAccess(

				sales,

				Permission.SALES_ACCESS);
	}
	
	*/
}
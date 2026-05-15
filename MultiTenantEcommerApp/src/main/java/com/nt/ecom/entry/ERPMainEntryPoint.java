package com.nt.ecom.entry;

import com.nt.ecom.client.Client;
import com.nt.ecom.client.ClientBuilder;
import com.nt.ecom.client.RegistrationService;
import com.nt.ecom.command.DeliveryTask;
import com.nt.ecom.command.DepartmentTask;
import com.nt.ecom.command.FinanceTask;
import com.nt.ecom.command.HRTask;
import com.nt.ecom.command.InventoryTask;
import com.nt.ecom.command.SalesTask;
import com.nt.ecom.command.SupportTask;
import com.nt.ecom.composite.Branch;
import com.nt.ecom.composite.Department;
import com.nt.ecom.composite.Employee;
import com.nt.ecom.composite.HeadOffice;
import com.nt.ecom.startegy.PlanUpgradeService;
import com.nt.ecom.startegy.SubscriptionFactory;
import com.nt.ecom.user.AccessManager;
import com.nt.ecom.user.Permission;
import com.nt.ecom.user.Role;
import com.nt.ecom.user.User;
import com.nt.ecom.user.UserFactory;

public class ERPMainEntryPoint {

    public static void main(String[] args) {

        // =========================================
        // CLIENT REGISTRATION
        // =========================================

        HeadOffice company1 =
                createBasicCompany();

        HeadOffice company2 =
                createPremiumCompany();

        // =========================================
        // DISPLAY COMPANIES
        // =========================================

        displayCompany(company1);
        
		PlanUpgradeService planService = new PlanUpgradeService();

		planService.upgradePlan(company1, "PREMIUM");

        displayCompany(company2);

        // =========================================
        // MONITOR TASKS
        // =========================================

        company1.monitorAllBranches();

        company2.monitorAllBranches();

        // =========================================
        // SEARCH OPERATIONS
        // =========================================

        searchClient(company2,
                "Global Retail ERP");

        searchBranch(company1,
                "Delhi Branch");

        searchDepartment(
                company1,
                "Delhi Branch",
                "Finance Department");

        searchEmployee(
                company1,
                "Delhi Branch",
                "Finance Department",
                103);
    }

    // =====================================================
    // CREATE BASIC COMPANY
    // =====================================================

    private static HeadOffice createBasicCompany() {

        Client client =
                registerClient(
                        1001,
                        "Saifuddin Ecommerce ERP",
                        "Sujan",
                        "sujan@gmail.com",
                        "9876543210");

        HeadOffice company =
                new HeadOffice(client);

        company.purchasePlan(
                SubscriptionFactory.getPlan(
                        "BASIC"));

        Branch kolkata =
                new Branch(
                        "Kolkata Branch",
                        "West Bengal");

        Branch delhi =
                new Branch(
                        "Delhi Branch",
                        "Delhi");

        kolkata.add(
                createDepartment(
                        "HR Department",
                        new HRTask(),
                        new Employee(
                                101,
                                "Rahul",
                                "HR Manager")));

        kolkata.add(
                createDepartment(
                        "Sales Department",
                        new SalesTask(),
                        new Employee(
                                102,
                                "Amit",
                                "Sales Executive")));

        delhi.add(
                createDepartment(
                        "Finance Department",
                        new FinanceTask(),
                        new Employee(
                                103,
                                "Priya",
                                "Finance Manager")));

        company.add(kolkata);

        company.add(delhi);
        
        createUsers();

        return company;
    }

    // =====================================================
    // CREATE PREMIUM COMPANY
    // =====================================================

    private static HeadOffice createPremiumCompany() {

        Client client =
                registerClient(
                        1002,
                        "Global Retail ERP",
                        "Saifuddin",
                        "global@gmail.com",
                        "9999999999");

        HeadOffice company =
                new HeadOffice(client);

        company.purchasePlan(
                SubscriptionFactory.getPlan(
                        "PREMIUM"));

        Branch mumbai =
                new Branch(
                        "Mumbai Branch",
                        "Maharashtra");

        Branch bangalore =
                new Branch(
                        "Bangalore Branch",
                        "Karnataka");

        mumbai.add(
                createDepartment(
                        "Inventory Department",
                        new InventoryTask(),
                        new Employee(
                                201,
                                "Rakesh",
                                "Inventory Manager")));

        bangalore.add(
                createDepartment(
                        "Support Department",
                        new SupportTask(),
                        new Employee(
                                202,
                                "Anjali",
                                "Support Executive")));

        bangalore.add(
                createDepartment(
                        "Delivery Department",
                        new DeliveryTask(),
                        new Employee(
                                203,
                                "Vikram",
                                "Delivery Manager")));

        company.add(mumbai);

        company.add(bangalore);
        createUsers();
        return company;
    }

    // =====================================================
    // CLIENT REGISTRATION
    // =====================================================

    private static Client registerClient(
            int id,
            String companyName,
            String ownerName,
            String email,
            String mobile) {

        Client client =
                new ClientBuilder()

                        .clientId(id)

                        .companyName(companyName)

                        .ownerName(ownerName)

                        .email(email)

                        .mobile(mobile)

                        .build();

        RegistrationService service =
                new RegistrationService();

        service.registerClient(client);

        return client;
    }

    // =====================================================
    // CREATE DEPARTMENT
    // =====================================================

    private static Department createDepartment(
            String departmentName,
            DepartmentTask task,
            Employee employee) {

        Department department =
                new Department(departmentName);

        department.setTask(task);

        department.add(employee);

        return department;
    }
    
	private static void createUsers() {

		User superAdmin = UserFactory.createUser(

				1,

				"sujan",

				"admin@gmail.com",

				"admin123",

				Role.SUPER_ADMIN);

		User hrManager = UserFactory.createUser(

				2,

				"rahul",

				"hr@gmail.com",

				"hr123",

				Role.HR_MANAGER);

		User salesManager = UserFactory.createUser(

				3,

				"amit",

				"sales@gmail.com",

				"sales123",

				Role.SALES_MANAGER);

		// DISPLAY USERS
		superAdmin.showUser();

		hrManager.showUser();

		salesManager.showUser();

		// ACCESS CHECK
		AccessManager.checkAccess(

				superAdmin,

				Permission.CREATE_BRANCH);

		AccessManager.checkAccess(

				hrManager,

				Permission.CREATE_BRANCH);

		AccessManager.checkAccess(

				salesManager,

				Permission.SALES_ACCESS);
	}

    // =====================================================
    // DISPLAY COMPANY
    // =====================================================

    private static void displayCompany(
            HeadOffice company) {

        System.out.println(
                "\n================================");

        System.out.println(
                company.getCompanyName());

        System.out.println(
                "================================");

        company.showDetails();
    }

    // =====================================================
    // SEARCH CLIENT
    // =====================================================

    private static void searchClient(
            HeadOffice company,
            String clientName) {

        System.out.println(
                "\nSEARCH CLIENT");

        if(company.getCompanyName()
                .equalsIgnoreCase(clientName)) {

            System.out.println(
                    "Client Found : "
                            + company.getCompanyName());
        }
    }

    // =====================================================
    // SEARCH BRANCH
    // =====================================================

    private static void searchBranch(
            HeadOffice company,
            String branchName) {

        System.out.println(
                "\nSEARCH BRANCH");

        company.findBranch(branchName)

                .ifPresentOrElse(

                        branch -> {

                            System.out.println(
                                    "Branch Found : "
                                            + branch.getBranchName());

                            branch.showDetails();
                        },

                        () -> {

                            System.out.println(
                                    "Branch Not Found");
                        });
    }

    // =====================================================
    // SEARCH DEPARTMENT
    // =====================================================

    private static void searchDepartment(
            HeadOffice company,
            String branchName,
            String departmentName) {

        System.out.println(
                "\nSEARCH DEPARTMENT");

        company.findBranch(branchName)

                .ifPresent(branch -> {

                    Department department =
                            branch.findDepartment(
                                    departmentName);

                    if(department != null) {

                        System.out.println(
                                "Department Found : "
                                        + department.getDepartmentName());

                        department.performTask();
                    }
                });
    }

    // =====================================================
    // SEARCH EMPLOYEE
    // =====================================================

    private static void searchEmployee(
            HeadOffice company,
            String branchName,
            String departmentName,
            int employeeId) {

        System.out.println(
                "\nSEARCH EMPLOYEE");

        company.findBranch(branchName)

                .ifPresent(branch -> {

                    Department department =
                            branch.findDepartment(
                                    departmentName);

                    if(department != null) {

                        Employee employee =
                                department.findEmployee(
                                        employeeId);

                        if(employee != null) {

                            System.out.println(
                                    "Employee Found");

                            employee.showDetails();
                        }
                    }
                });
    }
}
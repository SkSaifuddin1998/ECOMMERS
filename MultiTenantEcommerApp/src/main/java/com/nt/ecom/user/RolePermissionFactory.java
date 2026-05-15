package com.nt.ecom.user;

import java.util.Set;

public class RolePermissionFactory {

    public static Set<Permission>
    getPermissions(Role role) {

        return switch(role) {

            case SUPER_ADMIN -> Set.of(

                    Permission.CREATE_BRANCH,
                    Permission.CREATE_DEPARTMENT,
                    Permission.CREATE_EMPLOYEE,
                    Permission.DELETE_EMPLOYEE,
                    Permission.HR_ACCESS,
                    Permission.SALES_ACCESS,
                    Permission.FINANCE_ACCESS,
                    Permission.INVENTORY_ACCESS,
                    Permission.DELIVERY_ACCESS,
                    Permission.SUPPORT_ACCESS
            );

            case HR_MANAGER -> Set.of(

                    Permission.CREATE_EMPLOYEE,
                    Permission.VIEW_EMPLOYEE,
                    Permission.HR_ACCESS
            );

            case SALES_MANAGER -> Set.of(

                    Permission.SALES_ACCESS
            );

            case FINANCE_MANAGER -> Set.of(

                    Permission.FINANCE_ACCESS
            );

            case INVENTORY_MANAGER -> Set.of(

                    Permission.INVENTORY_ACCESS
            );

            default -> Set.of();
        };
    }
}
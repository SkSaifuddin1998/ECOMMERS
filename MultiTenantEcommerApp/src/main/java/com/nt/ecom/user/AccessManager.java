package com.nt.ecom.user;

import com.nt.ecom.user.User;

public class AccessManager {

    public static void checkAccess(

            User user,

            Permission permission) {

        if(user.hasPermission(permission)) {

            System.out.println(

                    "\nACCESS GRANTED : "
                            + permission);
        }

        else {

            System.out.println(

                    "\nACCESS DENIED : "
                            + permission);
        }
    }
}
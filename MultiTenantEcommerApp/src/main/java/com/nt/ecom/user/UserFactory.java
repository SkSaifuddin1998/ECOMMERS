package com.nt.ecom.user;

public class UserFactory {

    public static User createUser(

            int id,

            String username,

            String email,

            String password,

            Role role) {

        return new UserBuilder()

                .userId(id)

                .username(username)

                .email(email)

                .password(password)

                .role(role)

                .permissions(

                        RolePermissionFactory
                                .getPermissions(role))

                .build();
    }
}
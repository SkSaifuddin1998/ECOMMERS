package com.nt.ecom.user;

import java.util.Set;

public class User {

    private final int userId;

    private final String username;

    private final String email;

    private final String password;

    private final Role role;

    private final Set<Permission>
            permissions;

    public User(
            int userId,
            String username,
            String email,
            String password,
            Role role,
            Set<Permission> permissions) {

        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.permissions = permissions;
    }

    public int getUserId() {

        return userId;
    }

    public String getUsername() {

        return username;
    }

    public Role getRole() {

        return role;
    }

    public boolean hasPermission(
            Permission permission) {

        return permissions.contains(
                permission);
    }

    public void showUser() {

        System.out.println(
                "\n================================");

        System.out.println(
                "User ID : " + userId);

        System.out.println(
                "Username : " + username);

        System.out.println(
                "Role : " + role);

        System.out.println(
                "Permissions : " + permissions);

        System.out.println(
                "================================");
    }
}
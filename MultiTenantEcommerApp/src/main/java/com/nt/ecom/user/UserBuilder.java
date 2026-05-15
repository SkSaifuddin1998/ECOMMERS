package com.nt.ecom.user;

import java.util.Set;

public class UserBuilder {

    private int userId;

    private String username;

    private String email;

    private String password;

    private Role role;

    private Set<Permission>
            permissions;

    public UserBuilder userId(
            int userId) {

        this.userId = userId;

        return this;
    }

    public UserBuilder username(
            String username) {

        this.username = username;

        return this;
    }

    public UserBuilder email(
            String email) {

        this.email = email;

        return this;
    }

    public UserBuilder password(
            String password) {

        this.password = password;

        return this;
    }

    public UserBuilder role(
            Role role) {

        this.role = role;

        return this;
    }

    public UserBuilder permissions(
            Set<Permission> permissions) {

        this.permissions = permissions;

        return this;
    }

    public User build() {

        return new User(

                userId,

                username,

                email,

                password,

                role,

                permissions);
    }
}
package com.api.domain;

import com.api.security.ApplicationUserPermission;
import com.api.security.ApplicationUserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
//@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private ApplicationUserRole role;
    private ApplicationUserPermission permission;
    private String email;
    private String registeredAt;
    private String name;
    private String surname;
    private int age;

    public User() {
    }

    public User(String username, String password, ApplicationUserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String username, String password, ApplicationUserRole role,
                ApplicationUserPermission permission, String email, String registeredAt
            , String name, String surname, int age) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.permission = permission;
        this.email = email;
        this.registeredAt = registeredAt;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}

package com.api.domain.dto;

import com.api.security.ApplicationUserPermission;
import com.api.security.ApplicationUserRole;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
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
}

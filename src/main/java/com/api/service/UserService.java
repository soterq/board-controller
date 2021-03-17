package com.api.service;

import com.api.domain.User;
import com.api.security.ApplicationUserRole;

import java.util.List;


public interface UserService {

    User findUserById(Long id);

    List<User> findAllUsers();

    User saveUser(User user);

    void deleteUser(Long id);

    User updateUser(User user);

    User updateRole(Long id, ApplicationUserRole role);
}

//package com.api.service;
//
//import com.api.domain.User;
//import com.api.repository.UserRepository;
//import com.api.security.ApplicationUserRole;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserServiceImpl implements UserService{
//
//    private final UserRepository userRepository;
//
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public User findUserById(Long id) {
//        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not found"));
//    }
//
//    @Override
//    public List<User> findAllUsers() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public User saveUser(User user) {
//        return userRepository.save(user);
//    }
//
//    @Override
//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//    }
//
//    @Override
//    public User updateUser(User user) {
//        return userRepository.save(user);
//    }
//
//    @Override
//    public User updateRole(Long id, ApplicationUserRole role) {
//        User user = userRepository.findById(id).get();
//        user.setRole(role);
//        return userRepository.save(user);
//    }
//
//}

//package com.api.controllers;
//
//import com.api.domain.User;
//import com.api.domain.dto.UserDTO;
//import com.api.mappers.UserMapper;
//import com.api.service.UserServiceImpl;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
////@RestController
////@RequestMapping(UserController.BASE_URL)
//public class UserController {
//
//    public static final String BASE_URL = "/api/v1/users";
//
//    private final UserMapper userMapper;
//    private final UserServiceImpl userService;
//
//    public UserController(UserMapper userMapper, UserServiceImpl userService) {
//        this.userMapper = userMapper;
//        this.userService = userService;
//    }
//
//    @GetMapping
//    public List<UserDTO> getAllUsers() {
//        List<UserDTO> users = new ArrayList<>();
//        for (User user : userService.findAllUsers()) {
//            users.add(userMapper.toDto(user));
//        }
//        return users;
//    }
//
//    @GetMapping(path = "{/id}")
//    public UserDTO findUser(@PathVariable("id") Long id) {
//        return userMapper.toDto(userService.findUserById(id));
//    }
//
//    @PostMapping
//    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
//        return userMapper.toDto(userService.saveUser(userMapper.fromDto(userDTO)));
//    }
//
//    @PutMapping
//    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
//        return userMapper.toDto(userService.saveUser(userMapper.fromDto(userDTO)));
//    }
//
//    @DeleteMapping(path = "{/id}")
//    public void deleteUser(@PathVariable("id") Long id) {
//        userService.deleteUser(id);
//    }
//
//}

package com.microservices.controller;

import com.microservices.models.user.request.UserRequest;
import com.microservices.models.user.request.UserUpdateRequest;
import com.microservices.models.user.response.UserResponse;
import com.microservices.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/user")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @PutMapping
    public UserResponse updateUser(@RequestBody UserUpdateRequest userUpdateRequest) {
        return userService.updateUser(userUpdateRequest);
    }

    @GetMapping
    public List<UserResponse> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/userId/{userId}")
    public UserResponse getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }


}

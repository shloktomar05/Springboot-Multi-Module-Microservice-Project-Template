package com.microservices.service;

import com.microservices.model.User;
import com.microservices.models.user.request.UserUpdateRequest;
import com.microservices.models.user.response.UserResponse;
import com.microservices.models.user.request.UserRequest;
import com.microservices.repository.UserRepository;
import com.microservices.utility.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserResponse createUser(UserRequest userRequest) {
        return UserMapper.mapUserToUserResponse(userRepository.save(UserMapper.mapUserRequestToUser(userRequest)));
    }

    public UserResponse updateUser(UserUpdateRequest userUpdateRequest) {
        User user = userRepository.findById(userUpdateRequest.getUserId()).orElseThrow(()-> new RuntimeException("Enity not found"));
        return UserMapper.mapUserToUserResponse(userRepository.save(UserMapper.mapUserUpdateRequestToUser(userUpdateRequest,user)));
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(UserMapper::mapUserToUserResponse).collect(Collectors.toList());
    }

    public UserResponse getUserById(String userId) {
        return UserMapper.mapUserToUserResponse(userRepository.findById(userId).orElseThrow(()-> new RuntimeException("Enity not found")));
    }
}

package com.microservices.utility;

import com.microservices.model.User;
import com.microservices.models.user.request.UserRequest;
import com.microservices.models.user.request.UserUpdateRequest;
import com.microservices.models.user.response.UserResponse;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class UserMapper {

    public User mapUserRequestToUser(UserRequest userRequest){
        return User.builder()
                .userId(UUID.randomUUID().toString())
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .about(userRequest.getAbout())
                .build();
    }

    public User mapUserUpdateRequestToUser(UserUpdateRequest userUpdateRequest, User user){
        return User.builder()
                .userId(user.getUserId())
                .username(userUpdateRequest.getUsername())
                .email(userUpdateRequest.getEmail())
                .about(userUpdateRequest.getAbout())
                .build();
    }

    public UserResponse mapUserToUserResponse(User user){
        return UserResponse.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .email(user.getEmail())
                .about(user.getAbout())
                .build();
    }


}

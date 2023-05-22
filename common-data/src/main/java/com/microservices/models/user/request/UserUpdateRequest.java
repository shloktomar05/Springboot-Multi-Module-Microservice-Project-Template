package com.microservices.models.user.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserUpdateRequest {
    private String userId;
    private String username;
    private String email;
    private String about;
}

package com.sammal.plantation.users.dto;

import com.sammal.plantation.users.domain.Users;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserResponse {

    private String userId;
    private String password;
    private String phone;
    private String address;
    private String email;

    public UserResponse(Users users) {
        this.userId = users.getUserId();
        this.password = users.getPassword();
        this.phone = users.getPhone();
        this.address = users.getAddress();
        this.email = users.getEmail();
    }
}

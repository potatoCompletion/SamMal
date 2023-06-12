package com.sammal.plantation.users.dto;

import com.sammal.plantation.users.domain.Users;
import lombok.Getter;

@Getter
public class UserResponse {

    private String userId;
    private String password;
    private String name;
    private String phone;
    private String email;

    public UserResponse(Users users) {
        this.userId = users.getUserId();
        this.password = users.getPassword();
        this.name = users.getName();
        this.phone = users.getPhone();
        this.email = users.getEmail();
    }
}

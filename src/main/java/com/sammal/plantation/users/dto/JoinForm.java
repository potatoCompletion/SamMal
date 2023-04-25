package com.sammal.plantation.users.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinForm {

    @NotBlank(message = "id는 필수 값입니다.")
    private String userId;
    @NotBlank(message = "password는 필수 값입니다.")
    private String password;
    @NotBlank(message = "phone은 필수 값입니다.")
    private String phone;
    @NotBlank(message = "주소는 필수 값입니다.")
    private String address;
    @NotBlank(message = "email는 필수 값입니다.")
    @Email
    private String email;

    @Builder
    public JoinForm(String userId, String password, String phone, String address, String email) {
        this.userId = userId;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }
}
package com.sammal.plantation.users.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinParam {

    @NotBlank(message = "id는 필수 값입니다.")
    private String userId;
    @NotBlank(message = "password는 필수 값입니다.")
    private String password;
    @NotBlank(message = "name은 필수 값입니다.")
    private String name;
    @NotBlank(message = "phone은 필수 값입니다.")
    private String phone;
    @NotBlank(message = "주소는 필수 값입니다.")
    private String address;
    @NotBlank(message = "email은 필수 값입니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;

    @Builder
    public JoinParam(String userId, String password, String name, String phone, String address, String email) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }
}

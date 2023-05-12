package com.sammal.plantation.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserParam {

    @NotBlank(message = "phone은 필수 값입니다.")
    private String phone;
    @NotBlank(message = "email은 필수 값입니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;

    @Builder
    public UpdateUserParam(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }
}

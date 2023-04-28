package com.sammal.plantation.users.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "아이디는 필수 값입니다.")
    private String userId;
    @NotBlank(message = "비밀번호는 필수 값입니다.")
    private String password;
    @NotBlank(message = "전화번호는 필수 값입니다.")
    private String phone;
    @NotBlank(message = "주소는 필수 값입니다.")
    private String address;
    @NotBlank(message = "이메일은 필수 값입니다.")
    private String email;

    @Builder
    public Users(String userId, String password, String phone, String address, String email) {

        this.userId = userId;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }
}

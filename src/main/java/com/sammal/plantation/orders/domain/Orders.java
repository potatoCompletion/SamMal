package com.sammal.plantation.orders.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderCode;
    @NotBlank(message = "아이디는 필수 값입니다.")
    private String userId;
    @NotBlank(message = "비밀번호는 필수 값입니다.")
    private String password;
    @NotBlank(message = "성함은 필수 값입니다.")
    private String name;
    @NotBlank(message = "전화번호는 필수 값입니다.")
    private String phone;
    @NotBlank(message = "주소는 필수 값입니다.")
    private String address;
    @NotBlank(message = "이메일은 필수 값입니다.")
    private String email;

    @Builder
    public Orders(String userId, String password, String name, String phone, String address, String email) {

        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }
}

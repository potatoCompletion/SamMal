package com.sammal.plantation.users.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String password;
    private String phone;
    private String address;
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

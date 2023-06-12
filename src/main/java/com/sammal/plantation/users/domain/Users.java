package com.sammal.plantation.users.domain;

import com.sammal.plantation.common.domain.BaseTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Users extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userCode;
    @NotBlank(message = "아이디는 필수 값입니다.")
    private String userId;
    @NotBlank(message = "비밀번호는 필수 값입니다.")
    private String password;
    @NotBlank(message = "성함은 필수 값입니다.")
    private String name;
    @NotBlank(message = "전화번호는 필수 값입니다.")
    private String phone;
    @NotBlank(message = "이메일은 필수 값입니다.")
    private String email;

    @Builder
    public Users(String userId, String password, String name, String phone, String email) {

        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public void updatePhone(String phone) {
        this.phone = phone;
    }

    public void updateEmail(String email) {
        this.email = email;
    }
}

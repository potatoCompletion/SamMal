package com.sammal.plantation.orders.domain;

import jakarta.validation.constraints.NotBlank;

public class OrderDetail {
    @NotBlank(message = "성함은 필수 값입니다.")
    private String name;
    @NotBlank(message = "전화번호는 필수 값입니다.")
    private String phone;
    @NotBlank(message = "주소는 필수 값입니다.")
    private String address;
}

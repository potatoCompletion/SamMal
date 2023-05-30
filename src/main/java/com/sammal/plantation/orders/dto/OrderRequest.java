package com.sammal.plantation.orders.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OrderRequest {

    @NotBlank(message = "아이디는 필수 값입니다.")
    private String userId;
    @NotBlank(message = "상품코드는 필수 값입니다.")
    private String productCode;
    @NotBlank(message = "성함은 필수 값입니다.")
    private String recipientName;
    @NotBlank(message = "전화번호는 필수 값입니다.")
    private String recipientPhone;
    @NotBlank(message = "주소는 필수 값입니다.")
    private String recipientAddress;

    @Builder
    public OrderRequest(String userId, String productCode, String recipientName, String recipientPhone, String recipientAddress) {

        this.userId = userId;
        this.productCode = productCode;
        this.recipientName = recipientName;
        this.recipientPhone = recipientPhone;
        this.recipientAddress = recipientAddress;
    }
}

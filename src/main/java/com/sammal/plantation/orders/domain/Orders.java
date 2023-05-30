package com.sammal.plantation.orders.domain;

import com.sammal.plantation.common.domain.BaseTime;
import com.sammal.plantation.orders.dto.OrderRequest;
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
public class Orders extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderCode;
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
    public Orders(String userId, String productCode, String recipientName, String recipientPhone, String recipientAddress) {

        this.userId = userId;
        this.productCode = productCode;
        this.recipientName = recipientName;
        this.recipientPhone = recipientPhone;
        this.recipientAddress = recipientAddress;
    }

    public Orders(OrderRequest orderRequest) {

        this.userId = orderRequest.getUserId();
        this.productCode = orderRequest.getProductCode();
        this.recipientName = orderRequest.getRecipientName();
        this.recipientPhone = orderRequest.getRecipientPhone();
        this.recipientAddress = orderRequest.getRecipientAddress();
    }
}

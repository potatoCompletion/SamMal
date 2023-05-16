package com.sammal.plantation.products.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    private String productCode;
    @NotBlank(message = "상품명은 필수 값입니다.")
    private String name;
    @NotBlank(message = "가격은 필수 값입니다.")
    private String price;
    @NotBlank(message = "상품 설명은 필수 값입니다.")
    private String description;
}

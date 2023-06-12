package com.sammal.plantation.products.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductParam {

    @NotBlank(message = "상품명은 필수 값입니다.")
    private String name;
    @NotBlank(message = "가격은 필수 값입니다.")
    private String price;
    @NotBlank(message = "재고량은 필수 값입니다.")
    private String stock;
    @NotBlank(message = "상품설명은 필수 값입니다.")
    private String description;

    @Builder
    public ProductParam(String name, String price, String stock, String description) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }
}

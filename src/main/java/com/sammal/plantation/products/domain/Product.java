package com.sammal.plantation.products.domain;

import com.sammal.plantation.products.dto.ProductParam;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productCode;
    @NotBlank(message = "상품명은 필수 값입니다.")
    private String name;
    @NotBlank(message = "가격은 필수 값입니다.")
    private String price;
    @NotBlank(message = "재고는 필수 값입니다.")
    private String stock;
    @NotBlank(message = "상품 설명은 필수 값입니다.")
    private String description;

    public Product(ProductParam productParam) {
        this.name = productParam.getName();
        this.price = productParam.getPrice();
        this.stock = productParam.getStock();
        this.description = productParam.getDescription();
    }
}

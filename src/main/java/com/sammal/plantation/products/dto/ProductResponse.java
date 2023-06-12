package com.sammal.plantation.products.dto;

import com.sammal.plantation.products.domain.Product;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {

    private String name;
    private String price;
    private String stock;
    private String description;

    public ProductResponse(Product product) {

        this.name = product.getName();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.description = product.getDescription();
    }
}

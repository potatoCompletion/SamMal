package com.sammal.plantation.products.service;

import com.sammal.plantation.products.domain.Product;
import com.sammal.plantation.products.dto.ProductParam;
import com.sammal.plantation.products.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("상품 등록 테스트")
    void insertTest() {
        //given
        ProductParam productParam = ProductParam.builder()
                .name("양배추 1kg")
                .price("50000")
                .stock("50")
                .description("무기농 양배추입니다.")
                .build();

        //when
        productService.insertProduct(productParam);
        Product product = productRepository.findByProductCode(1L).get();

        //then
        Assertions.assertEquals("양배추 1kg", product.getName());
    }
}

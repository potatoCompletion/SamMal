package com.sammal.plantation.products.controller;

import com.sammal.plantation.products.dto.ProductParam;
import com.sammal.plantation.products.dto.ProductResponse;
import com.sammal.plantation.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/product")
    public void productEnroll(@RequestBody ProductParam request) {

        productService.insertProduct(request);
    }

    @GetMapping("/product/{productCode}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long productCode) throws UserPrincipalNotFoundException {

        ProductResponse response = productService.selectProduct(productCode);

        return ResponseEntity.ok(response);
    }
}

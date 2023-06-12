package com.sammal.plantation.products.service;

import com.sammal.plantation.products.domain.Product;
import com.sammal.plantation.products.dto.ProductParam;
import com.sammal.plantation.products.dto.ProductResponse;
import com.sammal.plantation.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void insertProduct(ProductParam request) {

        Product product = new Product(request);

        productRepository.save(product);
    }

    public ProductResponse selectProduct(Long productCode) throws UserPrincipalNotFoundException {

        return new ProductResponse(
                productRepository.findByProductCode(productCode).orElseThrow(() ->
                        new UserPrincipalNotFoundException("찾고자 하는 상품코드가 존재하지 않습니다."))
        );
    }
}

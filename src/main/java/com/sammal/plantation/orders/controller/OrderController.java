package com.sammal.plantation.orders.controller;

import com.sammal.plantation.orders.dto.OrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @PostMapping("/order")
    public void createOrder(@RequestBody OrderRequest request) {


    }
}

package com.sammal.plantation.orders.service;

import com.sammal.plantation.orders.domain.Orders;
import com.sammal.plantation.orders.dto.OrderRequest;
import com.sammal.plantation.orders.repository.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    @DisplayName("주문을 생성한다.")
    void createOrderTest() {
        //given
        OrderRequest orderRequest = OrderRequest.builder()
                .productCode("1001")
                .userId("kws2628")
                .recipientName("김완수")
                .recipientPhone("01051792628")
                .recipientAddress("강원도 삼척시")
                .build();

        //when
        orderService.createOrder(orderRequest);
        Orders result = orderRepository.findByOrderCode(1L).get();

        //then
        Assertions.assertEquals("1001", result.getProductCode());
    }
}
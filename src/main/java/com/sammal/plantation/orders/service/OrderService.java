package com.sammal.plantation.orders.service;

import com.sammal.plantation.orders.domain.Orders;
import com.sammal.plantation.orders.dto.OrderRequest;
import com.sammal.plantation.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void createOrder(OrderRequest request) {

        Orders orders = new Orders(request);
        orderRepository.save(orders);
    }
}

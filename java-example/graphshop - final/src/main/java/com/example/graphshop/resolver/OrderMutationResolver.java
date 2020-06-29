package com.example.graphshop.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphshop.model.Order;
import com.example.graphshop.model.OrderInput;
import com.example.graphshop.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderMutationResolver
        implements GraphQLMutationResolver {

    private OrderService orderService;

    public OrderMutationResolver(OrderService orderService) {
        this.orderService = orderService;
    }

    public Order createOrder(OrderInput input) {
        return orderService.createOrder(input);
    }
}

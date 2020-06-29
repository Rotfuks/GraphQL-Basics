package com.example.graphshop.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphshop.model.Customer;
import com.example.graphshop.model.Order;
import com.example.graphshop.service.OrderService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerResolver implements GraphQLResolver<Customer> {
    private OrderService orderService;

    public CustomerResolver(final OrderService orderService) {
        this.orderService = orderService;
    }

    public List<Order> orders(final Customer customer) {
        return orderService.getOrdersByIds(customer.getOrderIds());
    }

    public String fullname (final Customer customer) {
        return customer.getFirstname() + " " +
                customer.getLastname();
    }
}
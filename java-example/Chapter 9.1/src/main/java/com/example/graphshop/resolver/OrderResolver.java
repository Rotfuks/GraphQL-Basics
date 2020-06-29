package com.example.graphshop.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphshop.model.Order;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderResolver implements GraphQLResolver<Order> {

    public Boolean isDelivered(final Order order) {
        return LocalDate.now()
                .isAfter(order.getDeliverydate())
                || LocalDate.now()
                .isEqual(order.getDeliverydate());
    }
}

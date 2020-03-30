package com.example.graphshop.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphshop.model.Customer;
import com.example.graphshop.model.Order;
import com.example.graphshop.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerResolver implements GraphQLResolver<Customer> {
    private OrderService orderService;

    public CustomerResolver(final OrderService orderService) {
        this.orderService = orderService;
    }

    public List<Order> orders(final Customer customer,
                              final String id,
                              final Boolean isDeliverd) {
        List<Order> customerOrders =
                orderService.getOrdersByIds(customer.getOrderIds());
        if (isDeliverd != null) {
            customerOrders = customerOrders.stream()
                    .filter(o -> {
                        if(isDeliverd) return LocalDate.now()
                                .isAfter(o.getDeliverydate())
                                || LocalDate.now()
                                .isEqual(o.getDeliverydate());
                        else return LocalDate.now()
                                .isBefore(o.getDeliverydate());
                    })
                    .collect(Collectors.toList());
        }
        if (id != null)
            return customerOrders.stream()
                    .filter(o -> o.getId().equals(id))
                    .collect(Collectors.toList());
        return customerOrders;
    }

    public String fullname (final Customer customer) {
        return customer.getFirstname() + " " +
                customer.getLastname();
    }
}

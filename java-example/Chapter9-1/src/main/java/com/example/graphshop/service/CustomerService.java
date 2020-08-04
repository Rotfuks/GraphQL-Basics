package com.example.graphshop.service;

import com.example.graphshop.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class CustomerService {

    private List<Customer> customerData =
            new ArrayList<>(Arrays.asList(
                    new Customer("Luke", "Skywalker",
                            OrderService.ADDRESS_DATA,
                            OrderService.ORDER_IDS),
                    new Customer("Leia", "Organa",
                            OrderService.ADDRESS_DATA,
                            OrderService.ORDER_IDS)));

    public Customer getCustomer(String id) {
        return customerData.stream()
                .filter((c) -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
package com.example.graphshop.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphshop.model.Customer;
import com.example.graphshop.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class QueryResolver implements GraphQLQueryResolver {

    private CustomerService customerService;

    public QueryResolver(final CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer customer(String id) {
        return customerService.getCustomer(id);
    }
}

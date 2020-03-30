package com.example.graphshop.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphshop.model.Customer;
import com.example.graphshop.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerMutationResolver implements GraphQLMutationResolver {

    private CustomerService customerService;

    public CustomerMutationResolver(final CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer registerCustomer(final String firstname, final String lastname) {
        return customerService.registerCustomer(firstname, lastname);
    }

}

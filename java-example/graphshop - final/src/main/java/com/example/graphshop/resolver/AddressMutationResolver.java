package com.example.graphshop.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphshop.model.Address;
import com.example.graphshop.model.AddressInput;
import com.example.graphshop.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class AddressMutationResolver implements GraphQLMutationResolver {

    public CustomerService customerService;

    public AddressMutationResolver(CustomerService customerService) {
        this.customerService = customerService;
    }

    public boolean deleteAddress(String customerId, String addressId) {
        return customerService.deleteAddress(customerId, addressId);
    }

    public Address createAddress (AddressInput addressInput) {
        return customerService.createAddress(addressInput);
    }
}
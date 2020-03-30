package com.example.graphshop.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphshop.model.Adress;
import com.example.graphshop.model.AdressInput;
import com.example.graphshop.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class AdressMutationResolver implements GraphQLMutationResolver {

    public CustomerService customerService;

    public AdressMutationResolver (CustomerService customerService) {
        this.customerService = customerService;
    }

    public boolean deleteAdress (String customerId, String adressId) {
        return customerService.deleteAdress(customerId, adressId);
    }

    public Adress createAdress (AdressInput adressInput) {
        return customerService.createAdress(adressInput);
    }
}

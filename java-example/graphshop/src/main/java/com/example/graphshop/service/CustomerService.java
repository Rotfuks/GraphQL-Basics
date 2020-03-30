package com.example.graphshop.service;

import com.example.graphshop.model.Adress;
import com.example.graphshop.model.AdressInput;
import com.example.graphshop.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private List<Customer> customerData =
            new ArrayList<>(Arrays.asList(
                    new Customer("Luke", "Skywalker",
                            OrderService.ADRESS_DATA,
                            OrderService.ORDER_IDS),
                    new Customer("Leia", "Organa",
                            OrderService.ADRESS_DATA,
                            OrderService.ORDER_IDS)));

    public Customer getCustomer(String id) {
        return customerData.stream()
                .filter((c) -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Customer registerCustomer(String firstname, String lastname) {
        Customer newCustomer = new Customer(firstname, lastname,
                Collections.emptyList(), Collections.emptyList());
        customerData.add(newCustomer);
        return newCustomer;
    }

    public Boolean deleteAdress(String customerId, String adressId) {
        Customer customer = getCustomer(customerId);
        int customerIndex = customerData.indexOf(customer);
        if (customer == null) return false;
        customer.setAdresses(
                customer.getAdresses()
                        .stream()
                        .filter((a) -> !a.getId().equals(adressId))
                        .collect(Collectors.toList()));
        customerData.set(customerIndex, customer);
        return true;
    }

    public Adress createAdress(AdressInput adressInput) {
        Customer customer = getCustomer(adressInput.getCustomerId());
        int customerIndex = customerData.indexOf(customer);
        if (customer == null) return null;
        Adress newAdress = new Adress(adressInput.getReceiver(),
                adressInput.getZipcode(),
                adressInput.getCityname(),
                adressInput.getStreetname(),
                adressInput.getHousenumber());
        List<Adress> newAdresses = customer.getAdresses();
        newAdresses.add(newAdress);
        customer.setAdresses(newAdresses);
        customerData.set(customerIndex, customer);
        return newAdress;
    }

    public void saveCustomer(Customer customer) {
        int index = customerData.indexOf(customer);
        if (index == -1) customerData.add(customer);
        else customerData.set(index, customer);
    }
}

package com.example.graphshop.service;

import com.example.graphshop.model.Address;
import com.example.graphshop.model.AddressInput;
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

    public Customer registerCustomer(String firstname, String lastname) {
        Customer newCustomer = new Customer(firstname, lastname,
                Collections.emptyList(), Collections.emptyList());
        customerData.add(newCustomer);
        return newCustomer;
    }

    public Boolean deleteAddress(
            String customerId, String addressId) {
        Customer customer = getCustomer(customerId);
        int customerIndex = customerData.indexOf(customer);
        if (customer == null) return false;

        customer.setAddresses(
                customer.getAddresses()
                        .stream()
                        .filter((a) -> !a.getId().equals(addressId))
                        .collect(Collectors.toList()));
        customerData.set(customerIndex, customer);
        return true;
    }

    public Address createAddress(AddressInput addressInput) {
        Customer customer = getCustomer(addressInput.getCustomerId());
        int customerIndex = customerData.indexOf(customer);
        if (customer == null) return null;

        Address newAddress = new Address(
                addressInput.getReceiver());

        List<Address> newAddresses = customer.getAddresses();
        newAddresses.add(newAddress);
        customer.setAddresses(newAddresses);
        customerData.set(customerIndex, customer);
        return newAddress;
    }

    public void saveCustomer(Customer customer) {
        int index = customerData.indexOf(customer);
        if (index == -1) customerData.add(customer);
        else customerData.set(index, customer);
    }
}
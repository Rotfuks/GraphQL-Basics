package com.example.graphshop.service;

import com.example.graphshop.model.Address;
import com.example.graphshop.model.Customer;
import com.example.graphshop.model.Order;
import com.example.graphshop.model.OrderInput;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private CustomerService customerService;

    public OrderService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public static final List<Address> ADDRESS_DATA =
            new ArrayList<>(Arrays.asList(
                    new Address("Lars Moisture Farm"),
                    new Address("Alderaan Palace")));
    public static final List<Order> ORDER_DATA =
            new ArrayList<>(Arrays.asList(
                    new Order(11.38f, ADDRESS_DATA.get(0), LocalDate.now()),
                    new Order(42.99f, ADDRESS_DATA.get(1), LocalDate.now().plusDays(1))));
    public static final List<String> ORDER_IDS =
            new ArrayList<>(Arrays.asList(
                    ORDER_DATA.get(0).getId(),
                    ORDER_DATA.get(1).getId()));

    public List<Order> getOrdersByIds(List<String> ids) {
        return ORDER_DATA.stream()
                .filter((o) -> ids.contains(o.getId()))
                .collect(Collectors.toList());
    }

    public Order createOrder(OrderInput input) {
        Customer customer = customerService.getCustomer(
                input.getCustomerId());
        if (customer == null) return null;

        Address address = null;
        if (input.getDeliveryaddressId() != null) {
            address = customer.getAddresses()
                    .stream()
                    .filter(a -> a.getId().equals(
                            input.getDeliveryaddressId()))
                    .findFirst().orElse(null);
        } else if (input.getDeliveryaddress() != null){
            address = customerService.createAddress(
                    input.getDeliveryaddress());
        } if (address == null) return null;

        Order newOrder = new Order(input.getPrice(),
                address, LocalDate.now().plusDays(1));
        ORDER_DATA.add(newOrder);
        customer.addOrder(newOrder.getId());
        customerService.saveCustomer(customer);
        return newOrder;
    }
}

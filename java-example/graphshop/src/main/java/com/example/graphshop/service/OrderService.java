package com.example.graphshop.service;

import com.example.graphshop.model.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    public static final List<Adress> ADRESS_DATA = new ArrayList<>(Arrays.asList(
            new Adress("Lars Moisture Farm", "R-16",
                    "Mos Eisley", "Desertstreet", 42),
            new Adress("Alderaan Palace", "M-10",
                    "Aldera", "Palace Avenue", 1)));
    public static final List<Order> ORDER_DATA = new ArrayList<>(Arrays.asList(
            new Order(11.38f, ADRESS_DATA.get(0), LocalDate.now()),
            new Order(42.99f, ADRESS_DATA.get(1), LocalDate.now().plusDays(1))));
    public static final List<String> ORDER_IDS = new ArrayList<>(Arrays.asList(
            ORDER_DATA.get(0).getId(),
            ORDER_DATA.get(1).getId()));

    private CustomerService customerService;

    public OrderService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Order> getOrdersByIds(List<String> ids) {
        return ORDER_DATA.stream()
                .filter((o) -> ids.contains(o.getId()))
                .collect(Collectors.toList());
    }

    public Order createOrder(OrderInput input) {
        Customer customer = customerService.getCustomer(
                input.getCustomerId());
        if (customer == null) return null;
        Adress adress = null;
        if (input.getDeliveryadressId() != null) {
            adress = customer.getAdresses()
                    .stream()
                    .filter(a -> a.getId().equals(
                            input.getDeliveryadressId()))
                    .findFirst().orElse(null);
        } else if (input.getDeliveryadress() != null){
            adress = customerService.createAdress(
                    input.getDeliveryadress());
        } if (adress == null) return null;
        Order newOrder = new Order(input.getPrice(),
                adress, LocalDate.now().plusDays(1));
        ORDER_DATA.add(newOrder);
        customer.addOrder(newOrder.getId());
        customerService.saveCustomer(customer);
        return newOrder;
    }
}

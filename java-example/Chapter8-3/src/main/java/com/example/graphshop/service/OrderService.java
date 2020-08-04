package com.example.graphshop.service;

import com.example.graphshop.model.Address;
import com.example.graphshop.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    public static final List<Address> ADDRESS_DATA =
            new ArrayList<>(Arrays.asList(
                    new Address("Lars Moisture Farm"),
                    new Address("Alderaan Palace")));
    public static final List<Order> ORDER_DATA =
            new ArrayList<>(Arrays.asList(
                    new Order(11.38f, ADDRESS_DATA.get(0)),
                    new Order(42.99f, ADDRESS_DATA.get(1))));
    public static final List<String> ORDER_IDS =
            new ArrayList<>(Arrays.asList(
                    ORDER_DATA.get(0).getId(),
                    ORDER_DATA.get(1).getId()));

    public List<Order> getOrdersByIds(List<String> ids) {
        return ORDER_DATA.stream()
                .filter((o) -> ids.contains(o.getId()))
                .collect(Collectors.toList());
    }
}

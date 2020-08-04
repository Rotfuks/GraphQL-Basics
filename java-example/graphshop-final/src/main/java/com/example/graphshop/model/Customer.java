package com.example.graphshop.model;

import com.example.graphshop.utils.UUID;

import java.util.List;

public class Customer implements Node {
    private String id;
    private String firstname;
    private String lastname;
    private List<Address> addresses;
    private List<String> orderIds;

    public Customer(String firstname, String lastname,
                    List<Address> addresses,
                    List<String> orderIds) {
        this.id = UUID.getId();
        this.firstname = firstname;
        this.lastname = lastname;
        this.addresses = addresses;
        this.orderIds = orderIds;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<String> getOrderIds() {
        return orderIds;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void addOrder(String orderId) {
        this.orderIds.add(orderId);
    }
}
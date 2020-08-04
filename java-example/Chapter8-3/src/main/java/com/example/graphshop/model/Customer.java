package com.example.graphshop.model;

import java.util.List;
import com.example.graphshop.utils.UUID;

public class Customer implements Node {
    private String id;
    private String firstname;
    private String lastname;
    private List<Address> addresses;
    private List<String> orderIds;

    public Customer (String firstname, String lastname,
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
}
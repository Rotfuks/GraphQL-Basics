package com.example.graphshop.model;

import java.util.*;

public class Customer implements Node {
    private String id;
    private String firstname;
    private String lastname;
    private List<Adress> adresses;
    private List<String> orderIds;

    public Customer (String firstname, String lastname,
                     List<Adress> adresses,
                     List<String> orderIds) {
        this.id = UUID.randomUUID().toString();
        this.firstname = firstname;
        this.lastname = lastname;
        this.adresses = adresses;
        this.orderIds = orderIds;
        System.out.println("### Created Customer with Id: " + this.id);
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
    public List<Adress> getAdresses() { return adresses; }
    public List<String> getOrderIds() {
        return orderIds;
    }

    public void setAdresses(List<Adress> adresses) {
        this.adresses = adresses;
    }
    public void addOrder(String orderId) { this.orderIds.add(orderId); }
}

package com.example.graphshop.model;

import com.example.graphshop.utils.UUID;

public class Order implements Node {
    private String id;
    private Address deliveryaddress;
    private float price;

    public Order (float price, Address deliveryaddress) {
        this.id = UUID.getId();
        this.price = price;
        this.deliveryaddress = deliveryaddress;
    }
    public String getId() {
        return id;
    }
    public Address getDeliveryaddress() {
        return deliveryaddress;
    }
    public float getPrice() {
        return price;
    }
}
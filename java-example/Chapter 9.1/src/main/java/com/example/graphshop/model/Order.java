package com.example.graphshop.model;

import com.example.graphshop.utils.UUID;

import java.time.LocalDate;

public class Order implements Node {
    private String id;
    private Address deliveryaddress;
    private float price;
    private LocalDate deliverydate;

    public Order (float price, Address deliveryaddress, LocalDate deliverydate) {
        this.id = UUID.getId();
        this.price = price;
        this.deliveryaddress = deliveryaddress;
        this.deliverydate = deliverydate;
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
    public LocalDate getDeliverydate() {
        return deliverydate;
    }

}
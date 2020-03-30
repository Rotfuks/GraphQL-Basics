package com.example.graphshop.model;

public class OrderInput {
    private String customerId;
    private float price;
    private String deliveryadressId;
    private AdressInput deliveryadress;

    public OrderInput(String customerId,
                      float price,
                      String deliveryadressId,
                      AdressInput deliveryadress) {
        this.customerId = customerId;
        this.price = price;
        this.deliveryadressId = deliveryadressId;
        this.deliveryadress = deliveryadress;
    }

    public String getCustomerId() {
        return customerId;
    }
    public float getPrice() {
        return price;
    }
    public String getDeliveryadressId() {
        return deliveryadressId;
    }
    public AdressInput getDeliveryadress() {
        return deliveryadress;
    }
}

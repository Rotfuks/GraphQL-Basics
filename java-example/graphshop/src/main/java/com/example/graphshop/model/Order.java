package com.example.graphshop.model;
import java.time.LocalDate;
import java.util.UUID;

public class Order implements Node {
    private String id;
    private Adress deliveryadress;
    private float price;
    private LocalDate deliverydate;

    public Order (float price, Adress deliveryadress, LocalDate deliverydate) {
        this.id = UUID.randomUUID().toString();
        this.price = price;
        this.deliveryadress = deliveryadress;
        this.deliverydate = deliverydate;
    }
    public String getId() {
        return id;
    }
    public Adress getDeliveryadress() {
        return deliveryadress;
    }
    public float getPrice() {
        return price;
    }
    public LocalDate getDeliverydate() { return deliverydate; }
}

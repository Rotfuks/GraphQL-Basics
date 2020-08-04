package com.example.graphshop.model;

public class OrderInput {
    private String customerId;
    private float price;
    private String deliveryaddressId;
    private AddressInput deliveryaddress;

    public OrderInput(String customerId,
                      float price,
                      String deliveryaddressId,
                      AddressInput deliveryaddress) {
        this.customerId = customerId;
        this.price = price;
        this.deliveryaddressId = deliveryaddressId;
        this.deliveryaddress = deliveryaddress;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDeliveryaddressId() {
        return deliveryaddressId;
    }

    public void setDeliveryaddressId(String deliveryaddressId) {
        this.deliveryaddressId = deliveryaddressId;
    }

    public AddressInput getDeliveryaddress() {
        return deliveryaddress;
    }

    public void setDeliveryaddress(AddressInput deliveryaddress) {
        this.deliveryaddress = deliveryaddress;
    }
}

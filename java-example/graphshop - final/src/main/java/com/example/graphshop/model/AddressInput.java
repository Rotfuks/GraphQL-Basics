package com.example.graphshop.model;

public class AddressInput {
    private String customerId;
    private String receiver;

    public AddressInput(String customerId, String receiver) {
        this.customerId = customerId;
        this.receiver = receiver;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getReceiver() {
        return receiver;
    }
}
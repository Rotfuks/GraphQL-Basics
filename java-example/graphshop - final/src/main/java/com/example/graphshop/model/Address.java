package com.example.graphshop.model;

import com.example.graphshop.utils.UUID;

public class Address implements Node {
    private String id;
    private String receiver;

    public Address(String receiver) {
        this.id = UUID.getId();
        this.receiver = receiver;
    }

    public String getId() {
        return this.id;
    }

    public String getReceiver() {
        return this.receiver;
    }
}
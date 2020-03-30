package com.example.graphshop.model;

public class AdressInput {
    private String customerId;
    private String receiver;
    private String zipcode;
    private String cityname;
    private String streetname;
    private int housenumber;

    public AdressInput(String customerId, String receiver,
                       String zipcode, String cityname,
                       String streetname, int housenumber) {
        this.customerId = customerId;
        this.receiver = receiver;
        this.zipcode = zipcode;
        this.cityname = cityname;
        this.streetname = streetname;
        this.housenumber = housenumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCityname() {
        return cityname;
    }

    public String getStreetname() {
        return streetname;
    }

    public int getHousenumber() {
        return housenumber;
    }
}

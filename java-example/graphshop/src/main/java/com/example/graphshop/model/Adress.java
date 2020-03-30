package com.example.graphshop.model;

import java.util.UUID;

public class Adress implements Node{
    private String id;
    private String receiver;
    private String zipcode;
    private String cityname;
    private String streetname;
    private int housenumber;

    public Adress(String receiver, String zipcode, String cityname,
                  String streetname, int housenumber) {
        this.id = UUID.randomUUID().toString();
        this.receiver = receiver;
        this.zipcode = zipcode;
        this.cityname = cityname;
        this.streetname = streetname;
        this.housenumber = housenumber;
    }
    public String getId() { return this.id; }
    public String getReceiver() { return this.receiver; }
    public String getZipcode() { return zipcode; }
    public String getCityname() { return cityname; }
    public String getStreetname() { return streetname; }
    public int getHousenumber() { return housenumber; }
}

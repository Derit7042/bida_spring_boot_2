package com.busan.domain;

public class Restaurant {

    private String address;
    private String name;

    public Restaurant(String name) {
        this.name = name;
    }

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;

    }

    public String getName() {
        return name;
    }
    public String getInformation() {
        return name + " in " + address;
    }

    public String getAddress() {
        return address;
    }
}
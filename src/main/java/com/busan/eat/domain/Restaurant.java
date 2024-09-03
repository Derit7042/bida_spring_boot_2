package com.busan.eat.domain;

public class Restaurant {

    private Long id;
    private String address;
    private String name;

    public Restaurant(Long id, String name, String address) {
        this.id = id;
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

    public Long getId() {
        return id;
    }
}
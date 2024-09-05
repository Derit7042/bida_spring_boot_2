package com.busan.eat.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;
    private String address;
    private String name;
    @Transient
    private List<MenuItem> menuItems = new ArrayList<>();
    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public Restaurant(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Restaurant() {

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

    public void addMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }

    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItem) {
        for(MenuItem menuitem : menuItems) {
            addMenuItem(menuitem);
        }
    }

    public void setId(Long id) {
        this.id = id;
    }
}
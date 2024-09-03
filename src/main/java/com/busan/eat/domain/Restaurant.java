package com.busan.eat.domain;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private Long id;
    private String address;
    private String name;
    private List<MenuItem> menuItems = new ArrayList<>();
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
}
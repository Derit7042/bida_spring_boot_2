package com.busan.eat.domain;

import com.busan.eat.interfaces.MenuItemRepository;

import java.util.ArrayList;
import java.util.List;

public class MenuItemRepositoryImpl implements MenuItemRepository {
    private List<MenuItem> menuItems = new ArrayList<>();

    public MenuItemRepositoryImpl() {
        this.menuItems.add(new MenuItem("Kimchi"));
    }

    @Override
    public List<MenuItem> findAllByRestaurantId(Long id) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Kimchi"));
        return menuItems;
    }
}

package com.busan.eat.interfaces;

import com.busan.eat.domain.MenuItem;
import com.busan.eat.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository repository;
    @Autowired
    private MenuItemRepository menuItemRepository;

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = repository.findAll();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable Long id) {
        Restaurant restaurant = repository.findById(id);
        List<MenuItem> menuItem = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItem);
        return restaurant;
    }
}
package com.busan.eat.interfaces;

import com.busan.eat.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {
    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = new Restaurant(1000L, "Bob zip", "Busan");
        restaurants.add(restaurant);
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable Long id) {
        Restaurant restaurant = null;
//        if (id == 1001) restaurant = new Restaurant(id, "Bob zip", "Busan");
//        if (id == 2002) restaurant = new Restaurant(id, "Cyber Food", "Busan");
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1001L, "Bob zip", "Busan"));
        restaurants.add(new Restaurant(2002L, "Cyber Food", "Busan"));
        restaurant = (Restaurant) restaurants.stream()
                .filter((r) -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
        return restaurant;
    }
}
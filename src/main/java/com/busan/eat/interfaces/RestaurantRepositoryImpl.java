package com.busan.eat.interfaces;

import com.busan.eat.domain.Restaurant;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @Override
    public List<Restaurant> findAll() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1001L, "Bob zip", "Busan"));
        restaurants.add(new Restaurant(2002L, "Cyber Food", "Busan"));
        return restaurants;
    }

    @Override
    public Restaurant findById(Long id) {
        List<Restaurant> restaurants = findAll();
        return (Restaurant) restaurants.stream()
                .filter((r) -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}

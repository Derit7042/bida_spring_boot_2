package com.busan.eat.interfaces;

import com.busan.eat.domain.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    List<Restaurant> findAll();
    Restaurant findById(Long id);
}

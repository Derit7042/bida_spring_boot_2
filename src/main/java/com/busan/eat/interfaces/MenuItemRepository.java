package com.busan.eat.interfaces;

import com.busan.eat.domain.MenuItem;

import java.util.List;

public interface MenuItemRepository {
    List<MenuItem> findAllByRestaurantId(Long id);
}

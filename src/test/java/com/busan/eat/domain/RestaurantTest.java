package com.busan.eat.domain;

import com.busan.eat.domain.Restaurant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
    @DisplayName("Restaurant 생성 테스트")
    @Test
    void creation() {
        Restaurant restaurant = new Restaurant(1000L, "Bob zip", "Busan");
        assertEquals(restaurant.getName(), "Bob zip");
        assertEquals(restaurant.getId(), 1000L);
        assertEquals(restaurant.getAddress(), "Busan");
    }

    @DisplayName("이름 정보 주소 테스트")
    @Test
    void information() {
        Restaurant restaurant = new Restaurant(100L, "Bob zip", "Busan");
        assertEquals(restaurant.getInformation(), "Bob zip in Busan");
    }

    @DisplayName("이름, 주소 각각 정보 테스트")
    @Test
    void address() {
        Restaurant restaurant = new Restaurant(100L, "Bob zip", "Busan");
        assertEquals(restaurant.getAddress(), "Busan");
        assertEquals(restaurant.getName(), "Bob zip");
    }
}
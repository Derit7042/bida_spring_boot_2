package com.busan.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
    @DisplayName("Restaurant 생성 테스트")
    @Test
    void creation() {
        Restaurant restaurant = new Restaurant("Bob zip");
        assertEquals(restaurant.getName(), "Bob zip");
    }

    @DisplayName("이름 정보 주소 테스트")
    @Test
    void information() {
        Restaurant restaurant = new Restaurant("Bob zip", "Busan");
        assertEquals(restaurant.getInformation(), "Bob zip in Busan");
    }

    @DisplayName("이름, 주소 각각 정보 테스트")
    @Test
    void address() {
        Restaurant restaurant = new Restaurant("Bob zip", "Busan");
        assertEquals(restaurant.getAddress(), "Busan");
        assertEquals(restaurant.getName(), "Bob zip");
    }
}
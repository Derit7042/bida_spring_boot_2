package com.busan.eat.application;

import com.busan.eat.domain.MenuItem;
import com.busan.eat.domain.Restaurant;
import com.busan.eat.interfaces.MenuItemRepository;
import com.busan.eat.interfaces.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

class RestaurantServiceTest {

//    @SpyBean(RestaurantRepositoryImpl.class)
    private RestaurantService restaurantService;
    private RestaurantRepository restaurantRepository;
    private MenuItemRepository MenuItemRepository;

    @BeforeEach
    public void setUp() {
//        restaurantRepository = new RestaurantRepositoryImpl();
//        MenuItemRepository = new MenuItemRepositoryImpl();
        MockitoAnnotations.openMocks(this);

        List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = new Restaurant(1001L, "Bob zip", "Seoul");
        restaurants.add(restaurant);
        given(restaurantRepository.findAll()).willReturn(restaurants);
        given(restaurantRepository.findById(1001L)).willReturn(Optional.of(restaurant));
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Kimchi"));
        given(MenuItemRepository.findAllByRestaurantId(1001L)).willReturn(menuItems);

        restaurantService = new RestaurantService(restaurantRepository, MenuItemRepository);
    }

    @DisplayName("레스토랑 정보 가져오기")
    @Test
    void getRestaurant() {
        Restaurant restaurant = restaurantService.getRestaurant(1001L);
        assertEquals(restaurant.getId(), 1001L);
    }

    @DisplayName("서비스에서 레스토랑 목록 정보 가져오기 테스트")
    @Test
    void getRestaurants() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        Restaurant restaurant = restaurants.get(0);
        assertEquals(restaurant.getId(), 1001L);
    }

    @DisplayName("서비스에서 레스토랑 정보 추가")
    @Test
    void addRestaurant() {
        Restaurant restaurant = new Restaurant(1234L, "BeRyong", "Busan");
        Restaurant saved = new Restaurant(1234L, "BeRyong", "Busan");
        given(restaurantRepository.save(any())).willReturn(saved);
        Restaurant create = restaurantService.addRestaurant(restaurant);
        assertEquals(create.getId(), 1234L);
    }

    @DisplayName("서비스에서 레스토랑 정보 수정 테스트")
    @Test
    void updateRestaurant() {
        Restaurant restaurant = restaurantService.getRestaurant(1001L, "Bob zip", "Busan");
        Restaurant update = restaurantService.updateRestaurant(1001L, "Sool zip", "Busan");
        assertEquals(update.getName(), "Sool zip");
    }
}
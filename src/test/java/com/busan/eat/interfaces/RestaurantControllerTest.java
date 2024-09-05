package com.busan.eat.interfaces;

import com.busan.eat.application.RestaurantService;
import com.busan.eat.domain.Restaurant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = RestaurantController.class)
class RestaurantControllerTest {
    @Autowired
    private MockMvc mvc;

//    @SpyBean(RestaurantRepositoryImpl.class)
//    private RestaurantRepository restaurantRepository;
//    @SpyBean(MenuItemRepositoryImpl.class)
//    private MenuItemRepository menuItemRepository;
//    @SpyBean(RestaurantService.class)
//    private RestaurantService restaurantService;
    @MockBean
    private RestaurantService restaurantService;

    @DisplayName("레스토랑 정보 조회 (목록")
    @Test
    void list() throws Exception {
        mvc.perform(get("/restaurants"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"Bob zip\"")))
                .andExpect(content().string(containsString("\"id\":1001")));
    }

    @DisplayName("레스토랑 상세 정보 조회 (단건)")
    @Test
    void detail() throws Exception {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1001L, "Bob zip", "Seoul"));
        given(restaurantService.getRestaurants()).willReturn(restaurants);
        mvc.perform(get("/restaurants"))
                        .andExpect(status().isOk())
                                .andExpect(content().string(containsString("\"name\":\"Bob zip\"")))
                                .andExpect(content().string(containsString("\"id\":1001")));

//        mvc.perform(get("/restaurants/1001"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("\"id\":1001")))
//                .andExpect(content().string(containsString("\"name\":\"Bob zip\"")))
//                .andExpect(content().string(containsString("Kimchi")));
//        mvc.perform(get("/restaurants/2002"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("\"id\":2002")))
//                .andExpect(content().string(containsString("\"name\":\"Cyber Food\"")));
    }

    @DisplayName("레스토랑 정보 등록 테스트")
    @Test
    void create() throws Exception {
        Restaurant restaurant = new Restaurant(1234L, "BeRyong", "Busan");
        restaurantService.addRestaurant(restaurant);
        mvc.perform(post("/restaurants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"BeRyong\", \"address\": \"Busan\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/restaurants/1234"))
                .andExpect(content().string("{}"));
        verify(restaurantService).addRestaurant(any());
    }

    @DisplayName("레스토랑 정보 수정 테스트")
    @Test
    void updatePatch() throws Exception {
        mvc.perform(patch("/restaurants/1001")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Bob zip\", \"address\": \"Busan\"}"))
                .andExpect(status().isOk());
        //verify(restaurantService).updateRestaurant(1001L, "Joker bar", "Busan");
    }
}
package com.busan.eat.interfaces;

import com.busan.eat.interfaces.RestaurantController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = RestaurantController.class)
class RestaurantControllerTest {
    @Autowired
    private MockMvc mvc;

    @SpyBean(RestaurantRepositoryImpl.class)
    private RestaurantRepository restaurantRepository;

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
        mvc.perform(get("/restaurants/1001"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":1001")))
                .andExpect(content().string(containsString("\"name\":\"Bob zip\"")))
                .andExpect(content().string(containsString("Kimchi")));
        mvc.perform(get("/restaurants/2002"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":2002")))
                .andExpect(content().string(containsString("\"name\":\"Cyber Food\"")));
    }
}
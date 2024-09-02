package com.busan.eat.interfaces;

import com.busan.eat.interfaces.RestaurantController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = RestaurantController.class)
class RestaurantControllerTest {

    @DisplayName("레스토랑 정보 조회 (목록")
    @Test
    void list() {
        RestaurantController restaurantController = new RestaurantController();
    }
}
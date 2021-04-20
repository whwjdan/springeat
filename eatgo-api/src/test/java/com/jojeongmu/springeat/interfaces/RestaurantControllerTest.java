package com.jojeongmu.springeat.interfaces;

import com.jojeongmu.springeat.application.RestaurantService;
import com.jojeongmu.springeat.domain.MenuItemRepository;
import com.jojeongmu.springeat.domain.MenuItemRepositoryImpl;
import com.jojeongmu.springeat.domain.RestaurantRepository;
import com.jojeongmu.springeat.domain.RestaurantRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;

    @SpyBean(RestaurantRepositoryImpl.class)
    // 어떤 구현체를 사용할 것인지 명시
    private RestaurantRepository restaurantRepository;

    @SpyBean(MenuItemRepositoryImpl.class)
    private MenuItemRepository menuItemRepository;

    @SpyBean(RestaurantService.class)
    private RestaurantService restaurantService;

    @Test
    public void list() throws Exception {
        mvc.perform(get("/restaurant"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"id\":1004")
                ))
                .andExpect(content().string(containsString("\"name\":\"Bob zip\"")));
    }

    @Test
    public void detail() throws Exception{
        mvc.perform(get("/restaurant/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"id\":1004")
                ))
                .andExpect(content().string(containsString("\"name\":\"Bob zip\"")))
                .andExpect(content().string(containsString("Kimchi")
                ));

        mvc.perform(get("/restaurant/2020"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"id\":2020")
                ))
                .andExpect(content().string(containsString("\"name\":\"Cyber Food\"")
                ));
    }
}
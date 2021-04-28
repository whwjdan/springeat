package com.jojeongmu.springeat.application;

import com.jojeongmu.springeat.domain.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

public class RestaurantServiceTest {


    private RestaurantService restaurantService;

    @Mock
    private RestaurantRepository restaurantRepository;

    @Mock
    private MenuItemRepository menuItemRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);

        mockRestaurantRepository();
        mockMenuItemRepository();

        restaurantService = new RestaurantService(
                restaurantRepository, menuItemRepository);
    }

    private void mockMenuItemRepository() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Kimchi"));
        given(menuItemRepository.findAllByRestaurantId(1004L))
                .willReturn(menuItems);
    }

    private void mockRestaurantRepository() {
        List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();

        restaurants.add(restaurant);
        given(restaurantRepository.findAll()).willReturn(restaurants);

        given(restaurantRepository.findById(1004L)).willReturn(Optional.of(restaurant));

    }

    @Test
    public void getRestaurants(){
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        Restaurant restaurant = restaurants.get(0);
        assertThat(restaurant.getId()).isEqualTo(1004L);
    }

    @Test
    public void getRestaurant(){
        Restaurant restaurant = restaurantService.getRestaurant(1004L);

        assertThat(restaurant.getId()).isEqualTo(1004L);

        MenuItem menuItem = restaurant.getMenuItems().get(0);

        assertThat(menuItem.getName()).isEqualTo("Kimchi");
    }

    @Test
    public void addRestaurant(){

        given(restaurantRepository.save(any())).will(invocation -> {
            Restaurant restaurant1 = invocation.getArgument(0);
            restaurant1.setId(1234L);
            return restaurant1;
        });

        Restaurant restaurant = Restaurant.builder()
                .name("BeRyong")
                .address("Busan")
                .build();

        Restaurant saved = Restaurant.builder()
                .id(1234L)
                .name("BeRyong")
                .address("Busan")
                .build();


        Restaurant created = restaurantService.addRestaurant(restaurant);

        assertThat(created.getId()).isEqualTo(1234L);
    }

    @Test
    public void updateRestaurant(){
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();


        given(restaurantRepository.findById(1004L))
                .willReturn(Optional.of(restaurant));

        Restaurant updated = restaurantService.updateRestaurant(
                1004L,"Sool zip", "Busan");

        assertThat(restaurant.getName()).isEqualTo("Sool zip");
        assertThat(restaurant.getAddress()).isEqualTo("Busan");
    }
}
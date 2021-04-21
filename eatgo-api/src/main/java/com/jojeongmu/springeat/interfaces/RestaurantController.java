package com.jojeongmu.springeat.interfaces;

import com.jojeongmu.springeat.application.RestaurantService;
import com.jojeongmu.springeat.domain.MenuItem;
import com.jojeongmu.springeat.domain.MenuItemRepository;
import com.jojeongmu.springeat.domain.Restaurant;
import com.jojeongmu.springeat.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurant")
    public List<Restaurant> list(){
/*
        List<Restaurant> restaurants = new ArrayList<>();

        restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
*/

        List<Restaurant> restaurants = restaurantService.getRestaurants();

        return restaurants;
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {

        Restaurant restaurant = restaurantService.getRestaurant(id);
        // 기본 정보 + 메뉴 정보

        return restaurant;
    }

    @PostMapping("/restaurant")
    public ResponseEntity<?> create() throws URISyntaxException {
        Restaurant restaurant = new Restaurant(1234L, "BeRyong","Busan");
        restaurantService.addRestaurant(restaurant);

        URI location = new URI("/restaurant/1234");
        return ResponseEntity.created(location).body("{}");
    }
}

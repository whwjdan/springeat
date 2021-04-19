package com.jojeongmu.springeat.interfaces;

import com.jojeongmu.springeat.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

    @GetMapping("/restaurant")
    public List<Restaurant> list(){
        List<Restaurant> restaurants = new ArrayList<>();
        return restaurants;
    }
}
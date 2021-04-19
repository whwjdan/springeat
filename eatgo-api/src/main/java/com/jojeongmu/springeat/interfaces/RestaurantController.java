package com.jojeongmu.springeat.interfaces;

import com.jojeongmu.springeat.domain.Restaurant;
import com.jojeongmu.springeat.domain.RestaurantRepository;
import com.jojeongmu.springeat.domain.RestaurantRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository repository;

    @GetMapping("/restaurant")
    public List<Restaurant> list(){
/*
        List<Restaurant> restaurants = new ArrayList<>();

        restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
*/

        List<Restaurant> restaurants = repository.findAll();

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        Restaurant restaurants = repository.findById(id);

        return restaurants;
    }
}

package com.jojeongmu.springeat.domain;

import org.springframework.stereotype.Component;

import java.util.List;


public interface RestaurantRepository {
    List<Restaurant> findAll();

    Restaurant findById(Long id);

    Restaurant save(Restaurant restaurant);
}

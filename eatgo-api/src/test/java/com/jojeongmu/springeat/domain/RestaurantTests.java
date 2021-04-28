package com.jojeongmu.springeat.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantTests {

    @Test
    public void creation(){
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();
        assertThat(restaurant.getName()).isEqualTo("Bob zip");
    }

    @Test
    public void information(){
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();

        assertThat(restaurant.getInformation()).isEqualTo("Bob zip in Seoul");
    }
}
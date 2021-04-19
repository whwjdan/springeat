package com.jojeongmu.springeat.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantTests {

    @Test
    public void creation(){
        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Seoul");
        assertThat(restaurant.getName()).isEqualTo("Bob zip");
    }

    @Test
    public void information(){
        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Seoul");

        assertThat(restaurant.getInformation()).isEqualTo("Bob zip in Seoul");
    }
}
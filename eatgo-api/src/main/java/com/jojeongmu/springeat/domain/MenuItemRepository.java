package com.jojeongmu.springeat.domain;


import com.jojeongmu.springeat.domain.MenuItem;
import com.jojeongmu.springeat.domain.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;


public interface MenuItemRepository {
    List<MenuItem> findAllByRestaurantId(Long restaurantId);

}

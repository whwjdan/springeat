package com.jojeongmu.springeat.application;

import com.jojeongmu.springeat.domain.MenuItem;
import com.jojeongmu.springeat.domain.MenuItemRepository;
import com.jojeongmu.springeat.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    private MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository){
        this.menuItemRepository = menuItemRepository;
    }

    public MenuItemService() {

    }

    public void bulkUpdate(Long restaurantId, List<MenuItem> menuItems){
        for(MenuItem menuItem : menuItems){
            menuItemRepository.save(menuItem);
        }
    }
}

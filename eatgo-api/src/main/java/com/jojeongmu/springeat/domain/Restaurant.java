package com.jojeongmu.springeat.domain;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String name;
    private String address;
    private Long id;
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();

    public Restaurant(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Restaurant() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInformation() {
        return name + " in " + address;
    }

    public List<MenuItem> getMenuItems(){

        return menuItems;
    }

    public void addMenuItem(MenuItem menuItem){

        menuItems.add(menuItem);
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        for(MenuItem menuItem : menuItems){
            addMenuItem(menuItem);
        }
    }

    public String getAddress() {
        return address;
    }
}

package com.svalero.restaurant.domain;

import java.util.ArrayList;
import java.util.List;

public class Dish {

    private int id;
    private String name;
    private String restaurant;
    private String type;
    private String price;


    private final List<Order> orders;

    public Dish() {
        orders = new ArrayList<>();
    }

    public Dish(String name, String restaurant, String type, String price) {
        this.name = name;
        this.restaurant = restaurant;
        this.type = type;
        this.price = price;
        orders = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

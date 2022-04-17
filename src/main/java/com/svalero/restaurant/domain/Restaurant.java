package com.svalero.restaurant.domain;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private int id;
    private String name;
    private String nation;
    private String stars;
    private List<Order> orders;

    public Restaurant() {
        orders = new ArrayList<>();
    }

    public Restaurant(String name, String nation, String stars) {
        this.name = name;
        this.nation = nation;
        this.stars = stars;
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

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

}

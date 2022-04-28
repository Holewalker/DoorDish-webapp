package com.svalero.restaurant.domain;


public class Order {

    private String id;
    private String id_dish;
    private String id_restaurant;




    public Order(String id, String id_dish, String id_restaurant) {
        this.id_dish = id_dish;
        this.id_restaurant = id_restaurant;
        this.id = id;
           }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_dish() {
        return id_dish;
    }

    public void setId_dish(String id_dish) {
        this.id_dish = id_dish;
    }

    public String getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(String id_restaurant) {
        this.id_restaurant = id_restaurant;
    }}

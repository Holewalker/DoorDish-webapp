package com.svalero.restaurant.domain;


public class Order {

    private String id;
    private String idDish;
    private String idRestaurant;




    public Order(String id, String idDish, String idRestaurant) {
        this.idDish = idDish;
        this.idRestaurant = idRestaurant;
        this.id = id;
           }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdDish() {
        return idDish;
    }

    public void setIdDish(String idDish) {
        this.idDish = idDish;
    }

    public String getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(String idRestaurant) {
        this.idRestaurant = idRestaurant;
    }}

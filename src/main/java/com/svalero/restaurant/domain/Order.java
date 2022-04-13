package com.svalero.restaurant.domain;

import com.svalero.restaurant.util.DateUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private String code;
    private boolean paid;
    private LocalDate date;
    private User user;
    private List<Dish> dishes;

    public Order() {
        dishes = new ArrayList<>();
    }

    public Order(String code, boolean paid, LocalDate date, User user) {
        this.code = code;
        this.paid = paid;
        this.date = date;
        this.user = user;
        dishes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}

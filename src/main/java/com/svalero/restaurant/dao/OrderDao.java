package com.svalero.restaurant.dao;

import com.svalero.restaurant.domain.Dish;
import com.svalero.restaurant.domain.Restaurant;
import com.svalero.restaurant.domain.User;


import java.sql.*;


public class OrderDao {

    private Connection connection;

    public OrderDao(Connection connection) {
        this.connection = connection;
    }

    public void addOrder(User user, Dish dish, Restaurant restaurant) throws SQLException {
        String orderSql = "INSERT INTO orders (ID_DSH, ID_USER, ID_RESTAURANT) VALUES (?, ?, ?)";

        connection.setAutoCommit(false);

        try (PreparedStatement orderStatement = connection.prepareStatement(orderSql,
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            orderStatement.setString(1, String.valueOf(dish.getId()));
            orderStatement.setString(2, String.valueOf(user.getId()));
            orderStatement.setString(3, String.valueOf(restaurant.getId()));
            orderStatement.executeUpdate();

        }

        connection.commit();
        connection.setAutoCommit(true);
    }


}

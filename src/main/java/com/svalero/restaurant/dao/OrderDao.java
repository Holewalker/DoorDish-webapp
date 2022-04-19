package com.svalero.restaurant.dao;

import com.svalero.restaurant.domain.Dish;
import com.svalero.restaurant.domain.Order;
import com.svalero.restaurant.domain.User;
import com.svalero.restaurant.util.DateUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderDao {

    private Connection connection;

    public OrderDao(Connection connection) {
        this.connection = connection;
    }

    public void addOrder(User user, List<Dish> dishes) throws SQLException {
        String orderSql = "INSERT INTO orders (code, user_id, date) VALUES (?, ?, ?)";

        connection.setAutoCommit(false);

        try (PreparedStatement orderStatement = connection.prepareStatement(orderSql,
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            orderStatement.setString(1, UUID.randomUUID().toString());
            orderStatement.setInt(2, user.getId());
            orderStatement.setDate(3, new Date(System.currentTimeMillis()));
            orderStatement.executeUpdate();

            // Obtener el orderId generado en la sentencia anterior (el último AUTO_INCREMENT generado)
            ResultSet orderKeys = orderStatement.getGeneratedKeys();
            orderKeys.next();
            int orderId = orderKeys.getInt(1);
            orderStatement.close();

            for (Dish dish : dishes) {
                String dishSql = "INSERT INTO order_dish (order_id, book_id) VALUES (?, ?)";

                try (PreparedStatement dishStatement = connection.prepareStatement(dishSql)) {
                    dishStatement.setInt(1, orderId);
                    dishStatement.setInt(2, dish.getId());
                    dishStatement.executeUpdate();
                }
            }
        }

        connection.commit();
        connection.setAutoCommit(true);
    }

    public Order getOrder() {
        return null;
    }

    public void payOrder() {

    }

    public List<Order> getOrdersBetweenDates(LocalDate fromDate, LocalDate toDate) throws SQLException {
        String sql = "SELECT * FROM orders WHERE date BETWEEN ? AND ?";
        List<Order> orders = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, DateUtils.toSqlDate(fromDate));
            statement.setDate(2, DateUtils.toSqlDate(toDate));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt(1));
                order.setCode(resultSet.getString(2));
                order.setPaid(resultSet.getBoolean(3));
                order.setDate(DateUtils.toLocalDate(resultSet.getDate(4)));
                orders.add(order);
            }
        }
        return orders;
    }


}

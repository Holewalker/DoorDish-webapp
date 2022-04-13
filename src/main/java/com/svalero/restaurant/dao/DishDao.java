package com.svalero.restaurant.dao;

import com.svalero.restaurant.domain.Dish;
import com.svalero.restaurant.exception.DishAlreadyExistException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class DishDao {

    private Connection connection;

    public DishDao(Connection connection) {
        this.connection = connection;
    }

    public void add(Dish dish) throws SQLException, DishAlreadyExistException {
        if (existBook(dish.getTitle()))
            throw new DishAlreadyExistException();

        String sql = "INSERT INTO dishes (title, author, publisher) VALUES (?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dish.getTitle());
        statement.setString(2, dish.getAuthor());
        statement.setString(3, dish.getPublisher());
        statement.executeUpdate();
    }

    public boolean delete(String title) throws SQLException {
        String sql = "DELETE FROM dishes WHERE title = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, title);
        int rows = statement.executeUpdate();

        return rows == 1;
    }

    public boolean modify(String title, Dish dish) throws SQLException {
        String sql = "UPDATE dishes SET title = ?, author = ?, publisher = ? WHERE title = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dish.getTitle());
        statement.setString(2, dish.getAuthor());
        statement.setString(3, dish.getPublisher());
        statement.setString(4, title);
        int rows = statement.executeUpdate();
        return rows == 1;
    }

    public ArrayList<Dish> findAll() throws SQLException {
        String sql = "SELECT * FROM dishes ORDER BY title";
        ArrayList<Dish> dishes = new ArrayList<>();

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Dish dish = new Dish();
            dish.setTitle(resultSet.getString("title"));
            dish.setAuthor(resultSet.getString("author"));
            dish.setPublisher(resultSet.getString("publisher"));
            dishes.add(dish);
        }

        return dishes;
    }

    public Optional<Dish> findByTitle(String title) throws SQLException {
        String sql = "SELECT * FROM dishes WHERE title = ?";
        Dish dish = null;

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, title);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            dish = new Dish();
            dish.setId(resultSet.getInt("id"));
            dish.setTitle(resultSet.getString("title"));
            dish.setAuthor(resultSet.getString("author"));
            dish.setPublisher(resultSet.getString("publisher"));
        }

        return Optional.ofNullable(dish);
    }

    private boolean existBook(String title) throws SQLException {
        Optional<Dish> book = findByTitle(title);
        return book.isPresent();
    }
}

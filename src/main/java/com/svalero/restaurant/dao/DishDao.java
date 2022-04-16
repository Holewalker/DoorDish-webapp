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
        if (existBook(dish.getName()))
            throw new DishAlreadyExistException();

        String sql = "INSERT INTO dishes (Dname, id_restaurant, dtype, price) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dish.getName());
        statement.setString(2, dish.getRestaurant());
        statement.setString(3, dish.getType());
        statement.setString(4, dish.getPrice());
        statement.executeUpdate();
    }

    public boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM dishes WHERE ID_dish = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        int rows = statement.executeUpdate();

        return rows == 1;
    }

    public boolean modify(String name, Dish dish) throws SQLException {
        String sql = "UPDATE dishes SET Dname = ?, id_restaurant = ?, dtype = ? , price ? WHERE Dname = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dish.getName());
        statement.setString(2, dish.getRestaurant());
        statement.setString(3, dish.getType());
        statement.setString(4, dish.getPrice());
        statement.setString(5, name);
        int rows = statement.executeUpdate();
        return rows == 1;
    }

    public ArrayList<Dish> findAll() throws SQLException {
        String sql = "SELECT * FROM dishes ORDER BY Dname";
        ArrayList<Dish> dishes = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Dish dish = new Dish();
            dish.setId(resultSet.getInt("id_dish"));
            dish.setName(resultSet.getString("Dname"));
            dish.setRestaurant(resultSet.getString("id_restaurant"));
            dish.setType(resultSet.getString("dtype"));
            dish.setPrice(resultSet.getString("price"));
            dishes.add(dish);
        }

        return dishes;
    }

    public ArrayList<Dish> findAll(String searchText) throws SQLException {
        String sql = "SELECT * FROM dishes WHERE UPPER(dname) LIKE UPPER(?) ORDER BY dname";

        ArrayList<Dish> dishes = new ArrayList<>();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%"+searchText+"%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Dish dish = fromResultSet(resultSet);
            dishes.add(dish);
        }

        return dishes;
    }

    public Optional<Dish> findByName(String name) throws SQLException {
        String sql = "SELECT * FROM dishes WHERE Dname = ?";
        Dish dish = null;

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            dish = new Dish();

            dish.setName(resultSet.getString("Dname"));
            dish.setRestaurant(resultSet.getString("id_restaurant"));
            dish.setType(resultSet.getString("dtype"));
            dish.setPrice(resultSet.getString("price"));
        }

        return Optional.ofNullable(dish);
    }

    public Optional<Dish> findById(int id) throws SQLException {
        String sql = "SELECT * FROM dishes WHERE id_dish = ?";
        Dish dish = null;

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            dish = fromResultSet(resultSet);
        }

        return Optional.ofNullable(dish);
    }

    private Dish fromResultSet(ResultSet resultSet) throws SQLException {
        Dish dish = new Dish();
                dish.setName(resultSet.getString("Dname"));
        dish.setRestaurant(resultSet.getString("id_restaurant"));
        dish.setType(resultSet.getString("dtype"));
        dish.setPrice(resultSet.getString("price"));
        return dish;
    }

    private boolean existBook(String name) throws SQLException {
        Optional<Dish> book = findByName(name);
        return book.isPresent();
    }
}

package com.svalero.restaurant.dao;

import com.svalero.restaurant.domain.Dish;
import com.svalero.restaurant.domain.Restaurant;
import com.svalero.restaurant.exception.RestaurantAlreadyExistException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class RestaurantDao {

    private final Connection connection;

    public RestaurantDao(Connection connection) {
        this.connection = connection;
    }

    public void add(Restaurant restaurant) throws SQLException, RestaurantAlreadyExistException {
        if (existRestaurant(restaurant.getName()))
            throw new RestaurantAlreadyExistException();

        String sql = "INSERT INTO restaurants (name, Nation, stars) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, restaurant.getName());
            statement.setString(2, restaurant.getNation());
            statement.setString(3, restaurant.getStars());
            statement.executeUpdate();
        }
    }

    public boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM restaurant WHERE ID_restaurant = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            int rows = statement.executeUpdate();

            return rows == 1;
        }
    }

    public boolean modify(String name, Restaurant restaurant) throws SQLException {
        String sql = "UPDATE restaurant SET name = ?, nation = ?, stars = ? WHERE name = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, restaurant.getName());
            statement.setString(2, restaurant.getNation());
            statement.setString(3, restaurant.getStars());
            statement.setString(4, name);
            int rows = statement.executeUpdate();
            return rows == 1;
        }
    }

    public ArrayList<Restaurant> findAll() throws SQLException {
        String sql = "SELECT * FROM restaurants ORDER BY name";
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setId(resultSet.getInt("id_restaurant"));
                restaurant.setName(resultSet.getString("name"));
                restaurant.setNation(resultSet.getString("nation"));
                restaurant.setStars(resultSet.getString("stars"));
                restaurants.add(restaurant);
            }

            return restaurants;
        }
    }

    public ArrayList<Restaurant> findAll(String searchText) throws SQLException {
        String sql = "SELECT * FROM restaurants WHERE UPPER(name) LIKE UPPER(?) ORDER BY name";

        ArrayList<Restaurant> restaurants = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + searchText + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Restaurant restaurant = fromResultSet(resultSet);
                restaurants.add(restaurant);
            }
        }
        return restaurants;

    }

    public Optional<Restaurant> findByName(String name) throws SQLException {
        String sql = "SELECT * FROM restaurants WHERE name = ?";
        Restaurant restaurant = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                restaurant = new Restaurant();

                restaurant.setName(resultSet.getString("name"));
                restaurant.setNation(resultSet.getString("nation"));
                restaurant.setStars(resultSet.getString("stars"));
            }
        }

        return Optional.ofNullable(restaurant);
    }


    public Optional<Restaurant> findById(String id) throws SQLException {
        Restaurant restaurant = null;
        if (id == null) {
            restaurant = new Restaurant("No existe", "", "");
        return Optional.ofNullable(restaurant);
        }
        String sql = "SELECT * FROM restaurants WHERE id_restaurant = ?";
        Integer id_int = Integer.parseInt(id);



        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_int);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                restaurant = fromResultSet(resultSet);
            }
        }
        return Optional.ofNullable(restaurant);
    }

    private Restaurant fromResultSet(ResultSet resultSet) throws SQLException {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(resultSet.getString("name"));
        restaurant.setNation(resultSet.getString("nation"));
        restaurant.setStars(resultSet.getString("stars"));
        return restaurant;
    }

    private boolean existRestaurant(String name) throws SQLException {
        Optional<Restaurant> restaurant = findByName(name);
        return restaurant.isPresent();
    }
}

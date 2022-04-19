package com.svalero.restaurant.dao;

import com.svalero.restaurant.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDao {

    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }


    public void add(User user) throws SQLException {
        String sql = "INSERT INTO users (uname, username, upassword, urole) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, "USER");
            statement.executeUpdate();
        }
    }

    public Optional<User> login(String username, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ? AND upassword = ?";
        User user = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id_user"));
                user.setName(resultSet.getString("uname"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("upassword"));
                user.setRole(resultSet.getString("urole"));
            }
        }
        return Optional.ofNullable(user);
    }

}

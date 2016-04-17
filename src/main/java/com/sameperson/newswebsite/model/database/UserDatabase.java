package com.sameperson.newswebsite.model.database;

import com.sameperson.newswebsite.model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDatabase {

    private volatile static Connection connection;
    static  {
        try {
            connection = ConnectionManager.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY, username VARCHAR(255), password VARCHAR(128))");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public static void saveUser(User user) {
        String sql = "INSERT INTO users (username, password) VALUES ('%s', '%s')";
        sql = String.format(sql, user.getUsername(), user.getPassword());
        try {
            connection.createStatement().executeUpdate(sql);
            System.out.println("User " + user.getUsername() + " has been saved into database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<User> getUsers() {
        ArrayList<User> userList = new ArrayList<>();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM users");
            while(resultSet.next()) {
                userList.add(new User(resultSet.getString("username"), resultSet.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static boolean containsUser(String username) {
        for(User user : getUsers()) {
            if(user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static void printUsers() {
        ResultSet resultSet = null;
        try {
            resultSet = connection.createStatement().executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("username");
                String lastname = resultSet.getString("password");
                System.out.printf("%s %s (%d) \n", firstname, lastname, id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropTable() {
        try {
            connection.createStatement().executeUpdate("DROP TABLE users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

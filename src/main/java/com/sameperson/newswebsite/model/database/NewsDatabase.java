package com.sameperson.newswebsite.model.database;

import com.sameperson.newswebsite.model.Article;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class NewsDatabase {

    private volatile static Connection connection;
    static {
        try {
            connection = ConnectionManager.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS news (id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY, " +
                    "name VARCHAR(255), title VARCHAR(255), body CLOB)");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    public static void saveNews(Article news) {
        String sql = "INSERT INTO news (name, title, body) VALUES ('%s', '%s', '%s')";
        sql = String.format(sql, news.getName(), news.getTitle(), news.getDescription());
        try {
            connection.createStatement().executeUpdate(sql);
            System.out.println("Article \"" + news.getTitle() + "\" has been saved into database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

package com.sameperson.newswebsite.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
            Class.forName("com.sameperson.newswebsite.model.database.HibernateSessionFactoryProvider");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("The application started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("The application stopped");
    }
}
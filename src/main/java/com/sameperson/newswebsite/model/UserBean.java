package com.sameperson.newswebsite.model;

import org.apache.commons.codec.digest.DigestUtils;

import java.time.LocalDateTime;

public class UserBean {

    private String username;
    private String password;
    private LocalDateTime timeOfRegistration;

    public UserBean() {
        timeOfRegistration = LocalDateTime.now();
    }

    public UserBean(String username, String password) {
        timeOfRegistration = LocalDateTime.now();
        this.username = username;
        this.password = password;
    }

    public String getDate() {
        return String.format("%02d:%02d:%02d", timeOfRegistration.getHour(), timeOfRegistration.getMinute(),  timeOfRegistration.getSecond());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = DigestUtils.sha256Hex(password);
    }

}

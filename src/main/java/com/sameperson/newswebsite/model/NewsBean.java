package com.sameperson.newswebsite.model;

import java.time.LocalDateTime;

public class NewsBean {

    private String name;
    private String title;
    private String body;
    private LocalDateTime timeOfPublication;

    public NewsBean() {
        this.refreshTime();
    }

    public NewsBean(String name, String title, String newsBody) {
        this.refreshTime();
        this.name = name;
        this.title = title;
        this.body = newsBody;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setNewsBody(String newsBody) {
        this.body = newsBody;
    }

    public void setCurrentTime() {
        this.refreshTime();
    }

    public String getTimeOnly() {
        return String.format("%02d:%02d", timeOfPublication.getHour(), timeOfPublication.getMinute());
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void refreshTime() {
        this.timeOfPublication = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return title;
    }

}

package com.sameperson.newswebsite.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name = "rss")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(factoryClass=NewsList.class, factoryMethod="getInstance")
public class NewsList {

    private static NewsList instance;

    @XmlElementWrapper(name = "channel")
    @XmlElement(name = "item")
    private ArrayList<Article> listOfTheNews;

    public static synchronized NewsList getInstance() {
        if(instance == null) {
            instance = new NewsList();
        }
        System.out.println("Getting instance...");
        return instance;
    }

    public synchronized void addNews(String name, String title, String body) {
        listOfTheNews.add(0, new Article(name, title, body));
    }

    public synchronized void addNews(Article newsBean) {
        listOfTheNews.add(0, newsBean);
    }

    public ArrayList<Article> getList() {
        return listOfTheNews;
    }

    public Article findByName(String name) {
        for(Article newsBean : listOfTheNews) {
            if(newsBean.getName().equals(name)) {
                return newsBean;
            }
        }
        return null;
    }

    public NewsList() {
        System.out.println("Creating new news list instance!");
        listOfTheNews = new ArrayList<>();
    }
}

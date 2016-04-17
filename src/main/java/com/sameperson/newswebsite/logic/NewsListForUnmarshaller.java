package com.sameperson.newswebsite.logic;

import com.sameperson.newswebsite.model.Article;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collections;

@XmlRootElement(name = "rss")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(factoryClass=NewsListForUnmarshaller.class, factoryMethod="getInstance")
public class NewsListForUnmarshaller {

    private static NewsListForUnmarshaller instance;

    @XmlElementWrapper(name = "channel")
    @XmlElement(name = "item")
    private ArrayList<Article> listOfTheNews;

    public static synchronized NewsListForUnmarshaller getInstance() {
        if(instance == null) {
            instance = new NewsListForUnmarshaller();
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
        Collections.reverse(listOfTheNews);
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

    public NewsListForUnmarshaller() {
        System.out.println("Creating new news list instance!");
        listOfTheNews = new ArrayList<>();
    }
}

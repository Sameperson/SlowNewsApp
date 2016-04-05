package com.sameperson.newswebsite.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Article {

    private String name;
    private String title;
    private String description;
    private String pubDate;

    public Article() {
        setName();
    }

    public Article(String name, String title, String newsBody) {
        this.name = name;
        this.title = title;
        this.description = newsBody;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setNewsBody(String newsBody) {
        this.description = newsBody;
    }

    public String getPubTime() {
        return pubDate.substring(16, pubDate.length()-7);
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setName() {
        this.name = this.title;
    }

    public String getName() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }

}

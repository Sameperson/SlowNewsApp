package com.sameperson.newswebsite.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    private String title;
    @Lob
    private String description;
    private String pubDate;

    public Article() { }

    public Article(String name, String title, String newsBody) {
        this.name = name;
        this.title = title;
        this.description = newsBody;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
        this.name = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setNewsBody(String newsBody) {
        this.description = newsBody;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getPubTime() {
        return pubDate.substring(16, pubDate.length() - 7);
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }

}

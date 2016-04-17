package com.sameperson.newswebsite.logic;


import com.sameperson.newswebsite.model.NewsList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.net.MalformedURLException;
import java.net.URL;

public class NewsUnmarshaler {
    public static boolean unmarshal(NewsList newsList) {
        try {
            newsList = (NewsList) JAXBContext.newInstance(NewsList.class)
                    .createUnmarshaller()
                    .unmarshal(new URL("https://rss.sciencedaily.com/all.xml"));
            System.out.println("Unmarshalling...");
            return true;
        } catch (JAXBException e) {
            return false;
        } catch (MalformedURLException e) {
            return false;
        }
    }
}

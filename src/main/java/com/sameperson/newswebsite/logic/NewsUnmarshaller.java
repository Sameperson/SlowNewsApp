package com.sameperson.newswebsite.logic;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.net.MalformedURLException;
import java.net.URL;

public class NewsUnmarshaller {
    public static boolean unmarshal(NewsListForUnmarshaller newsList) {
        try {
            newsList = (NewsListForUnmarshaller) JAXBContext.newInstance(NewsListForUnmarshaller.class)
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

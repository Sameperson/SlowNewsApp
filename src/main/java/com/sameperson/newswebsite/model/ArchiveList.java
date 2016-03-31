package com.sameperson.newswebsite.model;

import java.util.ArrayList;
import java.util.HashMap;

public class ArchiveList {

    private HashMap<String, ArrayList<NewsBean>> newsArchive;
    private static ArchiveList instance;


    public static ArchiveList getInstance() {
        if(instance ==null) {
            instance = new ArchiveList();
        }
        return instance;
    }

    public ArrayList<NewsBean> getUsersArchive(String user) {
        if(!newsArchive.containsKey(user)) {
            newsArchive.put(user, new ArrayList<>());
        }
        System.out.println("Got user's archive");
        return newsArchive.get(user);
    }

    public boolean hasNewsInArchive(String user, String name) {
        for(NewsBean newsBean : getUsersArchive(user)) {
            if(newsBean.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    protected ArchiveList() {
        newsArchive = new HashMap<>();
    }

}

package com.sameperson.newswebsite.model;

import java.util.ArrayList;

public class UserList {

    private static UserList instance;
    private ArrayList<UserBean> listOfTheUsers;

    public static UserList getInstance() {
        if(instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    public synchronized void addUser(String username, String password) {
        listOfTheUsers.add(new UserBean(username, password));
        System.out.println("User added!");
    }

    public ArrayList<UserBean> getList() {
        return listOfTheUsers;
    }

    protected UserList() {
        listOfTheUsers = new ArrayList<>();
    }

}

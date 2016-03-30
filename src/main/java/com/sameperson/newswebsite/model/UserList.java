package com.sameperson.newswebsite.model;

import java.util.ArrayList;

public class UserList {

    private static UserList instance;
    private ArrayList<UserBean> listOfTheUsers;

    public static synchronized UserList getInstance() {
        if(instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    public synchronized void addUser(String username, String password) {
        if(!checkIfUserInTheList(username)) {
            listOfTheUsers.add(new UserBean(username, password));
            System.out.println("User added!");
        } else {
            System.out.println("User already exist!");
        }
    }

    public ArrayList<UserBean> getList() {
        return listOfTheUsers;
    }

    private boolean checkIfUserInTheList(String username) {
        for(UserBean user : listOfTheUsers) {
            if(user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    protected UserList() {
        listOfTheUsers = new ArrayList<>();
    }

}

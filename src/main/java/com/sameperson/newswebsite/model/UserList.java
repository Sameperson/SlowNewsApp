package com.sameperson.newswebsite.model;

import java.util.ArrayList;

public class UserList {

    private static UserList instance;
    private ArrayList<User> listOfTheUsers;

    public static synchronized UserList getInstance() {
        if(instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    public synchronized void addUser(String username, String password) {
        if(!checkIfUserInTheList(username)) {
            listOfTheUsers.add(new User(username, password));
            System.out.println("User added!");
        } else {
            System.out.println("User already exist!");
        }
    }

    public User findByName(String name) {
        for(User userBean : listOfTheUsers) {
            if(userBean.getUsername().equals(name)) {
                return userBean;
            }
        }
        return null;
    }

    public boolean containsUser(String name) {
        for(User userBean : listOfTheUsers) {
            if(userBean.getUsername().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<User> getList() {
        return listOfTheUsers;
    }

    private boolean checkIfUserInTheList(String username) {
        for(User user : listOfTheUsers) {
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

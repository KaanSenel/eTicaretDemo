package com.core;

import com.entities.concretes.User;

import java.util.ArrayList;

public class UserList {
    static ArrayList<User> users=new ArrayList<>();

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void addUser(User user) {
        UserList.users.add(user);
    }
}

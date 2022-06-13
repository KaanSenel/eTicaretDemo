package com.dataAccess.concretes;

import com.core.UserList;
import com.dataAccess.abstracts.UserDao;
import com.entities.concretes.User;

import java.util.List;

public class HibernateUserDao implements UserDao {

    @Override
    public void add(User user) {
        System.out.println(user.getFirstName()+" kişisi eklendi.");
    }

    @Override
    public List<User> getAllUsers() {
        return UserList.getUsers();
    }
}

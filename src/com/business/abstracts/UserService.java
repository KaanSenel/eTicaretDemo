package com.business.abstracts;

import com.entities.concretes.User;

public interface UserService {
    void add(User user);
    void delete(User user);
    boolean validationMail(User user);
    void login(String email,String password);
}

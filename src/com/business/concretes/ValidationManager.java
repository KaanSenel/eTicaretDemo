package com.business.concretes;

import com.business.abstracts.ValidationService;
import com.core.UserList;
import com.entities.concretes.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationManager implements ValidationService {
    private final String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z]+\\.)+[a-zA-Z]{2,6}$";

    @Override
    public boolean validate(User user) {

        /* Regex ile mail kontrolü */
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(user.getEmail());

        for(User u: UserList.getUsers()){
            if(u.getEmail().equals(user.getEmail())){
                return false;
            }
        }
        return user.getFirstName().length()>2 && user.getLastName().length()>2 &&
               user.getPassword().length()>6 && matcher.matches();
    }
}
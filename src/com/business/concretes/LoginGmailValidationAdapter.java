package com.business.concretes;
import com.business.abstracts.ValidationService;
import com.entities.concretes.User;
import googleAuthentication.LoginGmail;

public class LoginGmailValidationAdapter implements ValidationService {

    @Override
    public boolean validate(User user) {
       LoginGmail loginGmail=new LoginGmail();
       loginGmail.login(user.getEmail(), user.getPassword());
       return true;
    }
}

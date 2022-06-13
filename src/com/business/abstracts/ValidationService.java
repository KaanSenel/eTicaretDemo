package com.business.abstracts;

import com.entities.concretes.User;

public interface ValidationService {

    boolean validate(User user);
}

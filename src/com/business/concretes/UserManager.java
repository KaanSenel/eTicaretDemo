package com.business.concretes;

import com.business.abstracts.UserService;
import com.business.abstracts.ValidationService;
import com.core.UserList;
import com.dataAccess.abstracts.UserDao;
import com.entities.concretes.User;

public class UserManager implements UserService {
    ValidationService validationService;
    UserDao userDao;

    public UserManager(UserDao userDao,ValidationService validationService) {
        this.userDao=userDao;
        this.validationService = validationService;
    }

    @Override
    public void add(User user) {

        if(validationService.validate(user)){

            if(validationMail(user)){
                userDao.add(user);
                UserList.addUser(user);
            }
            else {
                System.out.println("Mail doğrulaması yapılmadığı için "+ user.getFirstName() +" kişisine üyelik oluşturulamadı.");
            }
        }
        else {
            System.out.println("Ekleme işlemi başarısız !");
        }
    }

    @Override
    public void delete(User user) {
        System.out.println(user.getFirstName()+" kişisi silindi.");
    }

    @Override
    public boolean validationMail(User user) {
        //kullanıcıya mail gitti, kullanıcı üyeliği onaylarsa true , onaylamazsa false döner (simülasyon)
        if(user.getFirstName().equals("Ahmet")) {
            return false;
        }
        return true;
    }

    @Override
    public void login(String email, String password) {
        boolean user=false;
        for(User u :UserList.getUsers()){
            if(u.getEmail().equals(email) && u.getPassword().equals(password)){
                System.out.println(u.getFirstName()+" "+ u.getLastName()+" kullanıcısı oturum açtı.");
                user=true;
            }

        }
        if(!user){
            System.out.println("Girdiğiniz bilgiler doğru değil.");
        }
    }
}

import com.business.abstracts.UserService;
import com.business.concretes.LoginGmailValidationAdapter;
import com.business.concretes.UserManager;
import com.business.concretes.ValidationManager;
import com.core.UserList;
import com.dataAccess.concretes.HibernateUserDao;
import com.entities.concretes.User;

public class Main {

    public static void main(String[] args) {

        User user=new User("Kaan","Şenel","kaansenel@hotmail.com","asdasdasd");
        UserService userService=new UserManager(new HibernateUserDao(),new ValidationManager());
        userService.add(user);
        System.out.println("****************************************************");
        User user2=new User("Ali","Veli","kaansenel2@hotmail.com","12şkmdşöad");
        userService.add(user2);
        System.out.println("****************************************************");
        //Ahmet isimli kullanıcı kayıt edilirken mail doğrulaması yapmadığı için üyelik oluşturulamayacak.
        User user3=new User("Ahmet","Demir","ahmetdemir@gmail.com","111111111");
        UserService userServiceGmail=new UserManager(new HibernateUserDao(),new LoginGmailValidationAdapter());
        userServiceGmail.add(user3);

        System.out.println("Üye listesi : ");
        for(User u: UserList.getUsers()){
            System.out.println(u.getFirstName());
        }

        System.out.println("Oturum açma işlemi : ");
        userService.login(user2.getEmail(), user2.getPassword());

    }
}

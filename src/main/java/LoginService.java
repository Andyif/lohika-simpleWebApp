import model.User;

import java.util.Date;

public class LoginService {

    private static User user = new User();

//    public LoginService() {
//        this.user = new User();
//        this.user.setName("admin");
//        this.user.setPassword("admin");
//    }

    public boolean isValidUser(String name, String password) {
        if (name.isEmpty() || password.isEmpty()){
            return false;
        } else {
            user.setEntryDate(new Date());
            user.setName(name);
            user.setPassword(password);
            return true;
        }
    }

    public User getUser() {
        return user;
    }
}

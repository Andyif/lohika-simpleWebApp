import model.User;

public class LoginService {

    private User user;

    public LoginService() {
        this.user = new User();
        this.user.setName("admin");
        this.user.setPassword("admin");
    }

    public boolean isValidUser(String name, String password) {
        if (name.equals(user.getName()) && password.equals(user.getPassword())){
            return true;
        } else {
            return false;
        }
    }

    public User getUser() {
        return user;
    }
}

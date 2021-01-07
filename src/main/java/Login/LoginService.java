package Login;

public class LoginService {
    public boolean login(String username, String password) {
        if (username.equals("martijn") && password.equals("martijn")) {
            return true;
        } else {
            return false;
        }
    }
}

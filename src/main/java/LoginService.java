import java.sql.*;

public class LoginService {

    String dbUsername = "root";
    String dbPassword = "";
    String serverName = "jdbc:mysql://localhost:3306/sportenindebuurt";

    public boolean login(String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(serverName, dbUsername, dbPassword);
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM login WHERE Username = ?");
            stmt.setString(1, username);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                if (username.equals(result.getString("Username")) && password.equals(result.getString("Password"))) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

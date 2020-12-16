import java.sql.*;

public class LoginService {

    String dbUsername = "application";
    String dbPassword = "cM1l:Qze";
    String serverName = "jdbc:mysql://145.74.104.78:3306/sportenInDeBuurt";

    public boolean login(String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(serverName, dbUsername, dbPassword);
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Sporter WHERE email = ?");
            stmt.setString(1, username);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                if (username.equals(result.getString("email")) && password.equals(result.getString("wachtwoord"))) {
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

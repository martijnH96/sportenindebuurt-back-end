import java.sql.*;

public class LoginService {

    String dbName = "sportenindebuurt";
    String dbUsername = "root";
    String dbPassword = "";
    String serverName = "jdbc:mysql://localhost:3306/"+dbName;

    public boolean login(String username, String password) {
        //TODO Database verbinding
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(serverName, dbUsername, dbPassword);
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM 'user' WHERE 'Username' = ?");
            stmt.setString(1, username);
            ResultSet result = stmt.executeQuery();
            while (result.next()){
                if (username.equals(result.getString("Username")) && password.equals(result.getString("Password"))) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}

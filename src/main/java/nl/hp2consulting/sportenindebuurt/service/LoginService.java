package nl.hp2consulting.sportenindebuurt.service;

import java.sql.*;

public class LoginService {

    final String dbUsername = "application";
    final String dbPassword = "cM1l:Qze";
    final String serverName = "jdbc:mysql://145.74.104.78:3306/sportenInDeBuurt";

    public boolean login(String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(serverName, dbUsername, dbPassword);
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Sporter WHERE email = ?");
            stmt.setString(1, username);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                return username.equals(result.getString("email")) && password.equals(result.getString("wachtwoord"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

package nl.hp2consulting.sportenindebuurt.dao;

import nl.hp2consulting.sportenindebuurt.connection.ConnectionFac;
import nl.hp2consulting.sportenindebuurt.exceptions.ConnectionException;

import java.sql.*;

public class UserDAO {

    ConnectionFac connectionFac = new ConnectionFac();
    public int login(String username, String password) throws ConnectionException {
        try (
                var con = connectionFac.getConnection()
        ){
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Sporter WHERE email = ?");
            stmt.setString(1, username);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                if(username.equals(result.getString("email")) && password.equals(result.getString("wachtwoord"))){
                    return result.getInt("SporterId");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ConnectionException(e);
        }
        return 0;
    }
}

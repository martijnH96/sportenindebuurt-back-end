package nl.hp2consulting.sportenindebuurt.dao;

import nl.hp2consulting.sportenindebuurt.connection.ConnectionFac;
import nl.hp2consulting.sportenindebuurt.exceptions.ConnectionException;

import java.sql.*;

public class UserDAO {

    ConnectionFac connectionFac = new ConnectionFac();
    public boolean login(String username, String password) throws ConnectionException {
        try (
                var con = connectionFac.getConnection();
        ){
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Sporter WHERE email = ?");
            stmt.setString(1, username);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                return username.equals(result.getString("email")) && password.equals(result.getString("wachtwoord"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ConnectionException(e);
        }
        return false;
    }
}

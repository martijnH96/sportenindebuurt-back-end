package nl.hp2consulting.sportenindebuurt.dao;

import nl.hp2consulting.sportenindebuurt.connection.ConnectionFac;
import nl.hp2consulting.sportenindebuurt.dto.TimeFrameListDTO;
import nl.hp2consulting.sportenindebuurt.exceptions.ConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TimeFrameDAO {
    ConnectionFac connectionFac = new ConnectionFac();
    public boolean insertTime(TimeFrameListDTO timeFrameListDTO, int sporterID) throws ConnectionException {
        try (
                var con = connectionFac.getConnection();
                ){
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new ConnectionException(e);
        }
    }
}

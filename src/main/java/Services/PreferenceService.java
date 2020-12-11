package Services;

import DTO.ListDTO.SportsListDTO;
import DTO.ListDTO.TimeFrameListDTO;
import DTO.SportsDTO;
import DTO.TimeFrameDTO;

import javax.inject.Inject;
import javax.json.JsonObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class PreferenceService {
    String dbUsername = "root";
    String dbPassword = "";
    String serverName = "jdbc:mysql://localhost:3306/sportenindebuurt";



    public boolean insertTime(TimeFrameListDTO timeFrameListDTO){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(serverName, dbUsername, dbPassword);
            return true;
//            PreparedStatement stmt = con.prepareStatement();
//            ResultSet result = stmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertSports(SportsListDTO sportsListDTO){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(serverName, dbUsername, dbPassword);
            return true;
//            PreparedStatement stmt = con.prepareStatement();
//            ResultSet result = stmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

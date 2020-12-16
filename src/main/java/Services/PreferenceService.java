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
    String dbUsername = "application";
    String dbPassword = "cM1l:Qze";
    String serverName = "jdbc:mysql://145.74.104.78:3306/sportenInDeBuurt";



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
            for(SportsDTO sportsDTO : sportsListDTO.getSportsDTOList()){
                PreparedStatement stmt = con.prepareStatement("insert ignore into Voorkeur (Sporter_SporterId, Sport_naam. niveau) values (?,?,?)");
                stmt.setInt(1, 1);
                stmt.setString(2, sportsDTO.getSport());
                stmt.setDouble(3, sportsDTO.getSportLevel());
                stmt.execute();
            }
//            ResultSet result = stmt.executeQuery();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

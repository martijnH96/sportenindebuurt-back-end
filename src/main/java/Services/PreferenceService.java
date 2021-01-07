package Services;

import DTO.ListDTO.SportsListDTO;
import DTO.ListDTO.TimeFrameListDTO;
import DTO.SportsDTO;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.JsonValue;
import javax.json.stream.JsonCollectors;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PreferenceService {
    final String dbUsername = "application";
    final String dbPassword = "cM1l:Qze";
    final String serverName = "jdbc:mysql://145.74.104.78:3306/sportenInDeBuurt";



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

    public boolean insertSports(SportsListDTO sportsDTOList){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(serverName, dbUsername, dbPassword);
            for(SportsDTO sportsDTO : sportsDTOList.getSportsDTOList()){
                PreparedStatement stmt = con.prepareStatement("insert into Voorkeur (Sporter_SporterId, Sport_naam, niveau, locatievoorkeur) values (?,?,?,?) on duplicate key update niveau = ?");
                stmt.setInt(1, 1);
                stmt.setString(2, sportsDTO.getSport());
                stmt.setDouble(3, sportsDTO.getSportLevel());
                stmt.setInt(4, 0);
                stmt.setDouble(5, sportsDTO.getSportLevel());
                stmt.execute();
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

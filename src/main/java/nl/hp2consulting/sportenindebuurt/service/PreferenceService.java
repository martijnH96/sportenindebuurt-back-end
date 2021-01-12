package nl.hp2consulting.sportenindebuurt.service;

import nl.hp2consulting.sportenindebuurt.dto.SportsListDTO;
import nl.hp2consulting.sportenindebuurt.dto.TimeFrameListDTO;
import nl.hp2consulting.sportenindebuurt.dto.SportsDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreferenceService {
    final String dbUsername = "application";
    final String dbPassword = "cM1l:Qze";
    final String serverName = "jdbc:mysql://145.74.104.78:3306/sportenInDeBuurt"; //naar properties bestand halen.



    public boolean insertTime(TimeFrameListDTO timeFrameListDTO){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");                                          // connection factory hiervoor maken.
            Connection con = DriverManager.getConnection(serverName, dbUsername, dbPassword);   //

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
            con.close(); // natuurlijk altijd toevoegen.
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

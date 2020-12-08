package Services;

import DTO.SportsDTO;
import DTO.TimeFrameDTO;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class PreferenceService {
    String dbUsername = "root";
    String dbPassword = "";
    String serverName = "jdbc:mysql://localhost:3306/sportenindebuurt";



    public boolean insertTime(double locationX, double locationY, List<TimeFrameDTO> timeFrameDTOS){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(serverName, dbUsername, dbPassword);
//            PreparedStatement stmt = con.prepareStatement();
//            ResultSet result = stmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertSports(List<SportsDTO> sportsDTOS){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(serverName, dbUsername, dbPassword);
//            PreparedStatement stmt = con.prepareStatement();
//            ResultSet result = stmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

package Services;

import DTO.ListDTO.SportsListDTO;
import DTO.SportsDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SportService {
    String dbUsername = "application";
    String dbPassword = "cM1l:Qze";
    String serverName = "jdbc:mysql://145.74.104.78:3306/sportenInDeBuurt";

    public List<SportsDTO> getSports(){
        try {
            List<SportsDTO> sportsDTOList = new ArrayList<>();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(serverName, dbUsername, dbPassword);
            PreparedStatement stmt = con.prepareStatement("SELECT * from Sport");
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                SportsDTO sportsDTO = new SportsDTO();
                sportsDTO.setSport(result.getString("naam"));
                sportsDTO.setSportLevel(0);
                sportsDTOList.add(sportsDTO);
            }
            return sportsDTOList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

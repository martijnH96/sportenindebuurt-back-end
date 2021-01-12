package nl.hp2consulting.sportenindebuurt.service;
import nl.hp2consulting.sportenindebuurt.dto.SportsDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SportService {
    final String dbUsername = "application";
    final String dbPassword = "cM1l:Qze";
    final String serverName = "jdbc:mysql://145.74.104.78:3306/sportenInDeBuurt";

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

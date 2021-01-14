package nl.hp2consulting.sportenindebuurt.dao;

import nl.hp2consulting.sportenindebuurt.connection.ConnectionFac;
import nl.hp2consulting.sportenindebuurt.dto.SportsDTO;
import nl.hp2consulting.sportenindebuurt.dto.SportsListDTO;
import nl.hp2consulting.sportenindebuurt.exceptions.ConnectionException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SportsDAO {
    ConnectionFac connectionFac = new ConnectionFac();

    public boolean insertSports(SportsListDTO sportsDTOList, int sporterID) throws ConnectionException {
        try (
                var con = connectionFac.getConnection();
                ){
            for(SportsDTO sportsDTO : sportsDTOList.getSportsDTOList()){
                PreparedStatement stmt = con.prepareStatement("insert into Voorkeur (Sporter_SporterId, Sport_naam, niveau, locatievoorkeur) values (?,?,?,?) on duplicate key update niveau = ?");
                stmt.setInt(1, sporterID);
                stmt.setString(2, sportsDTO.getSport());
                stmt.setDouble(3, sportsDTO.getSportLevel());
                stmt.setInt(4, 0);
                stmt.setDouble(5, sportsDTO.getSportLevel());
                stmt.execute();
            }
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new ConnectionException(e);
        }
    }
    public List<SportsDTO> getSports(){
        try (
                var con = connectionFac.getConnection();
        ){
            List<SportsDTO> sportsDTOList = new ArrayList<>();
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

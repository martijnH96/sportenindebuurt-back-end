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
                var stmt = con.prepareStatement("insert into Voorkeur (Sporter_SporterId, Sport_naam, niveau, locatievoorkeur) values (?,?,?,?) on duplicate key update niveau = ?");
                stmt.setInt(1, sporterID);
                stmt.setString(2, sportsDTO.getSport());
                stmt.setDouble(3, sportsDTO.getSportLevel());
                stmt.setInt(4, 0);
                stmt.setDouble(5, sportsDTO.getSportLevel());
                stmt.execute();
                stmt.close();
            }
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new ConnectionException(e);
        }
    }
    public List<SportsDTO> getSports() throws ConnectionException {
        try (
                var con = connectionFac.getConnection();
                var stmt = con.prepareStatement("SELECT * from Sport");
                var result = stmt.executeQuery()
        ){
            List<SportsDTO> sportsDTOList = new ArrayList<>();
            while(result.next()){
                SportsDTO sportsDTO = new SportsDTO();
                sportsDTO.setSport(result.getString("naam"));
                sportsDTO.setSportLevel(0);
                sportsDTOList.add(sportsDTO);
            }
            return sportsDTOList;
        } catch (Exception e) {
            throw new ConnectionException(e);
        }
    }

    public List<SportsDTO> getSportsFromUser(int id) throws ConnectionException {
        try (
                var con = connectionFac.getConnection();
                var stmt = con.prepareStatement("SELECT * from Voorkeur where Sporter_SporterId = ?");
        ){
            stmt.setInt(1, id);
            var result = stmt.executeQuery();
            List<SportsDTO> sportsDTOList = new ArrayList<>();
            while(result.next()){
                SportsDTO sportsDTO = new SportsDTO();
                sportsDTO.setSport(result.getString("Sport_naam"));
                sportsDTO.setSportLevel(result.getInt("niveau"));
                sportsDTOList.add(sportsDTO);
            }
            return sportsDTOList;
        } catch (Exception e){
            throw new ConnectionException(e);
        }
    }
}

package nl.hp2consulting.sportenindebuurt.dao;
import nl.hp2consulting.sportenindebuurt.connection.ConnectionFac;
import nl.hp2consulting.sportenindebuurt.dto.SportsDTO;
import nl.hp2consulting.sportenindebuurt.dto.TimeFrameDTO;
import nl.hp2consulting.sportenindebuurt.dto.TimeFrameListDTO;
import nl.hp2consulting.sportenindebuurt.exceptions.ConnectionException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeFrameDAO {
    ConnectionFac connectionFac = new ConnectionFac();
    public boolean insertTime(TimeFrameListDTO timeFrameListDTO, int sporterID) throws ConnectionException {
        try (
                var con = connectionFac.getConnection()
        ){
            for(TimeFrameDTO timeFrameDTO : timeFrameListDTO.getTimeFrameDTOList()){
                var stmt = con.prepareStatement("insert into Tijdsvoorkeuren (SporterId, Dag, BeginTijd, EindTijd) values (?,?,?,?) on duplicate key update SporterId = ?");
                stmt.setInt(1, sporterID);
                stmt.setString(2, timeFrameDTO.getDay());
                stmt.setString(3, timeFrameDTO.getBeginTime());
                stmt.setString(4, timeFrameDTO.getEndTime());
                stmt.setInt(5, sporterID);
                stmt.execute();
                stmt.close();
            }
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new ConnectionException(e);
        }
    }

    public List<TimeFrameDTO> getTimeFrameFromUser(int sporterID) throws ConnectionException {
        try (
                var con = connectionFac.getConnection();
                var stmt = con.prepareStatement("SELECT * from Tijdsvoorkeuren where SporterId = ?");
        ){
            stmt.setInt(1, sporterID);
            var result = stmt.executeQuery();
            List<TimeFrameDTO> timeFrameDTOList = new ArrayList<>();
            while(result.next()){
                TimeFrameDTO timeFrameDTO = new TimeFrameDTO();
                timeFrameDTO.setDay(result.getString("Dag"));
                timeFrameDTO.setBeginTime(result.getString("BeginTijd"));
                timeFrameDTO.setEndTime(result.getString("EindTijd"));
                timeFrameDTOList.add(timeFrameDTO);
            }
            return timeFrameDTOList;
        } catch (Exception e) {
            throw new ConnectionException(e);
        }
    }
}

package nl.hp2consulting.sportenindebuurt.service;

import nl.hp2consulting.sportenindebuurt.dao.TimeFrameDAO;
import nl.hp2consulting.sportenindebuurt.dto.SportsDTO;
import nl.hp2consulting.sportenindebuurt.dto.TimeFrameDTO;
import nl.hp2consulting.sportenindebuurt.dto.TimeFrameListDTO;
import nl.hp2consulting.sportenindebuurt.exceptions.ConnectionException;

import javax.inject.Inject;
import java.util.List;

public class TimeFrameService {

    private TimeFrameDAO timeFrameDAO;
    @Inject
    public void setTimeFrameDAO(TimeFrameDAO timeFrameDAO) {
        this.timeFrameDAO = timeFrameDAO;
    }

    public boolean insertTime(TimeFrameListDTO timeFrameListDTO, int sporterID) throws ConnectionException {
        return timeFrameDAO.insertTime(timeFrameListDTO, sporterID);
    }

    public List<TimeFrameDTO> getTimeFrameFromUser(int sporterID) throws ConnectionException {
        return timeFrameDAO.getTimeFrameFromUser(sporterID);
    }

}

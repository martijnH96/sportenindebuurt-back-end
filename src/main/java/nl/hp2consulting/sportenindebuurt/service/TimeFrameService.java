package nl.hp2consulting.sportenindebuurt.service;

import nl.hp2consulting.sportenindebuurt.dao.TimeFrameDAO;
import nl.hp2consulting.sportenindebuurt.dto.TimeFrameListDTO;
import nl.hp2consulting.sportenindebuurt.exceptions.ConnectionException;

import javax.inject.Inject;

public class TimeFrameService {

    private TimeFrameDAO timeFrameDAO;
    @Inject
    public void setTimeFrameDAO(TimeFrameDAO timeFrameDAO) {
        this.timeFrameDAO = timeFrameDAO;
    }

    public boolean insertTime(TimeFrameListDTO timeFrameListDTO, int sporterID) throws ConnectionException {
        return timeFrameDAO.insertTime(timeFrameListDTO, sporterID);
    }


}

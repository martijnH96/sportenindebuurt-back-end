package nl.hp2consulting.sportenindebuurt.service;

import nl.hp2consulting.sportenindebuurt.dto.SportsListDTO;
import nl.hp2consulting.sportenindebuurt.dto.TimeFrameListDTO;
import nl.hp2consulting.sportenindebuurt.exceptions.ConnectionException;

import javax.inject.Inject;

public class PreferenceService {

    private SportService sportService;
    @Inject
    public void setSportService(SportService sportService) {
        this.sportService = sportService;
    }

    private TimeFrameService timeFrameService;
    @Inject
    public void setTimeFrameService(TimeFrameService timeFrameService) {
        this.timeFrameService = timeFrameService;
    }

    public boolean insertTime(TimeFrameListDTO timeFrameListDTO, int sporterID) throws ConnectionException {
        return timeFrameService.insertTime(timeFrameListDTO, sporterID);
    }

    public boolean insertSports(SportsListDTO sportsDTOList, int sporterID) throws ConnectionException {
        return sportService.insertSports(sportsDTOList, sporterID);
    }



}

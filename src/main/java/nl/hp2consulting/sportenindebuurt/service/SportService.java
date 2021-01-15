package nl.hp2consulting.sportenindebuurt.service;
import nl.hp2consulting.sportenindebuurt.dao.SportsDAO;
import nl.hp2consulting.sportenindebuurt.dto.SportsDTO;
import nl.hp2consulting.sportenindebuurt.dto.SportsListDTO;
import nl.hp2consulting.sportenindebuurt.exceptions.ConnectionException;

import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SportService {

    private SportsDAO sportsDAO;
    @Inject
    public void setSportsDAO(SportsDAO sportsDAO) {
        this.sportsDAO = sportsDAO;
    }


    public List<SportsDTO> getSports() throws ConnectionException {
        return sportsDAO.getSports();
    }

    public boolean insertSports(SportsListDTO sportsDTOList, int sporterID) throws ConnectionException {
        return sportsDAO.insertSports(sportsDTOList, sporterID);
    }

    public List<SportsDTO> getSportsFromUser(int sporterID) throws ConnectionException {
        return sportsDAO.getSportsFromUser(sporterID);
    }


}

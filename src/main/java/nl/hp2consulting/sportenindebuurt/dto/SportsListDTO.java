package nl.hp2consulting.sportenindebuurt.dto;

import nl.hp2consulting.sportenindebuurt.dto.SportsDTO;

import java.util.List;

public class SportsListDTO {
    private List<SportsDTO> sportsDTOList;

    public List<SportsDTO> getSportsDTOList() {
        return sportsDTOList;
    }

    public void setSportsDTOList(List<SportsDTO> sportsDTOList) {
        this.sportsDTOList = sportsDTOList;
    }
}

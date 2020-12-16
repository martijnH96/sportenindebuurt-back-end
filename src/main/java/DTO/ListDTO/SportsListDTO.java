package DTO.ListDTO;

import DTO.SportsDTO;

import java.util.List;

public class SportsListDTO {
    private List<SportsDTO> sportsListDTO;

    public List<SportsDTO> getSportsDTOList() {
        return sportsListDTO;
    }

    public void setSportsDTOList(List<SportsDTO> sportsDTOList) {
        this.sportsListDTO = sportsDTOList;
    }
}

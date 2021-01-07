package DTO.ListDTO;

import DTO.SportsDTO;

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

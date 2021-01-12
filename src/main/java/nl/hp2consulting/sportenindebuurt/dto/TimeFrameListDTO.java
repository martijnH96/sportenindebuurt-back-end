package nl.hp2consulting.sportenindebuurt.dto;

import nl.hp2consulting.sportenindebuurt.dto.TimeFrameDTO;

import java.util.List;

public class TimeFrameListDTO {
    private List<TimeFrameDTO> timeFrameDTOList;

    public List<TimeFrameDTO> getTimeFrameDTOList() {
        return timeFrameDTOList;
    }

    public void setTimeFrameDTOList(List<TimeFrameDTO> timeFrameDTOList) {
        this.timeFrameDTOList = timeFrameDTOList;
    }
}

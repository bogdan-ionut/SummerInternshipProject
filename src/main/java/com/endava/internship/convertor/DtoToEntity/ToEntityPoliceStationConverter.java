package com.endava.internship.convertor.DtoToEntity;

import com.endava.internship.domain.PoliceStation;
import com.endava.internship.dto.PoliceStationDTO;
import org.springframework.stereotype.Component;

/**
 * Class used for converting an PoliceStationDTO to PoliceStation object.
 */
@Component
public class ToEntityPoliceStationConverter {

    public PoliceStation convert(PoliceStationDTO policeStationDTO) {

        if (null == policeStationDTO) {
            return null;
        }
        PoliceStation policeStation = new PoliceStation(policeStationDTO.getStationId(), policeStationDTO.getName());
        policeStation.setNumberFoundItems(policeStationDTO.getNumberFoundItems());
        policeStation.setNumberLostItems(policeStationDTO.getNumberLostItems());
        policeStation.setNumberSolvedCases(policeStationDTO.getNumberSolvedCases());
        return policeStation;
    }
}
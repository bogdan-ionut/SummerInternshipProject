package com.endava.internship.convertor.EntityToDto;

import com.endava.internship.domain.PoliceStation;
import com.endava.internship.dto.PoliceStationDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used for converting an PoliceStation object to PoliceStationDTO.
 */
@Component
public class ToDtoPoliceStationConverter {

    public PoliceStationDTO convert(PoliceStation policeStation) {

        if (null == policeStation) {
            return null;
        }
        PoliceStationDTO policeStationDTO = new PoliceStationDTO(policeStation.getStationId(), policeStation.getName());
        policeStationDTO.setNumberFoundItems(policeStation.getNumberFoundItems());
        policeStationDTO.setNumberLostItems(policeStation.getNumberLostItems());
        policeStationDTO.setNumberSolvedCases(policeStation.getNumberSolvedCases());
        return policeStationDTO;
    }

    /**
     * This method converts a list of PoliceStation into a list of PoliceStationDTO.
     *
     * @param policeStations - a list of PoliceStation.
     * @return a new list of police station dto.
     */
    public List<PoliceStationDTO> convertPoliceStationList(List<PoliceStation> policeStations) {

        if (null == policeStations || policeStations.isEmpty()) {
            return new ArrayList<>();
        }
        List<PoliceStationDTO> policeStationDTOS = new ArrayList<>(policeStations.size());
        for (PoliceStation policeStation : policeStations) {
            PoliceStationDTO stationDTO = convert(policeStation);
            if (null != stationDTO) {
                policeStationDTOS.add(stationDTO);
            }
        }
        return policeStationDTOS;
    }
}
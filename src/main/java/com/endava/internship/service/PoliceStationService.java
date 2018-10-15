package com.endava.internship.service;

import com.endava.internship.dataservice.PoliceStationDataService;
import com.endava.internship.dto.PoliceStationDTO;
import com.endava.internship.exception.FieldConversionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service used for processing PoliceStation objects.
 */
@Service
public class PoliceStationService implements PoliceStationServiceInterface {

    @Autowired
    private PoliceStationDataService policeStationDataService;

    /**
     * This method retrieves a list of PoliceStationsDTO.
     *
     * @return a list of policeStationDTOS.
     */
    public List<PoliceStationDTO> getAllPoliceStations() throws FieldConversionException {
        return policeStationDataService.getAllPoliceStations();
    }
}
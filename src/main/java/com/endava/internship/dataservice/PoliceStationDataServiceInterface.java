package com.endava.internship.dataservice;

import com.endava.internship.domain.PoliceStation;
import com.endava.internship.dto.PoliceStationDTO;
import com.endava.internship.exception.FieldConversionException;

import java.util.List;

/**
 * Interface used to abstract the implementation of PoliceStationDataService.
 * It provides methods for:
 * - getRating for a specific PoliceStation.
 */
public interface PoliceStationDataServiceInterface {

    /**
     * This method retrieves solvedCases, lostItems & foundItems on all PoliceStations.
     *
     * @return a list of PoliceStationDTO.
     */
    List<PoliceStationDTO> getAllPoliceStations() throws FieldConversionException;

    /**
     * Get all PoliceStation objects.
     *
     * @return a list of PoliceStation's.
     */
    List<PoliceStation> getPoliceStations() throws FieldConversionException;

    /**
     * This method updates a PoliceStation in database.
     */
    void updatePoliceStation(Long stationId, String objectType);

    /**
     * This method updates a PoliceStation in database specially numberSolvedCases
     *
     * @param stationId - id of the police station to be updated.
     */
    void updateSolvedCasesPoliceStation(Long stationId);
}
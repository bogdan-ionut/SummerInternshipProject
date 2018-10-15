package com.endava.internship.dataservice;

import com.endava.internship.convertor.EntityToDto.ToDtoPoliceStationConverter;
import com.endava.internship.convertor.ItemStatusConverter;
import com.endava.internship.domain.ItemStatus;
import com.endava.internship.domain.PoliceStation;
import com.endava.internship.dto.PoliceStationDTO;
import com.endava.internship.exception.FieldConversionException;
import com.endava.internship.repository.PoliceStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.endava.internship.util.ExceptionMessage.FIELD_CONVERSION_EXCEPTION;

/**
 * Class used for accessing data from repository.
 */
@Service
public class PoliceStationDataService implements PoliceStationDataServiceInterface {

    @Autowired
    private PoliceStationRepository policeStationRepository;

    @Autowired
    private ToDtoPoliceStationConverter policeStationConverter;

    @Autowired
    private ItemStatusConverter itemStatusConverter;

    public PoliceStationDataService() {
    }

    /**
     * This method retrieves ratings for a list of PoliceStationDTO.
     *
     * @return a list of policeStationDTOS.
     */
    public List<PoliceStationDTO> getAllPoliceStations() throws FieldConversionException {

        List<PoliceStation> policeStations = getPoliceStations();
        return policeStationConverter.convertPoliceStationList(policeStations);
    }

    /**
     * This method retrieves in a list all PoliceStations.
     *
     * @return a list with all PoliceStations.
     * @throws FieldConversionException if some field could not be converted from database
     */

    public List<PoliceStation> getPoliceStations() throws FieldConversionException {

        try {
            return policeStationRepository.findAll();
        } catch (JpaSystemException exception) {
            throw new FieldConversionException(FIELD_CONVERSION_EXCEPTION);
        }
    }

    /**
     * This method updates a PoliceStation in database.
     *
     * @param policeStationId - police station id.
     * @param objectType      -status for object
     */
    public void updatePoliceStation(Long policeStationId, String objectType) {

        PoliceStation policeStation = findPoliceStation(policeStationId);
        if (null != policeStation) {
            ItemStatus itemStatus = itemStatusConverter.convertToEnum(objectType);
            if (itemStatus.equals(ItemStatus.LOST)) {
                int numberLostItems = policeStation.getNumberLostItems();
                policeStation.setNumberLostItems(numberLostItems + 1);
                policeStationRepository.save(policeStation);
            } else if (itemStatus.equals(ItemStatus.FOUND)) {
                int numberFoundItems = policeStation.getNumberFoundItems();
                policeStation.setNumberFoundItems(numberFoundItems + 1);
                policeStationRepository.save(policeStation);
            }
        }
    }

    /**
     * This method updates a PoliceStation in database specially numberSolvedCases
     *
     * @param stationId - id of the police station to be updated.
     */
    public void updateSolvedCasesPoliceStation(Long stationId) {

        PoliceStation policeStation = findPoliceStation(stationId);
        if (null != policeStation) {
            int numberSolvedCases = policeStation.getNumberSolvedCases();
            policeStation.setNumberSolvedCases(numberSolvedCases + 1);
            policeStationRepository.save(policeStation);
        }
    }

    /**
     * Find a police station by id
     *
     * @param stationId -id of the police station
     * @return a police station if it exist
     */
    private PoliceStation findPoliceStation(Long stationId) {

        Optional<PoliceStation> policeStation = policeStationRepository.findById(stationId);
        return policeStation.orElse(null);
    }
}
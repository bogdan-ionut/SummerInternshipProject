package com.endava.internship.controller;

import com.endava.internship.dto.PoliceStationDTO;
import com.endava.internship.exception.FieldConversionException;
import com.endava.internship.service.PoliceStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

/**
 * Controller for operations on PoliceStation objects.
 * Possible operation: Get rating;
 */
@RestController
public class PoliceStationController {

    @Autowired
    private PoliceStationService policeStationService;

    /**
     * Method that retrieves rating for PoliceStations object
     *
     * @return Http Status Code 200 for successful retrieval
     * Http Status Code 404 in unsuccessful cases
     */
    @GetMapping(value = "/getRating", produces = "application/json")
    public ResponseEntity<List<PoliceStationDTO>> getAllPoliceStations() {
        try {
            List<PoliceStationDTO> policeStations = policeStationService.getAllPoliceStations();
            return new ResponseEntity<>(policeStations, OK);
        } catch (FieldConversionException e) {
            return new ResponseEntity<>(NOT_FOUND);
        }
    }
}
package com.endava.internship.service;

import com.endava.internship.dto.PoliceStationDTO;
import com.endava.internship.exception.FieldConversionException;

import java.util.List;

/**
 * Interface used to abstract the implementation of PoliceStation class.
 * It provides methods for:
 * - getAllPoliceStations
 */
public interface PoliceStationServiceInterface {
    List<PoliceStationDTO> getAllPoliceStations() throws FieldConversionException;
}
package com.endava.internship.dto;

/**
 * Class that holds informations about the police station where the items were matched.
 */
public class PoliceStationDTO {

    private Long stationId;

    private String name;

    private int numberLostItems;

    private int numberFoundItems;

    private int numberSolvedCases;

    public PoliceStationDTO() {
    }

    public PoliceStationDTO(Long stationId, String name) {
        this.stationId = stationId;
        this.name = name;
    }

    public Long getStationId() {
        return stationId;
    }

    public String getName() {
        return name;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberLostItems() {
        return numberLostItems;
    }

    public void setNumberLostItems(int numberLostItems) {
        this.numberLostItems = numberLostItems;
    }

    public int getNumberFoundItems() {
        return numberFoundItems;
    }

    public void setNumberFoundItems(int numberFoundItems) {
        this.numberFoundItems = numberFoundItems;
    }

    public int getNumberSolvedCases() {
        return numberSolvedCases;
    }

    public void setNumberSolvedCases(int numberSolvedCases) {
        this.numberSolvedCases = numberSolvedCases;
    }
}
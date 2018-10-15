package com.endava.internship.domain;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Class that holds informations about the police station where the items were matched.
 */
@Entity
@Table(name = "police_station")
public class PoliceStation {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "station_id")
    private Long stationId;

    // item matched for a police station
    @OneToMany(mappedBy = "policeStation")
    private Set<ItemMatch> itemMatched;

    // reported items for a police station
    @OneToMany(mappedBy = "policeStation")
    private Set<ReportedItem> reportedItems;

    @Column(name = "name")
    private String name;

    @Column(name = "lost_items")
    private int numberLostItems;

    @Column(name = "found_items")
    private int numberFoundItems;

    @Column(name = "solved_cases")
    private int numberSolvedCases;

    public PoliceStation() {
    }

    public PoliceStation(Set<ItemMatch> itemMatches) {
        this.itemMatched = itemMatches;
    }

    public PoliceStation(Long stationId, String name) {
        this.stationId = stationId;
        this.name = name;
    }

    public Long getStationId() {
        return stationId;
    }

    public Set<ItemMatch> getItemMatched() {
        return itemMatched;
    }

    public void setItemMatched(Set<ItemMatch> itemMatched) {
        this.itemMatched = itemMatched;
    }

    public String getName() {
        return name;
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
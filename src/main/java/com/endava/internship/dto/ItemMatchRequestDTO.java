package com.endava.internship.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Class that contains matched items with only lost and found id
 */
@Component
public class ItemMatchRequestDTO implements Serializable {

    private static final long serialVersionUID = 4561125L;

    private Long lostItemId;

    private Long foundItemId;

    private Long stationId;

    public ItemMatchRequestDTO() {
    }

    public ItemMatchRequestDTO(Long lostItemId, Long foundItemId) {
        this.lostItemId = lostItemId;
        this.foundItemId = foundItemId;
    }

    public ItemMatchRequestDTO(Long lostItemId, Long foundItemId, Long stationId) {
        this.lostItemId = lostItemId;
        this.foundItemId = foundItemId;
        this.stationId = stationId;
    }

    public Long getLostItemId() {
        return lostItemId;
    }

    public void setLostItemId(Long lostItemId) {
        this.lostItemId = lostItemId;
    }

    public Long getFoundItemId() {
        return foundItemId;
    }

    public void setFoundItemId(Long foundItemId) {
        this.foundItemId = foundItemId;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }
}
package com.endava.internship.dto;

/**
 * Class that contains matched items
 */
public class ItemMatchDTO {

    private Long matchId;

    private ReportedItemDTO foundItem;

    private ReportedItemDTO lostItem;

    public ItemMatchDTO() {
    }

    public ItemMatchDTO(Long matchId, ReportedItemDTO foundItem, ReportedItemDTO lostItem) {
        this.matchId = matchId;
        this.foundItem = foundItem;
        this.lostItem = lostItem;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public ReportedItemDTO getFoundItem() {
        return foundItem;
    }

    public void setFoundItemDTO(ReportedItemDTO foundItem) {
        this.foundItem = foundItem;
    }

    public ReportedItemDTO getLostItem() {
        return lostItem;
    }

    public void setLostItem(ReportedItemDTO lostItem) {
        this.lostItem = lostItem;
    }
}

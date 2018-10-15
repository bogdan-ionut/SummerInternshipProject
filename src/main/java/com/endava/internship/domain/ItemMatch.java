package com.endava.internship.domain;

import javax.persistence.*;

/**
 * Class that contains matched items
 */
@Entity
public class ItemMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foundItemId")
    private ReportedItem foundItem;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lostItemId")
    private ReportedItem lostItem;

    public ItemMatch() {
    }

    public ItemMatch(Long matchId, ReportedItem foundItem, ReportedItem lostItem) {
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

    public ReportedItem getFoundItem() {
        return foundItem;
    }

    public void setFoundItem(ReportedItem foundItem) {
        this.foundItem = foundItem;
    }

    public ReportedItem getLostItem() {
        return lostItem;
    }

    public void setLostItem(ReportedItem lostItem) {
        this.lostItem = lostItem;
    }
}
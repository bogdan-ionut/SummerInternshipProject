package com.endava.internship.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * The item that was reported as stolen/lost/found
 */
@Entity
@Table(name = "reported_items")
public class ReportedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itemDetails", referencedColumnName = "detailId")
    private ItemDetails itemDetails;

    // reportedDate -  the date at which the item was reported as lost/stolen/found
    @Column(nullable = false)
    private Date reportedDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "item_status", nullable = false)
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "report_id")
    private Report report;

    @OneToMany(mappedBy = "lostItem", fetch = FetchType.EAGER)
    private Set<ItemMatch> lostItems;
    @OneToMany(mappedBy = "foundItem", fetch = FetchType.EAGER)
    private Set<ItemMatch> foundItems;

    public ReportedItem() {
    }

    private ReportedItem(ReportedItemBuilder reportedItemBuilder) {
        this.itemId = reportedItemBuilder.objectId;
        this.itemDetails = reportedItemBuilder.itemDetails;
        this.reportedDate = reportedItemBuilder.date;
        this.category = reportedItemBuilder.category;
        this.status = reportedItemBuilder.getItemStatus();
        this.report = reportedItemBuilder.report;
    }

    public Long getItemId() {
        return itemId;
    }

    public ItemDetails getItemDetails() {
        return itemDetails;
    }

    public Date getReportedDate() {
        return reportedDate;
    }

    public Category getCategory() {
        return category;
    }

    public Report getReport() {
        return report;
    }

    public String getStatus() {
        return status;
    }

    public static class ReportedItemBuilder {

        private Long objectId;
        private ItemDetails itemDetails;
        private Date date;
        private Category category;
        private ItemStatus itemStatus;
        private Report report;

        /**
         * Constructor with parameters
         *
         * @param objectId   -required parameter object id
         * @param date       - required parameter reportedDate
         * @param itemStatus - required parameter object type
         */
        public ReportedItemBuilder(Long objectId, Date date, ItemStatus itemStatus) {
            this.objectId = objectId;
            this.date = date;
            this.itemStatus = itemStatus;
        }

        public ReportedItemBuilder setItemDetails(ItemDetails itemDetails) {
            this.itemDetails = itemDetails;
            return this;
        }

        public ReportedItemBuilder setCategory(Category category) {
            this.category = category;
            return this;
        }

        public ReportedItemBuilder setReport(Report report) {
            this.report = report;
            return this;
        }

        public String getItemStatus() {
            return itemStatus.toString();
        }

        public ReportedItem build() {
            return new ReportedItem(this);
        }
    }
}

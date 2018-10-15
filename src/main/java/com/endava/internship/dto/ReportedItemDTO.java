package com.endava.internship.dto;

import com.endava.internship.domain.ItemStatus;

import java.util.Date;

/**
 * The item that was reported as stolen/lost/found
 */
public class ReportedItemDTO {

    private Long itemId;

    private ItemDetailsDTO itemDetails;

    // reportedDate -  the date at which the item was reported as lost/stolen/found
    private Date reportedDate;

    private CategoryDTO category;

    private String status;

    private ReportDTO report;

    public ReportedItemDTO() {
    }

    public void setItemDetails(ItemDetailsDTO itemDetails) {
        this.itemDetails = itemDetails;
    }

    public void setReportedDate(Date reportedDate) {
        this.reportedDate = reportedDate;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReport(ReportDTO report) {
        this.report = report;
    }

    private ReportedItemDTO(ReportedItemBuilderDTO reportedItemBuilder) {
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

    public ItemDetailsDTO getItemDetails() {
        return itemDetails;
    }

    public Date getReportedDate() {
        return reportedDate;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public ReportDTO getReport() {
        return report;
    }

    public String getObjectType() {
        return status;
    }

    public static class ReportedItemBuilderDTO {

        private Long objectId;
        private ItemDetailsDTO itemDetails;
        private Date date;
        private CategoryDTO category;
        private ItemStatus itemStatus;

        private ReportDTO report;

        /**
         * Constructor with parameters
         *
         * @param objectId   -required parameter object id
         * @param date       - required parameter reportedDate
         * @param itemStatus - required parameter object type
         */
        public ReportedItemBuilderDTO(Long objectId, Date date, ItemStatus itemStatus) {
            this.objectId = objectId;
            this.date = date;
            this.itemStatus = itemStatus;
        }

        public ReportedItemBuilderDTO setItemDetails(ItemDetailsDTO itemDetails) {
            this.itemDetails = itemDetails;
            return this;
        }

        public ReportedItemBuilderDTO setCategory(CategoryDTO category) {
            this.category = category;
            return this;
        }

        public ReportedItemBuilderDTO setReport(ReportDTO report) {
            this.report = report;
            return this;
        }

        public String getItemStatus() {
            return itemStatus.toString();
        }

        public ReportedItemDTO build() {
            return new ReportedItemDTO(this);
        }
    }
}

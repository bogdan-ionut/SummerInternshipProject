package com.endava.internship.dto;

import java.util.Date;

/**
 * The class used for keeping details about the lost/found items
 */
public class ItemDetailsDTO {

    private Long detailId;

    private String generalDescription;

    // uniqueFeature - unique feature that may help identify the item
    private String uniqueFeature;

    //eventDate - the date at which the item was lost/stolen/found
    private Date eventDate;

    //location -  location where the item was found/lost/stolen
    private String location;

    // image - image of the lost/found/stolen item

    private byte[] image;
    // colour - colour of the lost/found/stolen item.

    private String colour;

    public ItemDetailsDTO() {
    }

    private ItemDetailsDTO(ItemDetailsBuilderDTO itemDetailsBuilder) {
        this.detailId = itemDetailsBuilder.detailId;
        this.generalDescription = itemDetailsBuilder.description;
        this.eventDate = itemDetailsBuilder.requestDate;
        this.colour = itemDetailsBuilder.colour;
        this.uniqueFeature = itemDetailsBuilder.uniqueFeature;
        this.location = itemDetailsBuilder.location;
        this.image = itemDetailsBuilder.image;
    }

    public Long getDetailId() {
        return detailId;
    }

    public String getGeneralDescription() {
        return generalDescription;
    }

    public String getUniqueFeature() {
        return uniqueFeature;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public String getLocation() {
        return location;
    }

    public byte[] getImage() {
        return image;
    }

    public String getColour() {
        return colour;
    }

    public void setGeneralDescription(String generalDescription) {
        this.generalDescription = generalDescription;
    }

    public void setUniqueFeature(String uniqueFeature) {
        this.uniqueFeature = uniqueFeature;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public static class ItemDetailsBuilderDTO {


        private Long detailId;
        private String description;
        private String uniqueFeature;
        private Date requestDate;
        private String location;
        private byte[] image;
        private String colour;

        public ItemDetailsBuilderDTO(Long detailId, String description, Date requestDate) {
            this.detailId = detailId;
            this.description = description;
            this.requestDate = requestDate;
        }

        public ItemDetailsBuilderDTO setUniqueFeature(String uniqueFeature) {
            this.uniqueFeature = uniqueFeature;
            return this;
        }

        public ItemDetailsBuilderDTO setLocation(String location) {
            this.location = location;
            return this;
        }

        public ItemDetailsBuilderDTO setImage(byte[] image) {
            this.image = image;
            return this;
        }

        public ItemDetailsBuilderDTO setColour(String colour) {
            this.colour = colour;
            return this;
        }

        public ItemDetailsDTO build() {
            return new ItemDetailsDTO(this);
        }
    }
}

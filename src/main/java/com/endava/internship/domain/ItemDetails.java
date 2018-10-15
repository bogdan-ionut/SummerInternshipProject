package com.endava.internship.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * The class used for keeping details about the lost/found items
 */
@Entity
public class ItemDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detailId;

    private String generalDescription;

    // uniqueFeature - unique feature that may help identify the item
    @Column(name = "unique_feature")
    private String uniqueFeature;

    //eventDate - the date at which the item was lost/stolen/found
    @Column(name = "request_date")
    private Date eventDate;

    //location -  location where the item was found/lost/stolen
    private String location;

    // image - image of the lost/found/stolen item
    @Lob
    private byte[] image;

    // colour - colour of the lost/found/stolen item.
    private String colour;

    @OneToOne(mappedBy = "itemDetails")
    @JoinColumn(name = "itemId")
    private ReportedItem reportedItem;

    public ItemDetails() {
    }

    private ItemDetails(ItemDetailsBuilder itemDetailsBuilder) {
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

    public static class ItemDetailsBuilder {

        private Long detailId;
        private String description;
        private String uniqueFeature;
        private Date requestDate;
        private String location;
        private byte[] image;
        private String colour;

        public ItemDetailsBuilder(Long detailId, String description, Date requestDate) {
            this.detailId = detailId;
            this.description = description;
            this.requestDate = requestDate;
        }

        public ItemDetailsBuilder setUniqueFeature(String uniqueFeature) {
            this.uniqueFeature = uniqueFeature;
            return this;
        }

        public ItemDetailsBuilder setLocation(String location) {
            this.location = location;
            return this;
        }

        public ItemDetailsBuilder setImage(byte[] image) {
            this.image = image;
            return this;
        }

        public ItemDetailsBuilder setColour(String colour) {
            this.colour = colour;
            return this;
        }

        public ItemDetails build() {
            return new ItemDetails(this);
        }
    }
}
package com.endava.internship.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * The class used to identify a set of reported items and the details about the person who lost/found them.
 */
@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @Column(name = "personal_details")
    private String personalDetails;

    @OneToMany(mappedBy = "report")
    private Set<ReportedItem> items;

    public Report() {
    }

    public Report(Long reportId) {
        this.reportId = reportId;
    }

    /**
     * Constructor with parameters
     *
     * @param reportId        - case id
     * @param personalDetails - personal details
     */
    public Report(Long reportId, String personalDetails) {
        this.personalDetails = personalDetails;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(String personalDetails) {
        this.personalDetails = personalDetails;
    }
}
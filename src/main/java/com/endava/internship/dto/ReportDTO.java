package com.endava.internship.dto;

/**
 * The class used to identify a set of reported items and the details about the person who lost/found them.
 */
public class ReportDTO {

    private Long reportId;

    private String personalDetails;

    public ReportDTO() {
    }

    public ReportDTO(Long reportId) {
        this.reportId = reportId;
    }

    /**
     * Constructor with parameters
     *
     * @param reportId        - case id
     * @param personalDetails - personal details
     */
    public ReportDTO(Long reportId, String personalDetails) {
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

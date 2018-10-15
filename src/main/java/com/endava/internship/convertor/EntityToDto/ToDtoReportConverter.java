package com.endava.internship.convertor.EntityToDto;

import com.endava.internship.domain.Report;
import com.endava.internship.dto.ReportDTO;
import org.springframework.stereotype.Component;

/**
 * Class used for converting an ReportDTO object to Report object
 */
@Component
public class ToDtoReportConverter {

    public ReportDTO convert(Report report) {
        if (null == report) {
            return null;
        }
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setPersonalDetails(report.getPersonalDetails());
        reportDTO.setReportId(report.getReportId());
        return reportDTO;
    }
}
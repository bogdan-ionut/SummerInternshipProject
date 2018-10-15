package com.endava.internship.convertor.DtoToEntity;

import com.endava.internship.domain.Report;
import com.endava.internship.dto.ReportDTO;
import org.springframework.stereotype.Component;

/**
 * Class used for converting an Report object to ReportDTO object
 */
@Component
public class ToEntityReportConverter {

    public Report convert(ReportDTO reportDTO) {
        if (null == reportDTO) {
            return null;
        }
        Report reportEntity = new Report();
        reportEntity.setPersonalDetails(reportDTO.getPersonalDetails());
        reportEntity.setReportId(reportDTO.getReportId());
        return reportEntity;
    }
}
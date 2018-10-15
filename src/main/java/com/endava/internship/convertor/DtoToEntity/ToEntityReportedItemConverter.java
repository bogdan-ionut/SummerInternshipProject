package com.endava.internship.convertor.DtoToEntity;

import com.endava.internship.convertor.ItemStatusConverter;
import com.endava.internship.domain.ReportedItem;
import com.endava.internship.dto.ReportedItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.endava.internship.convertor.DateConverter.dateConverter;

/**
 * Class used for converting an ReportedItem object to ReportedItemDTO object
 */
@Component
public class ToEntityReportedItemConverter {

    @Autowired
    private ToEntityItemDetailsConverter toEntityItemDetailsConverter;

    @Autowired
    private ItemStatusConverter statusConverter;

    @Autowired
    private ToEntityCategoryConverter toEntityCategoryConverter;

    @Autowired
    private ToEntityReportConverter toEntityReportConverter;

    public ReportedItem convert(ReportedItemDTO reportedItemDTO) {
        if (null == reportedItemDTO) {
            return null;
        }
        return new ReportedItem.ReportedItemBuilder(reportedItemDTO.getItemId(), dateConverter(reportedItemDTO.getReportedDate()), statusConverter.convertToEnum(reportedItemDTO.getObjectType()))
                .setItemDetails(toEntityItemDetailsConverter.convert(reportedItemDTO.getItemDetails()))
                .setCategory(toEntityCategoryConverter.convert(reportedItemDTO.getCategory()))
                .setReport(toEntityReportConverter.convert(reportedItemDTO.getReport()))
                .build();
    }
}
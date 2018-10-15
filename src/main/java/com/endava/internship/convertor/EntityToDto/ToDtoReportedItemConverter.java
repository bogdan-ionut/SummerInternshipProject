package com.endava.internship.convertor.EntityToDto;

import com.endava.internship.convertor.ItemStatusConverter;
import com.endava.internship.domain.ReportedItem;
import com.endava.internship.dto.ReportedItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used for converting an ReportedItemDTO object to ReportedItem object
 */
@Component
public class ToDtoReportedItemConverter {

    @Autowired
    private ToDtoItemDetailsConverter toDtoItemDetailsConverter;

    @Autowired
    private ItemStatusConverter statusConverter;

    @Autowired
    private ToDtoCategoryConverter toDtoCategoryConverter;

    @Autowired
    private ToDtoReportConverter toDtoReportConverter;

    public ReportedItemDTO convert(ReportedItem reportedItem) {
        if (null == reportedItem) {
            return null;
        }
        return new ReportedItemDTO.ReportedItemBuilderDTO(reportedItem.getItemId(), reportedItem.getReportedDate(), statusConverter.convertToEnum(reportedItem.getStatus()))
                .setItemDetails(toDtoItemDetailsConverter.convert(reportedItem.getItemDetails()))
                .setCategory(toDtoCategoryConverter.convert(reportedItem.getCategory()))
                .setReport(toDtoReportConverter.convert(reportedItem.getReport()))
                .build();
    }

    public List<ReportedItemDTO> convertList(List<ReportedItem> reportedItems) {
        List<ReportedItemDTO> reportedItemDTOS = new ArrayList<>();
        if (null != reportedItems && !reportedItems.isEmpty()) {
            for (ReportedItem reportedItem : reportedItems) {
                ReportedItemDTO reportedItemDTO = convert(reportedItem);
                if (null != reportedItemDTO) {
                    reportedItemDTOS.add(reportedItemDTO);
                }
            }
        }
        return reportedItemDTOS;
    }
}
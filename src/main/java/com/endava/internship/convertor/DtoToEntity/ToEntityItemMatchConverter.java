package com.endava.internship.convertor.DtoToEntity;

import com.endava.internship.domain.ItemMatch;
import com.endava.internship.dto.ItemMatchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class used for converting an ItemMatch object to ItemMatchDTO object
 */
@Component
public class ToEntityItemMatchConverter {

    @Autowired
    private ToEntityReportedItemConverter toEntityReportedItemConverter;

    public ItemMatch convert(ItemMatchDTO matchDTO) {
        if (null == matchDTO) {
            return null;
        }
        ItemMatch matchEntity = new ItemMatch();
        matchEntity.setFoundItem(toEntityReportedItemConverter.convert(matchDTO.getFoundItem()));
        matchEntity.setLostItem(toEntityReportedItemConverter.convert(matchDTO.getLostItem()));
        return matchEntity;
    }
}
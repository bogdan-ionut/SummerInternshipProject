package com.endava.internship.convertor.EntityToDto;

import com.endava.internship.domain.ItemMatch;
import com.endava.internship.dto.ItemMatchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class used for converting an ItemMatchDTO object to ItemMatch object
 */
@Component
public class ToDtoItemMatchConverter {

    @Autowired
    private ToDtoReportedItemConverter toDtoReportedItemConverter;

    public ItemMatchDTO convert(ItemMatch match) {
        if (null == match) {
            return null;
        }
        ItemMatchDTO matchDTO = new ItemMatchDTO();
        matchDTO.setFoundItemDTO(toDtoReportedItemConverter.convert(match.getFoundItem()));
        matchDTO.setLostItem(toDtoReportedItemConverter.convert(match.getLostItem()));
        return matchDTO;
    }
}
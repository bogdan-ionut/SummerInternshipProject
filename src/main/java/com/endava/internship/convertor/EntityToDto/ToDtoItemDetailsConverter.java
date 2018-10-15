package com.endava.internship.convertor.EntityToDto;

import com.endava.internship.domain.ItemDetails;
import com.endava.internship.dto.ItemDetailsDTO;
import org.springframework.stereotype.Component;

/**
 * Class used for converting an DetailsDTO object to Details object
 */
@Component
public class ToDtoItemDetailsConverter {

    public ItemDetailsDTO convert(ItemDetails details) {
        if (null == details) {
            return null;
        }
        return new ItemDetailsDTO.ItemDetailsBuilderDTO(details.getDetailId(), details.getGeneralDescription(), details.getEventDate())
                .setColour(details.getColour())
                .setImage(details.getImage())
                .setLocation(details.getLocation())
                .setUniqueFeature(details.getUniqueFeature())
                .build();
    }
}
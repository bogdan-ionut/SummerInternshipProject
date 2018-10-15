package com.endava.internship.convertor.DtoToEntity;

import com.endava.internship.domain.ItemDetails;
import com.endava.internship.dto.ItemDetailsDTO;
import org.springframework.stereotype.Component;

import static com.endava.internship.convertor.DateConverter.dateConverter;


/**
 * Class used for converting an Details object to DetailsDTO object
 */
@Component
public class ToEntityItemDetailsConverter {

    public ItemDetails convert(ItemDetailsDTO detailsDTO) {

        if (null == detailsDTO) {
            return null;
        }
        return new ItemDetails.ItemDetailsBuilder(detailsDTO.getDetailId(), detailsDTO.getGeneralDescription(), dateConverter(detailsDTO.getEventDate()))
                .setColour(detailsDTO.getColour())
                .setImage(detailsDTO.getImage())
                .setLocation(detailsDTO.getLocation())
                .setUniqueFeature(detailsDTO.getUniqueFeature())
                .build();
    }
}
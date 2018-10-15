package com.endava.internship.convertor;

import com.endava.internship.domain.ItemStatus;
import org.springframework.stereotype.Component;

import static com.endava.internship.domain.ItemStatus.ERROR;

/**
 * Class used for converting a String to Enum
 */
@Component
public class ItemStatusConverter {

    public ItemStatus convertToEnum(String statusToConvert) {
        for (ItemStatus status : ItemStatus.values()) {
            if (status.toString().equalsIgnoreCase(statusToConvert)) {
                return status;
            }
        }
        return ERROR;
    }
}
package com.endava.internship.util.validator;

import com.endava.internship.dto.ReportedItemDTO;
import org.springframework.stereotype.Component;

/**
 * Custom validator used to check if a ReportedItem has a correct format
 */
@Component
public class ReportedItemValidator {
    /**
     * Checks if specified ReportedItem object has null fields and constructs a string
     * with specified message
     *
     * @param reportedItem - object to be checked
     * @return String object which contains messages for missing fields
     */
    public static String checkForNullFields(ReportedItemDTO reportedItem) {
        String err = "";
        if (null == reportedItem.getItemId()) {
            err += "ItemId is null.\n";
        }
        if (null == reportedItem.getStatus()) {
            err += "ItemStatus is null.\n";
        }
        if (null == reportedItem.getReportedDate()) {
            err += "ReportedDate is null.\n";
        }
        if (null == reportedItem.getReport() || null == reportedItem.getReport().getReportId() || null == reportedItem.getReport().getPersonalDetails()) {
            err += "Report is null.\n";
        }
        if (null == reportedItem.getPoliceStation() || null == reportedItem.getPoliceStation().getStationId()) {
            err += "Police Station is null.\n";
        }
        return err;
    }

    /**
     * Checks if specified ReportedItem object has missing fields
     *
     * @param reportedItem - object to be checked
     * @return true if ReportedItem is valid or false in other case
     */
    public static boolean isValid(ReportedItemDTO reportedItem) {
        String err = checkForNullFields(reportedItem);
        return err.isEmpty();
    }
}
package com.endava.internship.util;

/**
 * Class that holds exception messages that may be used when throwing exceptions.
 */
public class ExceptionMessage {
    public static final String ITEM_NOT_FOUND_EXCEPTION = "ReportedItem could not be found";
    public static final String CATEGORY_NAME_NULL_EXCEPTION = "The Category name is null.";

    private ExceptionMessage() {
        // utility class does not need to be instantiated
    }
}

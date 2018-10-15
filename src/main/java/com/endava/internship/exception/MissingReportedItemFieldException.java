package com.endava.internship.exception;

/**
 * Custom checked exception. To be used when ReportedItem doesn't have valid fields.
 */
public class MissingReportedItemFieldException extends Exception {

    public MissingReportedItemFieldException(String message) {
        super(message);
    }
}
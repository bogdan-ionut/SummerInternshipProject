package com.endava.internship.exception;

/**
 * Custom checked exception. To be used when ReportedItem could not be found.
 */
public class ReportedItemNotFoundException extends Exception {
    public ReportedItemNotFoundException() {
    }

    public ReportedItemNotFoundException(String message) {
        super(message);
    }
}
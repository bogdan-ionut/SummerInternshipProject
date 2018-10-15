package com.endava.internship.exception;

/**
 * Custom checked exception. To be used when ReportedItem could not be found.
 */
public class ReportedItemWithThisStatusNotFoundException extends Exception {

    public ReportedItemWithThisStatusNotFoundException() {
    }

    public ReportedItemWithThisStatusNotFoundException(String message) {
        super(message);
    }
}
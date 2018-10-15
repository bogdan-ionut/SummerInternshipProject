package com.endava.internship.exception;

/**
 * Custom checked exception. To be used when cannot convert a field from database.
 */
public class FieldConversionException extends Exception {

    public FieldConversionException(String message) {
        super(message);
    }
}
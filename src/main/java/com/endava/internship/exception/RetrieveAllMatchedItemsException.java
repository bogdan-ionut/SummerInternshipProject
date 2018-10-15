package com.endava.internship.exception;

/**
 * Class that extends Exception and it appear when you call
 * the method findAllMatchedItems
 */
public class RetrieveAllMatchedItemsException extends Exception {

    public RetrieveAllMatchedItemsException() {
    }

    public RetrieveAllMatchedItemsException(String msg) {
        super(msg);
    }
}
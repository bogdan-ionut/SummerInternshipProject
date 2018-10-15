package com.endava.internship.convertor;

/**
 * Class used for converting java.util.Date to java.sql.Date
 */
public class DateConverter {

    public static java.sql.Date dateConverter(java.util.Date data) {
        if (null == data)
            return null;
        return new java.sql.Date(data.getTime());
    }
}

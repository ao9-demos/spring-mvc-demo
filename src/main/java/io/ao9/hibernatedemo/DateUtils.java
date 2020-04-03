package io.ao9.hibernatedemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public static Date parseDate(String str) throws ParseException {
        Date theDate = format.parse(str);
        return theDate;
    }

    public static String formatDate(Date theDate){
        String str = null;
        
        if(theDate != null) str = format.format(theDate);
        
        return str;
    }
}
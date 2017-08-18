package com.example.sergei.newsapp.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Sergei on 14.08.2017.
 */

public class DateHelper {

    private DateHelper(){}

    public static Date parseStringDateFromServer(String dateString){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        try {
            Date date = simpleDateFormat.parse(dateString);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getFormatDateString(Date date){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        String dateString = simpleDateFormat.format(date);
        return dateString;

    }

}

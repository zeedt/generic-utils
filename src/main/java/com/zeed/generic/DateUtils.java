package com.zeed.generic;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateUtils {

    public Date convertStringToDate(String dateString, String datePattern) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);

        Date date = simpleDateFormat.parse(dateString);

        return date;

    }

}

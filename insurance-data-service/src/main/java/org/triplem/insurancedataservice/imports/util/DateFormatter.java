package org.triplem.insurancedataservice.imports.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

@Component
@Slf4j
public class DateFormatter {

    String seperatorSlash = "/";
    String seperatorDot = "\\.";
    String seperatorMinus = "-";

    public Date formatDate(String date) {

        String filledUpDate = fillUpPeriod(date);
        Date parsedDate = null;

        try {
            parsedDate = new SimpleDateFormat(determineDateFormat(filledUpDate)).parse(filledUpDate);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

        return parsedDate;
    }

    private String fillUpPeriod(String date) {
        if(date.length() == 4) {
            date = "01.01." + date;
        }
        return date;
    }

    private String determineDateFormat(String date) {
        String dateFormat;

        if (date.split(seperatorSlash).length > 1) {
            if (Pattern.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$", date) && Integer.parseInt(date.split(seperatorSlash)[0]) > 12) {
                dateFormat = "dd/MM/yyyy";
            } else if (Pattern.matches("^(0[0-9]||1[0-2])/([0-2][0-9]||3[0-1])/([0-9][0-9])?[0-9][0-9]$", date) && Integer.parseInt(date.split(seperatorSlash)[1]) > 12) {
                dateFormat = "MM/dd/yyyy";
            } else if (Pattern.matches("^([0-9][0-9])?[0-9][0-9]/(0[0-9]||1[0-2])/([0-2][0-9]||3[0-1])$", date)) {
                dateFormat = "yyyy/MM/dd";
            } else {
                dateFormat = "dd/MM/yyyy";
            }
        } else if (date.split(seperatorDot).length > 1) {
            if (Pattern.matches("^([0-2][0-9]||3[0-1])\\.(0[0-9]||1[0-2])\\.([0-9][0-9])?[0-9][0-9]$", date) && Integer.parseInt(date.split(seperatorDot)[0]) > 12) {
                dateFormat = "dd.MM.yyyy";
            } else if (Pattern.matches("^(0[0-9]||1[0-2])\\.([0-2][0-9]||3[0-1])\\.([0-9][0-9])?[0-9][0-9]$", date) && Integer.parseInt(date.split(seperatorDot)[1]) > 12) {
                dateFormat = "MM.dd.yyyy";
            } else if (Pattern.matches("^([0-9][0-9])?[0-9][0-9]\\.(0[0-9]||1[0-2])\\.([0-2][0-9]||3[0-1])$", date)) {
                dateFormat = "yyyy.MM.dd";
            } else {
                dateFormat = "dd.MM.yyyy";
            }
        } else if (date.split(seperatorMinus).length > 1) {
            if (Pattern.matches("^([0-2][0-9]||3[0-1])-(0[0-9]||1[0-2])-([0-9][0-9])?[0-9][0-9]$", date) && Integer.parseInt(date.split(seperatorMinus)[0]) > 12) {
                dateFormat = "dd-MM-yyyy";
            } else if (Pattern.matches("^(0[0-9]||1[0-2])-([0-2][0-9]||3[0-1])-([0-9][0-9])?[0-9][0-9]$", date) && Integer.parseInt(date.split(seperatorMinus)[1]) > 12) {
                dateFormat = "MM-dd-yyyy";
            } else if (Pattern.matches("^([0-9][0-9])?[0-9][0-9]-(0[0-9]||1[0-2])-([0-2][0-9]||3[0-1])$", date)) {
                dateFormat = "yyyy-MM-dd";
            } else {
                dateFormat = "dd-MM-yyyy";
            }
        } else {
            dateFormat = "dd.MM.yyyy";
        }

        return dateFormat;
    }

}

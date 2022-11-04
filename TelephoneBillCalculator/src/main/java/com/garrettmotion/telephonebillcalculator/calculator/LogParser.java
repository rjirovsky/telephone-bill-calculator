/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.garrettmotion.telephonebillcalculator.calculator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 107546
 */
public class LogParser {

    public static final String DELIMITER = ",";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String TIME_PATTERN = "HH:mm:ss";
    public static final String DATETIME_PATTERN = DATE_PATTERN + " " + TIME_PATTERN;

    public List<Call> parseLog(String phoneLogCsv) {
        var logs = new ArrayList<Call>();

        var logStrings = phoneLogCsv.split(System.lineSeparator());
        for (String logString : logStrings) {
            var call = parseCall(logString);
            logs.add(call);
        }

        return logs;
    }

    public Call parseCall(String logString) {
        var values = logString.split(DELIMITER);
        if (values.length != 3) {
            throw new IllegalArgumentException("Log entry does't contain required parameters");
        }

        var number = Double.valueOf(values[0].trim());
        var from = parseDateTime(values[1].trim());
        var to = parseDateTime(values[2].trim());
        var call = new Call(number, from, to);
        return call;
    }

    public LocalDateTime parseDateTime(String dateTimeStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATETIME_PATTERN);
        return LocalDateTime.parse(dateTimeStr, formatter);
    }
}

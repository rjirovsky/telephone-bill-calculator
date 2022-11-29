/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.garrettmotion.telephonebillcalculator.calculator;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author 107546
 */
public class Rates {
    public static BigDecimal HIGH = new BigDecimal(1.0);
    public static BigDecimal LOW = new BigDecimal(0.5);
    public static BigDecimal BONUS = new BigDecimal(0.2);
    public static BigDecimal MOST_FREQUENT_NUMBER = new BigDecimal(0.0);
    
    public static LocalTime getHighStartTime(){
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CallParser.TIME_PATTERN);
         return LocalTime.parse("08:00:00", formatter);
    }
    
    public static LocalTime getLowStartTime(){
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CallParser.TIME_PATTERN);
         return LocalTime.parse("16:00:00", formatter);
    }
}

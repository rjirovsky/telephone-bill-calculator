/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.garrettmotion.telephonebillcalculator.test;

import com.garrettmotion.telephonebillcalculator.calculator.LogParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 107546
 */
public class LogParserTest {
    
    public LogParserTest() {
    }
    
    @Test
    public void parseDateTimeTest(){
        var dateTime = new LogParser().parseDateTime("2022-01-13 18:12:57");
        assertEquals(18, dateTime.getHour());
        assertEquals(13, dateTime.getDayOfMonth());
        assertEquals(57, dateTime.getSecond());
    }
    
    @Test
    public void parseCallTest(){
        var call = new LogParser().parseCall("420774577453, 2022-01-13 18:10:15, 2022-01-13 18:12:57");
        assertEquals(420774577453.0, call.getNumber());
        assertEquals(10, call.getFrom().getMinute());
        assertEquals(12, call.getTo().getMinute());
    }
    
}

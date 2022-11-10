/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.garrettmotion.telephonebillcalculator.test;

import com.garrettmotion.telephonebillcalculator.calculator.CallParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 107546
 */
public class CallParserTest {
    
    public CallParserTest() {
    }
    
    @Test
    public void parseDateTimeTest(){
        var dateTime = new CallParser().parseDateTime("2022-01-13 18:12:57");
        assertEquals(18, dateTime.getHour());
        assertEquals(13, dateTime.getDayOfMonth());
        assertEquals(57, dateTime.getSecond());
    }
    
    @Test
    public void parseCallTest(){
        var call = new CallParser().parseCall("420774577453, 2022-01-13 18:10:15, 2022-01-13 18:12:57");
        assertEquals(420774577453L, call.getNumber());
        assertEquals(10, call.getFrom().getMinute());
        assertEquals(12, call.getTo().getMinute());
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.garrettmotion.telephonebillcalculator.test;

import com.garrettmotion.telephonebillcalculator.calculator.Call;
import com.garrettmotion.telephonebillcalculator.calculator.MostFrequentNumberCalculator;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 107546
 */
public class MostFrequentNumberCalculatorTest {
    
    public MostFrequentNumberCalculatorTest() {
    }
    
    @Test
    public void getMostFrequentIfOnlyOneTest(){
        
        var calls = new ArrayList<Call>();
        calls.add(new Call(420000000333L, LocalDateTime.MIN, LocalDateTime.MAX));
        calls.add(new Call(420000000333L, LocalDateTime.MIN, LocalDateTime.MAX));
        calls.add(new Call(420000000333L, LocalDateTime.MIN, LocalDateTime.MAX));
        calls.add(new Call(420000000222L, LocalDateTime.MIN, LocalDateTime.MAX));
        calls.add(new Call(420000000222L, LocalDateTime.MIN, LocalDateTime.MAX));
        calls.add(new Call(420000000111L, LocalDateTime.MIN, LocalDateTime.MAX));
        
        assertEquals(420000000333L,MostFrequentNumberCalculator.getMostFrequentCall(calls));
    }
    
    @Test
    public void getMostFrequentIfMultipleTest(){
        var calls = new ArrayList<Call>();
        calls.add(new Call(420000000333L, LocalDateTime.MIN, LocalDateTime.MAX));
        calls.add(new Call(420000000333L, LocalDateTime.MIN, LocalDateTime.MAX));
        calls.add(new Call(420000000333L, LocalDateTime.MIN, LocalDateTime.MAX));
        calls.add(new Call(420000000222L, LocalDateTime.MIN, LocalDateTime.MAX));
        calls.add(new Call(420000000222L, LocalDateTime.MIN, LocalDateTime.MAX));
        calls.add(new Call(420000000222L, LocalDateTime.MIN, LocalDateTime.MAX));
        calls.add(new Call(420000000111L, LocalDateTime.MIN, LocalDateTime.MAX));
        
        assertEquals(420000000333L,MostFrequentNumberCalculator.getMostFrequentCall(calls));
    }
    
    @Test
    public void getMostFrequentIfEmptyTest(){
        var calls = new ArrayList<Call>();
        
        assertNull(MostFrequentNumberCalculator.getMostFrequentCall(calls));
    }
}

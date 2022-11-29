package com.garrettmotion.telephonebillcalculator.test;

import com.garrettmotion.telephonebillcalculator.calculator.Call;
import com.garrettmotion.telephonebillcalculator.calculator.MostFrequentNumberCalculator;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MostFrequentNumberCalculatorTest {
    
    public MostFrequentNumberCalculatorTest() {
    }
    
    @Test
    public void getMostFrequentIfOnlyOneTest(){
        
        var calls = new ArrayList<Call>();
        
        calls.add(new Call(420000000222L, LocalDateTime.MIN, LocalDateTime.MAX));
        calls.add(new Call(420000000222L, LocalDateTime.MIN, LocalDateTime.MAX));
        calls.add(new Call(420000000333L, LocalDateTime.MIN, LocalDateTime.MAX));
        calls.add(new Call(420000000333L, LocalDateTime.MIN, LocalDateTime.MAX));
        calls.add(new Call(420000000333L, LocalDateTime.MIN, LocalDateTime.MAX));
        calls.add(new Call(420000000111L, LocalDateTime.MIN, LocalDateTime.MAX));
        
        assertEquals(420000000333L,MostFrequentNumberCalculator.get(calls));
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
        calls.add(new Call(420000000555L, LocalDateTime.MIN, LocalDateTime.MAX));
        calls.add(new Call(420000000999L, LocalDateTime.MIN, LocalDateTime.MAX));
        calls.add(new Call(420000000999L, LocalDateTime.MIN, LocalDateTime.MAX));
        calls.add(new Call(420000000111L, LocalDateTime.MIN, LocalDateTime.MAX));
        
        assertEquals(420000000333L,MostFrequentNumberCalculator.get(calls));
    }
    
    @Test
    public void getMostFrequentIfEmptyTest(){
        var calls = new ArrayList<Call>();
        
        assertNull(MostFrequentNumberCalculator.get(calls));
    }
}

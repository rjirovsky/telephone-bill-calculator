/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.garrettmotion.telephonebillcalculator.calculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 107546
 */
public class MostFrequentNumberCalculator {

    public static Long getMostFrequentCall(List<Call> calls) {

        
        Long mostFrequentNumber = null;

        Map<Long, Integer> counter = new HashMap<>();

        for (var call : calls) {
            var current = counter.getOrDefault(call.getNumber(), 0);
            counter.put(call.getNumber(), current++);
        }
        
//        Collections.sort(calls);

        return mostFrequentNumber;
    }
}

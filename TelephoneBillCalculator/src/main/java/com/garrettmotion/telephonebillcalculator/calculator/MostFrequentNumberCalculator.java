package com.garrettmotion.telephonebillcalculator.calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MostFrequentNumberCalculator {

    public static Long get(List<Call> calls) {

        if(calls.isEmpty()){
            return null;
        }

        Map<Long, Integer> counter = new HashMap<>();

        for (var call : calls) {
            var current = counter.getOrDefault(call.getNumber(), 0);
            counter.put(call.getNumber(), ++current);
        }

        List<Entry<Long, Integer>> sorted = new ArrayList<>(counter.entrySet());
        
        
        sorted.sort(Entry.comparingByValue());
        
        var mostFrequentNumber = sorted.get(sorted.size()-1).getKey();
        System.out.println("Most frequent number: " + mostFrequentNumber);

        return mostFrequentNumber;
    }
}

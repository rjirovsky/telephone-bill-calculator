package com.garrettmotion.telephonebillcalculator.calculator;

import java.math.BigDecimal;
import java.time.LocalTime;

public class MyTelephoneBillCalculator implements ITelephoneBillCalculator {

    @Override
    public BigDecimal calculate(String phoneLog) {
        var totalCost = new BigDecimal(0.0);

        var calls = new CallParser().parseFromCsv(phoneLog);

        var mostFrequentNumber = MostFrequentNumberCalculator.get(calls);

        for (var call : calls) {
            var cost = calculateSingleCallCost(call, call.getNumber().equals(mostFrequentNumber));
            totalCost = totalCost.add(cost);
        }

        return totalCost;
    }

    private BigDecimal calculateSingleCallCost(Call call, boolean isMostFrequentNumber) {
        var cost = new BigDecimal(0.0);

        var current = call.getFrom().toLocalTime();
        var minuteCounter = 1;
        while (current.isBefore(call.getTo().toLocalTime()) || current.equals(call.getTo().toLocalTime())) {

            if (isMostFrequentNumber) {
                cost = cost.add(Rates.MOST_FREQUENT_NUMBER);
            } else {
                if (minuteCounter <= 5) {
                    if (isInHighRange(current)) {
                        cost = cost.add(Rates.HIGH);
                    } else {
                        cost = cost.add(Rates.LOW);
                    }
                } else {
                    cost = cost.add(Rates.BONUS);
                }
            }

            current = current.plusMinutes(1);
            minuteCounter++;
        }

        return cost;
    }

    private boolean isInHighRange(LocalTime time) {
        return (time.isAfter(Rates.getHighStartTime()) || time.equals(Rates.getHighStartTime())) && time.isBefore(Rates.getLowStartTime());
    }

}

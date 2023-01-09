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
            System.out.println(call.getNumber() + " cost is " + cost);
            totalCost = totalCost.add(cost);
        }

        return totalCost;
    }

    public BigDecimal calculateSingleCallCost(Call call, boolean isMostFrequentNumber) {
        var cost = new BigDecimal(0.0);

        var current = call.getFrom();
        var minuteCounter = 1;
        while (current.isBefore(call.getTo())) {

            if (isMostFrequentNumber) {
                cost = cost.add(Rates.MOST_FREQUENT_NUMBER);
            } else {
                if (minuteCounter <= 5) {
                    if (isInHighRange(current.toLocalTime())) {
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
        var afterOrEqualHighRateStarted = time.isAfter(Rates.getHighStartTime()) || time.equals(Rates.getHighStartTime());
        var beforeLowRateStarted = time.isBefore(Rates.getLowStartTime());

        return afterOrEqualHighRateStarted && beforeLowRateStarted;
    }
}

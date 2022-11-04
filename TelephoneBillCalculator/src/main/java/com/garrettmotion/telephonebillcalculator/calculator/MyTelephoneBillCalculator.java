/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.garrettmotion.telephonebillcalculator.calculator;

import java.math.BigDecimal;
import java.time.LocalTime;

/**
 *
 * @author 107546
 */
public class MyTelephoneBillCalculator implements ITelephoneBillCalculator {

    @Override
    public BigDecimal calculate(String phoneLog) {
        var cost = new BigDecimal(0.0);

        var logs = new LogParser().parseLog(phoneLog);
        //TODO: Remove most frequent number calls
        for (var log : logs) {
            cost.add(calculateCallCost(log));
        }

        return cost;
    }

    private BigDecimal calculateCallCost(Call call) {
        var cost = new BigDecimal(0.0);

        var current = call.getFrom().toLocalTime();
        var minuteCounter = 1;
        while (current.isBefore(call.getTo().toLocalTime()) || current.equals(call.getTo().toLocalTime())) {

            if (minuteCounter <= 5) {
                if (isInHighRange(current)) {
                    cost.add(Rates.HIGH);
                } else {
                    cost.add(Rates.LOW);
                }
            } else {
                cost.add(Rates.BONUS);
            }

            current.plusMinutes(1);
            minuteCounter++;
        }

        return cost;
    }

    private boolean isInHighRange(LocalTime time) {
        return (time.isAfter(Rates.getHighStartTime()) || time.equals(Rates.getHighStartTime())) && time.isBefore(Rates.getLowStartTime());
    }
}

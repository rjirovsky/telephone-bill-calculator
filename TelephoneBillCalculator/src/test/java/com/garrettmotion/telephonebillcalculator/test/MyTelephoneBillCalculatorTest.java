package com.garrettmotion.telephonebillcalculator.test;

import com.garrettmotion.telephonebillcalculator.calculator.Call;
import com.garrettmotion.telephonebillcalculator.calculator.MyTelephoneBillCalculator;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

public class MyTelephoneBillCalculatorTest {

    public MyTelephoneBillCalculatorTest() {
    }

    @Test
    public void getHighRateCallCostTest() {

        var call = new Call(
                420000000222L,
                LocalDateTime.of(2022, Month.JANUARY, 3, 14, 59, 0),
                LocalDateTime.of(2022, Month.JANUARY, 3, 15, 00, 59));

        var cost = new MyTelephoneBillCalculator().calculateSingleCallCost(call, false);
        assertEquals(BigDecimal.valueOf(2), cost);
    }

    @Test
    public void getHighRateStartCallCostTest() {

        var call = new Call(
                420000000222L,
                LocalDateTime.of(2022, Month.JANUARY, 3, 8, 00, 0),
                LocalDateTime.of(2022, Month.JANUARY, 3, 8, 00, 59));

        var cost = new MyTelephoneBillCalculator().calculateSingleCallCost(call, false);
        assertEquals(BigDecimal.valueOf(1), cost);
    }

    @Test
    public void getEndingInLowRateCallCostTest() {

        var call = new Call(
                420000000222L,
                LocalDateTime.of(2022, Month.JANUARY, 3, 7, 59, 0),
                LocalDateTime.of(2022, Month.JANUARY, 3, 7, 59, 59));

        var cost = new MyTelephoneBillCalculator().calculateSingleCallCost(call, false);
        assertEquals(BigDecimal.valueOf(0.5), cost);
    }

    @Test
    public void getLowRateCallCostTest() {

        var call = new Call(
                420000000222L,
                LocalDateTime.of(2022, Month.JANUARY, 3, 17, 59, 0),
                LocalDateTime.of(2022, Month.JANUARY, 3, 18, 00, 59));

        var cost = new MyTelephoneBillCalculator().calculateSingleCallCost(call, false);
        assertEquals(BigDecimal.valueOf(1.0), cost);
    }

    @Test
    public void getOverallpingCallCostTest() {

        var call = new Call(
                420000000222L,
                LocalDateTime.of(2022, Month.JANUARY, 3, 15, 59, 0),
                LocalDateTime.of(2022, Month.JANUARY, 3, 16, 00, 59));

        var cost = new MyTelephoneBillCalculator().calculateSingleCallCost(call, false);
        assertEquals(BigDecimal.valueOf(1.5), cost);
    }

    @Test
    public void getBonusRateNotAppliedCallCostTest() {

        // 5 min call
        var call = new Call(
                420000000222L,
                LocalDateTime.of(2022, Month.JANUARY, 3, 11, 0, 0),
                LocalDateTime.of(2022, Month.JANUARY, 3, 11, 4, 59));

        var cost = new MyTelephoneBillCalculator().calculateSingleCallCost(call, false);
        assertEquals(BigDecimal.valueOf(5), cost);
    }

    @Test
    @Disabled
    public void getBonusRateAppliedCallCostTest() {

        //6 min call
        var call = new Call(
                420000000222L,
                LocalDateTime.of(2022, Month.JANUARY, 3, 11, 0, 0),
                LocalDateTime.of(2022, Month.JANUARY, 3, 11, 5, 59));

        var cost = new MyTelephoneBillCalculator().calculateSingleCallCost(call, false);
        assertEquals(BigDecimal.valueOf(5.2), cost);
    }

}

package com.garrettmotion.telephonebillcalculator;

import com.garrettmotion.telephonebillcalculator.calculator.MyTelephoneBillCalculator;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class TelephoneBillCalculatorCLI {

    public static void main(String[] args) throws IOException {
        
        var csv = Files.readString(new File(args[0]).toPath(), StandardCharsets.UTF_8);
        var cost = new MyTelephoneBillCalculator().calculate(csv);
        
        System.out.println("Total cost is " + Math.round(cost.doubleValue()*100)/100.0);
    }
}

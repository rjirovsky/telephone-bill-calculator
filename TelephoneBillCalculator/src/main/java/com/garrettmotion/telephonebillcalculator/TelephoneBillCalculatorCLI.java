/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.garrettmotion.telephonebillcalculator;

import com.garrettmotion.telephonebillcalculator.calculator.MyTelephoneBillCalculator;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 *
 * @author 107546
 */
public class TelephoneBillCalculatorCLI {

    public static void main(String[] args) throws IOException {
        
        var csv = Files.readString(new File(args[0]).toPath(), StandardCharsets.UTF_8);
        var cost = new MyTelephoneBillCalculator().calculate(csv);
        
        System.out.println(cost);
    }
}

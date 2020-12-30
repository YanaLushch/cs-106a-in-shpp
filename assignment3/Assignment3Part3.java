package com.shpp.p2p.cs.ylushch.assignment3;

import com.shpp.cs.a.console.TextProgram;

/**
 * File: ${Assignment3Part3}.java
 * ---------------------------
 * This program raises the entered  number to power
 */

public class Assignment3Part3 extends TextProgram {
    /**
     * method runs the program
     */
    public void run() {
        double base = readDouble("Please enter base: ");
        int exponent = readInt("Please enter exponent: ");
        println(raiseToPower(base, exponent));
    }

    /**
     * accepts two parameters - base and exponent
     * and raises the number to power
     * it accepts some corner cases - if the exponent is 0, or below 0
     * or if the base is above 0 but less than 1
     * @param base is the value from the console
     * @param exponent is the value from the console
     * @return number raised to power
     */
    private double raiseToPower(double base, double exponent) {
        double numerator = getNumerator(base);
        String[] denominator = getDenominators(base);
        double denominatorIfNumBetween0And1 = Integer.parseInt(denominator[1]);
        double denominatorIfNumHigherThan0 = Integer.parseInt(denominator[0]);
        if (base > 0 && base < 1) {
            base = numerator / denominatorIfNumBetween0And1;
            exponent = (-1) * exponent; // if exponent is negative
        } else if ((base >= 1 || base <= 1) && exponent < 0) {
            base = (1.0 / denominatorIfNumHigherThan0);
            exponent = (-1) * exponent; // if exponent is negative
        }
        double result = base;
        for (double i = exponent; i > 1; i--) {
            result = result * base;
        }
        if (exponent == 0) {
            result = 0;
        }
        return result;
    }

    /**
     * method splits the number into two numbers
     * @param base value from the console - actual number which needs to be powered
     * @return split string. [0] - is the part before comma; [1] - value after comma
     */
    private String[] getDenominators(double base) {
        return Double.toString(base).split("\\.");
    }

    /**
     * method gets the decimals. and based on it's value calculates the 0es
     * @param base value from the console - actual number which needs to be powered
     * @return zeroes which numerator should have
     */
    private int getNumerator(double base) {
        String[] split = getDenominators(base);
        int zeroesAfterDecimal = 1;
        for (int i = 0; i < split[1].length(); i++) {
            zeroesAfterDecimal = zeroesAfterDecimal * 10;
        }
        return zeroesAfterDecimal;
    }

}


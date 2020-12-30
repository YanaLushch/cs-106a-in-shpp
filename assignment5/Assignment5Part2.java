package com.shpp.p2p.cs.ylushch.assignment5;


import com.shpp.cs.a.console.TextProgram;
/**
 * File: ${Assignment5Part2}.java
 * ---------------------------
 * Adds the numbers as in High School!!
 */

public class Assignment5Part2 extends TextProgram {
    public void run() {
        /* Sit in a loop, reading numbers and adding them. */
        while (true) {
            String n1 = readLine("Enter first number:  ");
            String n2 = readLine("Enter second number: ");
            println(n1 + " + " + n2 + " = " + addNumericStrings(n1, n2, 0));
        }
    }

    /**
     * Given two string representations of nonnegative integers, adds the
     * numbers represented by those strings and returns the result.
     *
     * @param n1str The first number.
     * @param n2str The second number.
     * @return A String representation of n1 + n2
     */
    private String addNumericStrings(String n1str, String n2str, int valueLeft) {
        Character result;
        //take the last characters from the string and convert them to int from the string
        int lastN1 = n1str.length() > 0  ? Character.getNumericValue(n1str.charAt(n1str.length() - 1)) : -1;
        int lastN2 = n2str.length() > 0  ? Character.getNumericValue(n2str.charAt(n2str.length() - 1)) : -1;

        //check if these values are not -1. cause if the they are -1 - the loop will be over!!
        if (lastN1 == -1 && lastN2 == -1) {
            return valueLeft > 0 ? String.valueOf(valueLeft) : "";
        } // if the value is 0 - we add the valueLeft ( last remainder)
        else {
            lastN1 = Math.max(lastN1, 0) + valueLeft;
            lastN2 = Math.max(lastN2, 0);
        }
        //check if there is remainder when adding two numbers
        if ((lastN1 + lastN2) >= 10) {
            result = String.valueOf(lastN1 + lastN2).charAt(1);
            valueLeft = 1;
        } else {
            result = String.valueOf(lastN1 + lastN2).charAt(0);
            valueLeft = 0;
        }
        //check if there is still some numbers left in the string
        String beginningN1 = n1str.length() > 1 ? n1str.substring(0, n1str.length() - 1) : "";
        String beginningN2 = n2str.length() > 1 ? n2str.substring(0, n2str.length() - 1) : "";

        //if there is no more numbers = return ""
        if (lastN1 == -1 && lastN2 == -1) {
            return "";
        } else {
            //recursion!!!
            return addNumericStrings(beginningN1, beginningN2, valueLeft) + result;
        }


    }
}
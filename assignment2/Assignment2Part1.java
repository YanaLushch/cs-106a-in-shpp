package com.shpp.p2p.cs.ylushch.assignment2;

import com.shpp.cs.a.console.TextProgram;
/* This is the square formula task.
    This program calculates the roots of the square formula. It prints out the result.
    Program has 2 methods.
    Method discriminant() - which accepts 3 parameters - of the square formula. And inside it calculates the roots.
    Method run() itself - asks the user in the console for 3 parameters. And then prints out the result
 */

public class Assignment2Part1 extends TextProgram {
    /**Method run accepts three doubles from the console and prints the calculated result*/
    public void run() {
        println("This program calculates the roots of the square formula");
        double a = readDouble("Please enter a: ");
        double b = readDouble("Please enter b: ");
        double c = readDouble("Please enter c: ");

        println(discriminant(a, b, c));
    }

    /** The method accepts three parameters and returns the result*/
    private String discriminant(double a, double b, double c) {
        double discriminant = b*b - 4*a*c;
        if (discriminant > 0){ //if discriminant is greater than 0 - returns 2 roots
            return "There are two roots: " + ((-b + Math.sqrt(discriminant))/(2 * a)) + " and " + (-b - Math.sqrt(discriminant))/(2 * a);
        } else if(discriminant < 0){ //if less than 0 - no roots
            return "There are no real roots";
        } else { //if equal to 0, there is only one root
            return "There is one root: " + ((-b)/(2*a));
        }
    }
}

package com.shpp.p2p.cs.ylushch.assignment3;

import com.shpp.cs.a.console.TextProgram;

/**
 * File: ${Assignment3Part2}.java
 * ---------------------------
 * This program runs the console game
 * Player enters a number
 * if number is even - program divides number on two
 * if number is odd - program multiplies number on 3 and adds one
 * game is over when number is equal to 1
 * */

public class Assignment3Part2 extends TextProgram {
    /**
     * method runs the program
     */
    public void run() {
        playGame();
        println("The End!");
    }

    /**
     * calls a function which asks user to enter a number
     *
     * @return a value entered in console
     */
    private Integer enterANumber() {
        return readInt("Enter a number: ");
    }

    /**
     * if number is even - program divides number on two
     * if number is odd - program multiplies number on 3 and adds one
     */
    private void playGame() {
        int number = enterANumber();
        while (number != 1) {
            int divideOnHalf = number / 2;
            int multiplyOn3 = (number * 3) + 1;
            if (number % 2 == 0) {
                println(number + " is even so I take half: " + divideOnHalf);
                number = divideOnHalf;
            } else {
                println(number + " is odd so I make 3n + 1: " + multiplyOn3);
                number = multiplyOn3;
            }
        }
    }
}


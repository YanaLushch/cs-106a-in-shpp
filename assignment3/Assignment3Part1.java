package com.shpp.p2p.cs.ylushch.assignment3;

import com.shpp.cs.a.console.TextProgram;

/**
 * File: ${Assignment3Part1}.java
 * ---------------------------
 * This program calculates whether your quantity of exercises per week is enough
 * for cardiovascular health and blood Pressure
 *
 * */

public class Assignment3Part1 extends TextProgram {
    private static final int CARDIO_TIMES_PER_WEEK = 5;
    private static final int BLOOD_PRESSURE_TIMES_PER_WEEK = 3;
    private static final int CARDIO_PER_DAY = 30;
    private static final int BLOOD_PRESSURE_PER_DAY = 40;

    /**
     * method runs the program
     */
    public void run() {
        int[] res = askExerciseTimeInAWeek();
        cardioVascularResult(res[0]);
        bloodPressureResult(res[1]);
    }

    /**
     * separate function to ask every day in a week about exercise time
     * @param day - count of the day
     * @return  - value input in the console
     */
    private Integer askExerciseTimeInADay(int day) {
        return readInt("How many minutes did you do on day " + day + "?: ");
    }

    /**
     * mathod calculates how many times per week person did enough exercices for
     * cardivascular and blood pressure health
     * @return the array of two numbers
     * [0] - result how many days per week was trained enough minutes for cardiovascular health
     * [1] - result how many days per week was trained for enough minutes blood pressure
     */
    private int[] askExerciseTimeInAWeek() {
        int[] cardioAndBloodPressure = new int[2];
        for (int i = 1; i <= 7; i++) {
            int ask = askExerciseTimeInADay(i);
            if (ask >= BLOOD_PRESSURE_PER_DAY) {
                cardioAndBloodPressure[0] += 1;
                cardioAndBloodPressure[1] += 1;
            } else if (ask >= CARDIO_PER_DAY) {
                cardioAndBloodPressure[0] += 1;
            }
        }
        return cardioAndBloodPressure;
    }

    /**
     *  method calculates if cardiovascular exercise time reached goal
     * @param cardio result how many days per week person trained for cardiovascular health excellence
     */
    private void cardioVascularResult(int cardio) {
        println("Cardiovascular Health: ");
        if (cardio >= CARDIO_TIMES_PER_WEEK) {
            println(" Great job! You've done enough exercise for cardiovascular health.");
        } else {
            println(" You needed to train hard for at least " + (CARDIO_TIMES_PER_WEEK - cardio)
                    + " more day(s) a week!");
        }
    }

    /**
     *  method calculates if blood pressure time reached goal
     * @param blood result how many days per week person trained for blood pressure excellence
     */
    private void bloodPressureResult(int blood) {
        println("Blood Pressure: ");
        if (blood >= BLOOD_PRESSURE_TIMES_PER_WEEK) {
            println(" Great job! You've done enough exercise to keep a low blood pressure.");
        } else {
            println(" You needed to train hard for at least " + (BLOOD_PRESSURE_TIMES_PER_WEEK - blood)
                    + " more day(s) a week!");
        }
    }

}
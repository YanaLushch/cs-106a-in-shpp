package com.shpp.p2p.cs.ylushch.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part3 extends KarelTheRobot {
    //Midpoint Finding
    public void run() throws Exception {
        //Karel moves the row and put beepers on two opposite corners to to find out borders
        putBeepersOnCorners();
        //Karel turns around to start looping in the middle of the
        turnAround();
        //Karel moves back and forward and put beepers where are no beepers.
        //Everytime he makes the first move after turning around he check if it has the beeper
        //And when this cell already has beeper, it means that Karel is in the middle
        //so he starts picking beepers till the end of the front is clear
        while (frontIsClear()){
            putBeepersIfCellHasItAndViceVersa();
        }
        //Karel turns around from the corner
        turnAround();
        //He moves till he step on our central beeper
        moveUntilBeeper();
        //He picks last beepers till the end of the world
        pickLastRowBeeper();
    }
    //Karel turns around
    public void turnAround() throws Exception{
        turnLeft();
        turnLeft();
    }
    // To bypass 2 first rows to put beepers on the corners
    public void putBeepersOnCorners() throws Exception{
        putBeeper();
        while ( frontIsClear()){
            move();
        }
        putBeeper();
    }
    //Karel moves until he steps on beeper
    public void moveUntilBeeper() throws Exception{
        while (noBeepersPresent()){
            move();
        }
    }
    //Karel moves back and forward and put beepers where are no beepers.
    //Everytime he makes the first move after turning around he check if it has the beeper
    //And when this cell already has beeper, it means that Karel is in the middle
    //so he starts picking beepers till the end of the front is clear
    public void putBeepersIfCellHasItAndViceVersa() throws Exception{
        move();
        if (beepersPresent()){
            pickBeeper();
        }
        else {
            moveUntilBeeper();
            turnAround();
            move();
            putBeeper();
        }
    }
    //Karel picks beeper till the end of the world
    public void pickLastRowBeeper() throws Exception{
        while (frontIsClear()){
            move();
            pickBeeper();
        }
    }
}
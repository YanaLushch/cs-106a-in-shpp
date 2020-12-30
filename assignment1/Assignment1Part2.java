package com.shpp.p2p.cs.ylushch.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part2 extends KarelTheRobot {
    //Stone Mason
    public void run() throws Exception {
        while ((frontIsClear() || rightIsClear())){
            //Karel builds column by moving and putting beepers
            //if the cell has beepers - Karel avoids this cell
            buildColumn();
            //Karel turns around and moves while front is clear
            // to return back to the point where he started building column
            returnToTheBeginningOfTheColumn();
            //Karel not building on each cell, only on 1, 5, 9, 13...
            //that's why he has to skip those
            skipThreeCells();
        }
        buildColumn();
    }
    //Karel turns around (180 degrees)
    public void turnAround() throws Exception{
        turnLeft();
        turnLeft();
    }
    //Karel moves and build column until front is Clear
    //also while building Karel uses method checkFoBeeper
    //cause he is not allowed to put beeper if it is already present in the cell
    public void buildColumn() throws Exception {
        turnLeft();
        while(frontIsClear()){
            //checks whether there are no beepers in the cell
            checkForBeeper();
            //then moves forward
            move();
        }
        //checks whether there are no beepers in the last cell
        checkForBeeper();
    }
    //Only if there are no beepers in the cell - put beeper
    public void checkForBeeper() throws Exception {
        if (noBeepersPresent()){
            putBeeper();
        }
    }

    public void returnToTheBeginningOfTheColumn() throws Exception {
        //turns around to prepare for returning back home
        turnAround();
        //moves while front is clear
        while (frontIsClear()) {
            move();
        }
    }
    //Karel moves out for 3 cells ahead
    public void skipThreeCells() throws Exception{
        //Karel turns left to prepare for moving East
        turnLeft();
        //Karel skips 3 cells ( i = 4, cause he has to move 4 times to avoid 3 cells)
        for (int i = 0; i < 4; i++) {
            move();
        }
    }

}

package com.shpp.p2p.cs.ylushch.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part4 extends KarelTheRobot {
    //Checker Board
    public void run() throws Exception {
        //Karel puts his first beeper - cause
        //cause one of the conditions is to have first beeper in south-west corner
        putBeeper();
        //filling the first rows in checker's format
        fillLikeCheckerRow();
        //checks whether he should put beeper in the first cell of next row or not
        stepOnFirstCellOfNextRow();
        //Karel fills all other rows till he moves to the last row
        while (frontIsClear() && (rightIsClear() || leftIsClear())){
            fillMiddleRowsLikeChecker();
        }
        //Karel recognizes the last row and checks where he has to turn
        //if his right is blocked then turn left, if his left is blocked - turn right
        whereToTurnBasedOnSide();
        //fills the last row till the end
        fillLikeCheckerRow();

    }
    //Karel turns right
    public void turnRight() throws Exception {
      for (int i = 0; i < 3; i++){
          turnLeft();
      }
    }
    //Karel decides what he should put in the first cell of next row based on where he is facing
    public void stepOnFirstCellOfNextRow() throws Exception{
        //here Karel is checked based on where he is facing
        //if on east - turn left, west - turn right
        whereToTurnBasedOnSide();
        //and then he should check whether he should put beeper on the first cell of next row
        oneCellEmptyOneWithBeeper();
    }
    //Karel fills all the rows except first and last
    public  void fillMiddleRowsLikeChecker() throws Exception{
        whereToTurnBasedOnSide();
        fillLikeCheckerRow();
        stepOnFirstCellOfNextRow();
    }
    //He does this checker board the whole row till front is clear
    public void fillLikeCheckerRow() throws Exception{
        while (frontIsClear()) {
            oneCellEmptyOneWithBeeper();
        }
    }
    //If Karel stands on beeper - then he has to move forward
    //If he already does not stand on it - he has to move one cell forward and put beeper
    public  void oneCellEmptyOneWithBeeper() throws Exception{
        if (noBeepersPresent()){
            move();
            putBeeper();
        } else{
            move();
        }
    }
    //if Karel's right is blocked then turn left, if his left is blocked - turn right
    public void whereToTurnBasedOnSide() throws Exception{
        //Karel should turn left if his right is blocked OR if he is facing east
        if (rightIsBlocked() || facingEast()){
            turnLeft();
        }
        //if his left is blocked OR he is facing west - turn right
        else if (leftIsBlocked() || facingWest()){
            turnRight();
        }
    }

}

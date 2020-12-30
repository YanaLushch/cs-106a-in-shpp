package com.shpp.p2p.cs.ylushch.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part1 extends KarelTheRobot {
    //Collecting Newspaper
    public void run() throws Exception {
        //Karel moves out of his home to the newspaper
        karelGoesToPickNews();
        //Karel picks newspaper
        pickBeeper();
        //Karel heads back to the initial point where he started
        karelGoesBackHome();
    }
    //Karel moves out from his home against the wall
    public void karelGoesToPickNews() throws Exception{
        move();
        move();
        turnRight();
        move();
        turnLeft();
        move();
        move();
    }
    //Karel turns right
    public void turnRight() throws Exception{
        turnLeft();
        turnLeft();
        turnLeft();
    }
    //Karel turns back and moves to the initial point where he started
    public void karelGoesBackHome() throws Exception {
        turnLeft();
        turnLeft();
        move();
        move();
        turnRight();
        move();
        turnLeft();
        move();
        move();
    }

}

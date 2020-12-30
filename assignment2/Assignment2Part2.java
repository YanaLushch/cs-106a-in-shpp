package com.shpp.p2p.cs.ylushch.assignment2;

import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
/*
     This programs shows us the delusion by illusion
     It has 4 circles and 1 white rectangles which overlays the 4 circles on 1/4 which creates the nice illusion
     in this program there are used 3 methods, 2 of them are setRect()  and setCircle() which set the rectangle and circle in the scope of window and define its colors
     in the method run 4 circles and 1 rect are created and set with the methods
 */


public class Assignment2Part2 extends WindowProgram {
    /*set width and height of the screen*/
    public static final int APPLICATION_WIDTH = 300;
    public static final int APPLICATION_HEIGHT = 300;
    /*set circle diameter*/
    public static final int CIRCLE_DIAMETER = 100;

    /*The x coordinate of the upper-left corner of circle*/
    public static final int OFFSET_POINT = 0;

    /** Method run draws 4 circles and one rectangle. Which are related to getWidth() and getHeight methods.
     * Also it uses two methods to set colors of the figures and to add the to the scope of the window*/
    public void run() {
        GOval oval1 = new GOval( OFFSET_POINT, OFFSET_POINT, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
        GOval oval2 = new GOval( getWidth() - CIRCLE_DIAMETER, OFFSET_POINT, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
        GOval oval3 = new GOval( OFFSET_POINT, getHeight() - CIRCLE_DIAMETER, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
        GOval oval4 = new GOval( getWidth() - CIRCLE_DIAMETER, getHeight() - CIRCLE_DIAMETER, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
        GRect rect1 = new GRect(CIRCLE_DIAMETER/2.0, CIRCLE_DIAMETER/2.0, getWidth() - CIRCLE_DIAMETER, getHeight()-CIRCLE_DIAMETER);
        setCircle(oval1);
        setCircle(oval2);
        setCircle(oval3);
        setCircle(oval4);
        setRectangle(rect1);
    }
    /** Method sets the color of the figure and adds figure to the window
     * */
    private void setCircle(GOval figure) {
        figure.setColor(Color.BLACK);
        figure.setFilled(true);
        figure.setFillColor(Color.BLACK);
        add(figure);
    }
    /** Method sets the color of the figure and adds figure to the window
     * */
    private void setRectangle(GRect figure) {
        figure.setColor(Color.WHITE);
        figure.setFilled(true);
        figure.setFillColor(Color.WHITE);
        add(figure);
    }
}


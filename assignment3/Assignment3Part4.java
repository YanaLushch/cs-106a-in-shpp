package com.shpp.p2p.cs.ylushch.assignment3;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;


/**
 * File: ${Assignment3Part4}.java
 * ---------------------------
 * This program draws the Pyramid
 * depending on the quantity ob bricks in the base
 *
 * */

public class Assignment3Part4 extends WindowProgram {
    /* set screen width and height responsively*/
    public static final int APPLICATION_WIDTH = 700;
    public static final int APPLICATION_HEIGHT = 500;
    /* set brick width and height responsively*/
    private static final int BRICK_HEIGHT = 10;
    private static final int BRICK_WIDTH = 15;
    /*set value how many bricks should be in the very first line on the bottom*/
    private static final int BRICKS_IN_BASE = 30;
    /*distance between each brick*/
    private static final int BRICK_DISTANCE = 5;
    /*value which contains brick width or height plus the distance between brick*/
    private static final int BRICK_WIDTH_AND_DISTANCE = BRICK_WIDTH + BRICK_DISTANCE;
    private static final int BRICK_HEIGHT_AND_DISTANCE = BRICK_HEIGHT + BRICK_DISTANCE;


    /**
     * method runs the program
     */
    public void run() {

        drawPyramid();
    }

    /**
     * method which draws the brick
     * @param x coordinate of the upper-left corner of the brick
     * @param y coordinate of the upper-left corner of the brick
     */
    private void drawBrick(double x, double y) {
        GRect figure = new GRect( x, y, BRICK_WIDTH, BRICK_HEIGHT);
        figure.setFilled(true);
        add(figure);
    }

    /**
     *method which draws the whole Pyramid
     * by building each separate horizontal row
     */
    private void drawPyramid() {
        for (int k = BRICKS_IN_BASE; k > 0; k--) {
            for (int i = 0; i <= BRICKS_IN_BASE - k; i++) {
                double offset_x = (getWidth() - BRICK_WIDTH_AND_DISTANCE * (BRICKS_IN_BASE - k)) / 2.0
                        + i * BRICK_WIDTH_AND_DISTANCE; //calculates the offset point x of each row in the pyramid
                double offset_y = getHeight() - BRICK_HEIGHT_AND_DISTANCE * k; //offset point x of each row in the pyramid
                drawBrick(offset_x, offset_y);
            }
        }
    }
}


package com.shpp.p2p.cs.ylushch.assignment2;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
/*
 *This program draws matrix of the squares. It is also optical illusion
 *Program has method drawSquare() which draws 1 small square
 * in the run() it has 2 cycles "for" which draw squares.
 * 1st cycle draws the squares vertically
 * 2nd cycle draws the squares horizontally
 */

public class Assignment2Part5 extends WindowProgram {
    public static final int APPLICATION_WIDTH = 330;
    public static final int APPLICATION_HEIGHT = 300;

    /* The number of rows and columns in the grid, respectively. */
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 6;

    /* The width and height of each box. */
    private static final double BOX_SIZE = 40;

    /* The horizontal and vertical spacing between the boxes. */
    private static final double BOX_SPACING = 10;

    /**
     * Method run draws the matrix of the squares 5 squares long and 6 squares wide*/
    public void run() {
        for (int k = 0; k < NUM_ROWS; k++){ // k params is responsible for the height
            for (int i = 0; i < NUM_COLS; i++ ){ // i param is responsible for the width
                drawSquare(20 + i*(BOX_SIZE+BOX_SPACING),20+ k*(BOX_SIZE+BOX_SPACING));
            }
        }
    }

    /**
     * Method accepts 3 parameters:
     *
     * params x and y are the initial point where the square shall start to be drawn
     * squareSize param is the actual width and height of the square.
     * It is concatenated, cause they are equal in the square*/
    private void drawSquare( double x ,double y) {
        GRect figure = new GRect(x, y, BOX_SIZE, BOX_SIZE);
        figure.setFilled(true);
        figure.setFillColor(Color.BLACK);
        add(figure);
    }
}


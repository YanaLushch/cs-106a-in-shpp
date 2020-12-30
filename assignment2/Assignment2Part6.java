package com.shpp.p2p.cs.ylushch.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
/*This program draws the caterpillar from the circles
 * it has drawCaterpillarPart() method which draws the circle of caterpillar body and fills it with color and adds it to the window scope
 * in the run() method - there is the cycle "for" which draws the caterpillar. depending if the circle's order number is even or odd
 * it adds the circles higher or lower
 */

public class Assignment2Part6 extends WindowProgram {
    public static final int APPLICATION_WIDTH = 450;
    public static final int APPLICATION_HEIGHT = 150;

    /* Diameter of the circle */
    private static final double CIRCLE_DIAMETER = 100;

    /* The y coordinate of the upper-left corner of the circle part of caterpillar*/
    private static final double OFFSET_Y_EVEN = 40;
    private static final double OFFSET_Y_ODD = 0;

    /* Horizontal distance between caterpillar parts */
    private static final double HORIZONTAL_DISTANCE_BETWEEN = CIRCLE_DIAMETER * 0.7;

    /* Number of circle parts which should contain the caterpillar*/
    private static final double NUM_OF_PARTS = 6;

    /* Colors of caterpillar*/
    private static final Color CATERPILLAR_GREEN = new Color(55, 176, 16);
    private static final Color DARK_RED = new Color(159, 29, 22);

    /** Cycle "for" depending on the order number of caterpillar part
     * if number is even - displays part higher, if odd - lower*/
    public void run() {
        for (int i = 0; i < NUM_OF_PARTS; i++) {
            if (i % 2 == 0) {       //if the order number of circle is even
                drawCaterpillarPart(i * (HORIZONTAL_DISTANCE_BETWEEN), OFFSET_Y_EVEN);
            } else {             //if the order number of circle is odd
                drawCaterpillarPart(i * (HORIZONTAL_DISTANCE_BETWEEN), OFFSET_Y_ODD);
            }

        }
    }

    /**
     * Method drawCaterpillarPart() draws the green oval with the red border
     * param x The x coordinate of the upper-left corner of the  circle.
     * param y The y coordinate of the upper-left corner of the circle.
     */
    private void drawCaterpillarPart(double x, double y) {
        GOval figure = new GOval(x, y, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
        figure.setColor(DARK_RED);
        figure.setFilled(true);
        figure.setFillColor(CATERPILLAR_GREEN);
        add(figure);
    }
}


package com.shpp.p2p.cs.ylushch.assignment2;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
/* This program draws flag where three-colors displayed horizontally or vertically.
 * it has method setBand() and setLabel() which draws the rectangle and label respectively.,
 * setRect method accepts parameters which are needed for building rectangle - offset_x and offset_y
 * There is also boolean value isVertical which is set to true by default. Changing it to "false" will lead to flag's colors bands display horizontally.
 */

public class Assignment2Part4 extends WindowProgram {

    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 400;

    /*The width and height of each band of vertically displayed text*/
    public static final double VERTICAL_BAND_WIDTH = 90;
    public static final double VERTICAL_BAND_HEIGHT = 230;

    /*The width and height of each band of horizontally displayed text*/
    public static final double HORIZONTAL_BAND_WIDTH = 280;
    public static final double HORIZONTAL_BAND_HEIGHT = 70;

    /*different colors*/
    private static final Color CARDINAL_RED = new Color(201, 2, 27);
    private static final Color DARK_BLUE = new Color(19, 54, 154);
    private static final Color ORANGE_YELLOW = new Color(229, 162, 29);

    Boolean isVertical = true; //boolean value which decides whether colors in the flag should be displayed vertically or not;

    /**draws the 3-colored flag depending on the boolean isVertical it will be displayed vertically or horizontally*/
    public void run() {

        if (isVertical) { //draws 3 bands which will be united in one 3-colored vertical flag
            double OFFSET_X = (getWidth() - VERTICAL_BAND_WIDTH * 3) / 2.0;
            double OFFSET_Y = (getHeight() - VERTICAL_BAND_HEIGHT) / 2.0;
            setBand(OFFSET_X, OFFSET_Y, VERTICAL_BAND_WIDTH, VERTICAL_BAND_HEIGHT, Color.BLACK);
            setBand(OFFSET_X + VERTICAL_BAND_WIDTH, OFFSET_Y, VERTICAL_BAND_WIDTH, VERTICAL_BAND_HEIGHT, Color.YELLOW);
            setBand(OFFSET_X + 2 * VERTICAL_BAND_WIDTH, OFFSET_Y, VERTICAL_BAND_WIDTH, VERTICAL_BAND_HEIGHT, Color.RED);
            setLabel("Flag of Belgium");
        } else { //draws 3 bands which will be united in one 3-colored horizontal flag

            double OFFSET_X = (getWidth() - HORIZONTAL_BAND_WIDTH ) / 2.0;
            double OFFSET_Y = (getHeight() - HORIZONTAL_BAND_HEIGHT * 3) / 2.0;
            setBand(OFFSET_X, OFFSET_Y, HORIZONTAL_BAND_WIDTH, HORIZONTAL_BAND_HEIGHT, CARDINAL_RED);
            setBand(OFFSET_X, OFFSET_Y + HORIZONTAL_BAND_HEIGHT, HORIZONTAL_BAND_WIDTH, HORIZONTAL_BAND_HEIGHT, DARK_BLUE);
            setBand(OFFSET_X, OFFSET_Y + 2 * HORIZONTAL_BAND_HEIGHT, HORIZONTAL_BAND_WIDTH, HORIZONTAL_BAND_HEIGHT, ORANGE_YELLOW);
            setLabel("Flag of Armenia");
        }
    }

    /**
     * setRect() method draws 3 rectangles and each has its different color
     * it accepts 5 parameters: x and y are the initial point whether the flag should start being drawn
     * width and height which is the actual height of each part of the band
     */
    private void setBand(double x, double y, double width, double height, Color color) {
        GRect figure = new GRect(x, y, width, height);
        figure.setColor(color);
        figure.setFilled(true);
        figure.setFillColor(color);
        add(figure);
    }

    /**
     * Method which will accept one string parameter which is the text - name of the flag
     */
    private void setLabel(String labelText) {
        GLabel label = new GLabel(labelText);
        double x = getWidth() - label.getWidth();
        double y = getHeight() - label.getDescent();
        add(label, x, y);
    }
}

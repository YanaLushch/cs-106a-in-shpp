package com.shpp.p2p.cs.ylushch.assignment3;

import com.shpp.cs.a.graphics.WindowProgram;
import acm.graphics.GOval;

import java.awt.*;

/**
 * File: ${Assignment3Part6}.java
 * ---------------------------
 * This program draws the sky of stars which start disappearing
 */

public class Assignment3Part6 extends WindowProgram {
    /*color of the dark sky*/
    private static final Color DARK_BLUE = new Color(30, 36, 58);
    /* How much time to pause between frames. */
    private static final double PAUSE_TIME = 10;
    private static final double STAR_RADIUS = 2;
    /*How many stars in the sky*/
    private static final int STARS_IN_THE_SKY = 500;


    /**
     * method runs the program
     */
    public void run() {
        /* color the window as the black sky*/
        setBackground(DARK_BLUE);

        /*stars show up and start disappearing for 5 seconds*/
        starsDisappearing();
    }

    /**
     * method makes one star
     *
     * @return the star with the yellow color
     */
    private GOval drawStar(double randomX, double randomY) {
        GOval result = new GOval(randomX, randomY, STAR_RADIUS, STAR_RADIUS);
        result.setFilled(true);
        result.setColor(Color.YELLOW);
        add(result);

        return result;
    }

    /**
     * draws the stars in the sky
     * @return  array of stars on the in the random location
     */
    private GOval[] drawStars() {
        GOval[] stars = new GOval[STARS_IN_THE_SKY];
        for (int i = 0; i < STARS_IN_THE_SKY; i++) {
            double randomWidth = Math.floor(Math.random() * getWidth());
            double randomHeight = Math.floor(Math.random() * getHeight());
            GOval star = drawStar(randomWidth, randomHeight);
            stars[i] = star;
        }
        return stars;
    }

    /**
     * method executes the animation in which stars start disappearing
     */
    private void starsDisappearing() {
        GOval[] stars = drawStars();
        for (int i = stars.length - 1; i >= 0; i--) {
            pause(PAUSE_TIME);
            stars[i].setVisible(false);
        }
    }

}

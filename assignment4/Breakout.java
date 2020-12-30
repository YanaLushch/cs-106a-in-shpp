package com.shpp.p2p.cs.ylushch.assignment4;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * File: ${Breakout}.java
 * ---------------------------
 * This is the game Breakout.
 * user plays with the paddle and bounce the ball so it could break the bricks
 * user has 3 turns. if user does not break all bricks during those turns the game is over and he/she loses.
 * if all bricks are broken - game is over and he/she won
 */

public class Breakout extends WindowProgram {
    /**
     * Width and height of application window in pixels
     */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    /**
     * Dimensions of game board (usually the same)
     */
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;

    /**
     * Dimensions of the paddle
     */
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;

    /**
     * Offset of the paddle up from the bottom
     */
    private static final int PADDLE_Y_OFFSET = 30;

    /**
     * Number of bricks per row
     */
    private static final int NBRICKS_PER_ROW = 10;

    /**
     * Number of rows of bricks
     */
    private static final int NBRICK_ROWS = 10;

    /**
     * Separation between bricks
     */
    private static final int BRICK_SEP = 4;

    /**
     * Width of a brick
     */
    private static final int BRICK_WIDTH =
            (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

    /**
     * Height of a brick
     */
    private static final int BRICK_HEIGHT = 8;

    /**
     * Radius of the ball in pixels
     */
    private static final int BALL_RADIUS = 10;

    /**
     * Offset of the top brick row from the top
     */
    private static final int BRICK_Y_OFFSET = 70;

    /**
     * Number of turns
     */
    private static final int NTURNS = 3;

    /**
     * paddle declaration
     */
    private GRect paddle;

    /**
     * Colors array
     */
    Color[] colors = {Color.red, Color.orange, Color.yellow, Color.green, Color.cyan};

    /**
     * integer which will be counting game to 3 or how many is needed
     */
    int gameCounter = 0;

    /**
     * how many bricks there are in the game
     */
    int brickCount = NBRICK_ROWS * NBRICKS_PER_ROW;

    /**
     * generates the instance
     */
    RandomGenerator rgen = RandomGenerator.getInstance();

    /**
     * boolean which is always true when the game is played
     * when you lose - it becomes automatically false
     */
    private Boolean playGame;

    //x and y velocity
    private double vx, vy;

    /**
     * runs the
     */
    public void run() {
        makeRows();
        addMouseListeners();
        buildPaddle();
        playWholeGame();
    }

    /**
     * plays all turns of the game
     * the game starts after the player clicks on the mouse
     * also if after determined quantity of turns all bricks are still not broken
     * the label with "You lost" appears
     *
     */
    private void playWholeGame() {
        while (gameCounter < NTURNS) {
            GOval ball = makeBall();
            add(ball);
            waitForClick();
            gameTurn(ball);
        }
        if (brickCount > 0){
            makeGameOverLabel("Game Over! You lost! Try one more time");
        }
    }

    /**
     * plays one game
     *it generates the first and the random move of the ball
     * plays the game by moving the ball and breaking the brick until turn is over
     * @param ball bounces and breaks the bricks
     */
    private void gameTurn(GOval ball) {
        playGame = true;

        vx = rgen.nextDouble(1.0, 3.0);
        if (rgen.nextBoolean(0.5))
            vx = -vx;
        vy = 8.0;
        while (playGame) {
            ball.move(vx, vy);
            bouncingWithWallsRules(ball);
            collideWithObjects(ball);
            if (brickCount <= 0){
                gameCounter += NTURNS;
                playGame = false;
                makeGameOverLabel("Game Over! You won! Congratulations!!");
            }
            pause(30);
        }
    }

    /**
     * method determines how the ball should bounce
     * after colliding with the wall
     * @param ball which collides with the wall
     */
    private void bouncingWithWallsRules(GOval ball){
        if (ball.getX() <= 0 || ball.getX() + 2* BALL_RADIUS >= WIDTH) {
            vx = -vx;
        }
        if (ball.getY() <= 0) {
            vy = -vy;
        }
        if (ball.getY() >= HEIGHT) {
            gameCounter++;
            playGame = false;
            remove(ball);
        }
    }

    /**
     * makes the label which notifies user about the Game over and the result win or lose
     */
    private void makeGameOverLabel(String result){
        GLabel label = new GLabel(result);
        double x = WIDTH - label.getWidth();
        double y = HEIGHT - label.getDescent();
        add(label, x, y);
    }

    /**
     * determines what happens when the ball collides with the brick and the paddle
     * @param ball which collides with the brick or paddle
     */
    private void collideWithObjects( GOval ball){
        GObject collider = getCollidingObject(ball);
        if (collider == paddle) {
            vy = -vy;
        } else if (collider != null) {
            vy = -vy;
            remove(collider);
            brickCount--;
        }
    }

    /**
     * method which builds the paddle
     */
    public void buildPaddle() {
        paddle = new GRect(WIDTH / 2.0 - PADDLE_WIDTH / 2.0, WIDTH - PADDLE_Y_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setFilled(true);
        add(paddle);
    }

    /**
     * method which moves the paddle with the paddle
     * @param e gets the position where the mouse is situated and moves the paddle to that position by X
     */
    public void mouseMoved(MouseEvent e) {
        if (e.getX() >= 0 && e.getX() < WIDTH - PADDLE_WIDTH) {
            paddle.setLocation(e.getX(), HEIGHT - PADDLE_Y_OFFSET);
        }
    }

    /**
     * method which makes the ball
     *
     * @return ball
     */
    private GOval makeBall() {
        GOval ball = new GOval(WIDTH / 2.0 - BALL_RADIUS, HEIGHT / 2.0 - BALL_RADIUS, BALL_RADIUS * 2, BALL_RADIUS * 2);
        ball.setFilled(true);
        ball.setColor(Color.BLACK);
        return ball;
    }

    /**
     * method checks if the ball collided with the object
     * @param ball which moves
     * @return object which has been collided with the ball OR if not collided - returns null
     */
    private GObject getCollidingObject(GOval ball) {
        if (getElementAt(ball.getX(), ball.getY()) != null){
            return getElementAt(ball.getX(), ball.getY());
        } else if(getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY()) != null){
            return getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY());
        } else if (getElementAt(ball.getX(), ball.getY() + 2 * BALL_RADIUS) != null){
            return getElementAt(ball.getX(), ball.getY() + 2 * BALL_RADIUS);
        } else  if (getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS) != null){
            return getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS);
        }
        return null;
    }


    /**
     * following lines of code will be about making colorful rows of bricks
     */

    /**
     * this method makes one brick
     * @param x is the offset x point of the brick
     * @param y is the offset y point of the brick
     * @param color is the color of the brick
     */
    public void makeBrick(double x, double y, Color color) {
        GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
        brick.setFilled(true);
        brick.setColor(color);
        add(brick);
    }

    /**
     * method makes the row of bricks
     * @param k the order of the row
     * @param color color which the row will have
     */
    private void makeRow(int k, Color color) {
        for (int i = 0; i < NBRICK_ROWS; i++) {
            makeBrick(i * (BRICK_WIDTH + BRICK_SEP),
                    BRICK_Y_OFFSET + k * (BRICK_HEIGHT + BRICK_SEP), color);
        }
    }

    /**
     * method sets the color for each row
     * @param row accepts the order of the row
     * @return the color
     */
    private Color setColorForRow(int row) {
        int index = (int) Math.floor(row / 2.0);
        return colors[index];
    }

    /**
     * makes all the rows
     */
    public void makeRows() {
        for (int k = 0; k < NBRICKS_PER_ROW; k++) {
            makeRow(k, setColorForRow(k));
        }
    }
}
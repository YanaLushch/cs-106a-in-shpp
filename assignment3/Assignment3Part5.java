package com.shpp.p2p.cs.ylushch.assignment3;

import com.shpp.cs.a.console.TextProgram;

/**
 * File: ${Assignment3Part5}.java
 * ---------------------------
 * This program runs the game
 * Player is the lucky person starts game with putting one dollar
 * program randomly flips the coin
 * if it is heads = program multiplies his win and does it till it is tails
 * the iteration lasts until tails
 * the game lasts until sum of iterations is more than 20 dollars
 * */

public class Assignment3Part5 extends TextProgram {

    /**
     * method runs the program
     */
   public void run() {
       println(startWholeGame());
   }

    /**
     * method starts one iteration of the game
     * it ends when it is tails
     * @return sum of money earned per one iteration
     * one iteration is until program flips coin with tails
     */
    private int startOneGame() {
        boolean isHeads = true;
        int bank = 1;
        while(isHeads){
            double random = Math.random();
            if (random >=0.5) {
                isHeads = false;
                println("This game you earned $" + bank);
            } else {
                isHeads = true;
                bank += bank;
            }
        }

        return bank;
    }

    /**
     *method executes whole game
     * whole game means - the lucky guy won more than 20 dollars
     * @return string with the total sum of money earned per whole game
     *
     */
    private String startWholeGame(){
        int totalWin = 0;
        while (totalWin < 20){
            totalWin += startOneGame();
            println("Your total is $" + totalWin);
        }
        return "This game, you earned $" + totalWin;
    }

}


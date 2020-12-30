package com.shpp.p2p.cs.ylushch.assignment5;


import com.shpp.cs.a.console.TextProgram;

import java.util.ArrayList;

/**
 * File: ${Assignment5Part1}.java
 * ---------------------------
 * This program counts syllables in a word!!
 */

public class Assignment5Part1 extends TextProgram {
    String vowels = "aeiouy";
    /**
     * Runs the program
     */
    public void run() {
        /* Repeatedly prompt the user for a word and print out the estimated
         * number of syllables in that word.
         */
        while (true) {
            String word = readLine("Enter a single word: ");
            println("  Syllable count: " + syllablesIn(word));
        }
    }

    /**
     * Given a word, estimates the number of syllables in that word according to the
     * heuristic specified in the handout.
     *
     * @param word A string containing a single word.
     * @return An estimate of the number of syllables in that word.
     */

    private int syllablesIn(String word) {
        int sylCounter = 0;
        //check if string ends with "e"
        word = ("e".indexOf(word.charAt(word.length()-1)) != -1) ? word.substring(0, word.length()-1) : word;

        ArrayList<Integer> findVowels = new ArrayList<>();
        //check if vowels are present in the string
        for (int i = 0; i< word.length(); i++){
            if (vowels.indexOf(word.charAt(i)) != -1) {
                findVowels.add(1);
                sylCounter += 1;
            }
            else {
                findVowels.add(-1);
            }
        }
        //if vowel is next to another vowels - we should not count it as syllable
        for (int i = 0; i < findVowels.size(); i++){
            if (findVowels.get(i).equals(1) && findVowels.get(i) != findVowels.get(findVowels.size() -1)){
                sylCounter = (findVowels.get(i).equals(1) && findVowels.get(i+1).equals(1)) ? sylCounter - 1 : sylCounter;
            }
        }
        //by default should be 1
        sylCounter = (sylCounter == 0) ? sylCounter + 1 : sylCounter;

        return sylCounter;
    }

}

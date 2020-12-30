package com.shpp.p2p.cs.ylushch.assignment5;


import com.shpp.cs.a.console.TextProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * File: ${Assignment5Part3}.java
 * ---------------------------
 * returns word which match your input
 */
public class Assignment5Part3 extends TextProgram {
    /**
     * runs the program
     */
    public void run() {
        ArrayList<String> dictionary =  readDictionary();

        while (true) {
            String threeChar = readLine("Enter a single word: ");
            randomWords(threeChar, dictionary);
        }

    }

    /**
     * method random word accepts three characters and find the words which match those 3 words
     * @param threeChar accepts 3 characters from user
     * @param dictionary accepts the whole dictionary in arraylist
     */
    private void randomWords(String threeChar, ArrayList<String> dictionary) {
        //split the words into 3 separate strings
        String[] splitUserWord = threeChar.toLowerCase().split("");
        ArrayList<Integer> idxOfMatchedChar;

        for (String word : dictionary) {
            //add in arraylist index of the symbol match
            //if there is no match - adds -1 into arraylist
            idxOfMatchedChar = Arrays
                    .stream(splitUserWord)
                    .map(item ->
                            word.indexOf(item))
                    .collect(Collectors.toCollection(ArrayList::new));
            //3 indexes should not be equal to -1
            if (idxOfMatchedChar.get(0) != -1 && idxOfMatchedChar.get(1) != -1 && idxOfMatchedChar.get(2) != -1) {
                // al three characters should be in the following order
                if (idxOfMatchedChar.get(0) < idxOfMatchedChar.get(1) && idxOfMatchedChar.get(0) < idxOfMatchedChar.get(2)
                        && idxOfMatchedChar.get(1) < idxOfMatchedChar.get(2)) {
                    println(word);

                }
            }
        }

    }

    /**
     * Method readDictionary which reads the whole dictionary once
     * @return the array list of words from the dictionary
     */
    private ArrayList<String> readDictionary(){
        ArrayList<String> dictionary = new ArrayList<>();
        try {
            //get file
            BufferedReader buffer = new BufferedReader(new FileReader("assets/en-dictionary.txt"));
            while (true) {
                //read line
                String line = buffer.readLine();
                //break if end
                if (line == null) {
                    break;
                }
                //add into array
                dictionary.add(line);
            }
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dictionary;
    }


}
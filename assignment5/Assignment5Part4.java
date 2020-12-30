package com.shpp.p2p.cs.ylushch.assignment5;


import com.shpp.cs.a.console.TextProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * File: ${Assignment5Part4}.java
 * ---------------------------
 * This program returns CSV parsed arrayList
 */

public class Assignment5Part4 extends TextProgram {
    /**
     * This method runs the program
     */
    public void run() {
        println(extractColumn("assets/food-origins.csv", 1));
    }

    /**
     * extractColumn returns the whole parsed arraylist column
     * @param filename accepts the name of the file
     * @param columnIndex accepts the index of the column needs to be parsed and returned
     * @return
     */
    private ArrayList<String> extractColumn(String filename, int columnIndex){
        ArrayList <String > printColumn = new ArrayList<>();
        try {
            //accepts the file
            BufferedReader buffer = new BufferedReader(new FileReader(filename));
            while (true) {
                //reads the line
                String line = buffer.readLine();
                //stops when read the whole file
                if (line == null) {
                    break;
                }
                //adds the indexColumn to the array
                printColumn.add(fieldsIn(line).get(columnIndex));
            }
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return printColumn;
    }

    /**
     * Method converts the line of code into the converted file
     * @return arraylist of parsed line
     */
    private ArrayList<String> fieldsIn(String line) {
        String comma = ",";
        //convert to string builder to be able to mutate the array
        StringBuilder withoutCommaInside = new StringBuilder(line);

        replaceQuotesWithAndSign(withoutCommaInside);
        //returns string which is split with comma,  surrounded by quotes and replaced with comma inside quotes
        // which has been temporarily changed for "&" symbol
        return  Arrays.stream(withoutCommaInside.toString().split(comma))
                .map(item -> item.replace("&", comma))
                .map(item -> "\"" + item + "\"")
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     *Method looks for comma and replace comma with "&" sign
     * @param withoutCommaInside string which should be parsed
     */
    private void replaceQuotesWithAndSign(StringBuilder withoutCommaInside){
        String quotes = "\"";
        Boolean isQuoted = false;
        //looping through the string
        for (int i = 0; i < withoutCommaInside.length(); i++){
            //if the quotes are in the string
            //check when the quotes opened
            //remove the quotes
            if (quotes.indexOf(withoutCommaInside.charAt(i)) != -1) {
                withoutCommaInside.setCharAt(i, '\0');
                isQuoted = !isQuoted;
            }
            //look for the comma in quotes
            //replace comma with & character
            if (isQuoted) {
                if (",".indexOf(withoutCommaInside.charAt(i)) != -1){
                    withoutCommaInside.setCharAt(i, '&');
                }
            }
        }
    }
}

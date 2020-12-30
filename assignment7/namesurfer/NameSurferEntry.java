package com.shpp.p2p.cs.ylushch.assignment7.namesurfer;

/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import java.util.Arrays;
import java.util.HashMap;

public class NameSurferEntry implements NameSurferConstants {

    private final String babyName;
    private final HashMap<Integer, Integer> ranks =
            new HashMap<>();


    private int tryParseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }

    /**
     * Creates a new NameSurferEntry from a data line as it appears
     * in the data file.  Each line begins with the name, which is
     * followed by integers giving the rank of that name for each
     * decade.
     */
    public NameSurferEntry(String line) {
        String[] splitLine = line.split(" ");
        babyName = splitLine[0];
        for (int i = 0; i <= NDECADES; i++) {
            Integer decade = START_DECADE  + i*10;
            int decadeValue = 0;
            try {
                decadeValue = tryParseInt(splitLine[i]);
            } finally {
                ranks.put(decade, decadeValue);
            }
        }
    }

    /* Method: getName() */

    /**
     * Returns the name associated with this entry.
     */
    public String getName() {
        return babyName;
    }


    /**
     * returns the name associated with this entry but with the capital first letter
     */
    public String getCapitalName(){
        return babyName.substring(0, 1).toUpperCase() + babyName.substring(1);
    }

    /* Method: getRank(decade) */

    /**
     * Returns the rank associated with an entry for a particular
     * decade.  The decade value is an integer indicating how many
     * decades have passed since the first year in the database,
     * which is given by the constant START_DECADE.  If a name does
     * not appear in a decade, the rank value is 0.
     */
    public int getRank(int decade) {
        return ranks.get(decade);
    }

    /* Method: toString() */

    /**
     * Returns a string that makes it easy to see the value of a
     * NameSurferEntry.
     */
    public String toString() {
        String preFinal = getName() + " [" + Arrays.stream(new HashMap[]{ranks})
                .map(Object::toString)
                .reduce("", (acc, x) -> x + " " + acc);
        return preFinal.substring(0, preFinal.length() - 1) + "]";
    }
}


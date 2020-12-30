package com.shpp.p2p.cs.ylushch.assignment6.Assignment6Part2;

public class HistogramEqualizationLogic {
    private static final int MAX_LUMINANCE = 255;

    /**
     * Given the luminances of the pixels in an image, returns a histogram of the frequencies of
     * those luminances.
     * <p/>
     * You can assume that pixel luminances range from 0 to MAX_LUMINANCE, inclusive.
     *
     * @param luminances The luminances in the picture.
     * @return A histogram of those luminances.
     */
    public static int[] histogramFor(int[][] luminances) {
        //array of 256 integers each int -  for each level of luminance
        int[] histogram = new int[256];
        //iterating through the array of pixel's height and width
        for (int i = 0; i < luminances.length; i++) {
            for (int k = 0; k < luminances[i].length; k++) {
                //count in each level of luminance into its integer within the array
                histogram[luminances[i][k]] += 1;
            }
        }
        return histogram;
    }

    /**
     * Given a histogram of the luminances in an image, returns an array of the cumulative
     * frequencies of that image.  Each entry of this array should be equal to the sum of all
     * the array entries up to and including its index in the input histogram array.
     * <p/>
     * For example, given the array [1, 2, 3, 4, 5], the result should be [1, 3, 6, 10, 15].
     *
     * @param histogram The input histogram.
     * @return The cumulative frequency array.
     */
    public static int[] cumulativeSumFor(int[] histogram) {
        //iterating through the histogram
        for (int i = 0; i < histogram.length; i++) {
            //logic of adding previous number to current each time
            if (i == 0) {
                histogram[0] = histogram[0];
            } else {
                histogram[i] += histogram[i - 1];
            }
        }
        return histogram;
    }

    /**
     * Returns the total number of pixels in the given image.
     *
     * @param luminances A matrix of the luminances within an image.
     * @return The total number of pixels in that image.
     */
    public static int totalPixelsIn(int[][] luminances) {
        //multiplying pixel's height on pixel's width
        return luminances.length * luminances[0].length;
    }

    /**
     * Applies the histogram equalization algorithm to the given image, represented by a matrix
     * of its luminances.
     * <p/>
     * You are strongly encouraged to use the three methods you have implemented above in order to
     * implement this method.
     *
     * @param luminances The luminances of the input image.
     * @return The luminances of the image formed by applying histogram equalization.
     */
    public static int[][] equalize(int[][] luminances) {
        //calling all previously created methods
        int[] histogram = histogramFor(luminances);
        int[] cumulativeHistogram = cumulativeSumFor(histogram);
        int totalPixels = totalPixelsIn(luminances);
        //creating the new array of newLuminance
        int[][] newLuminance = new int[luminances.length][luminances[0].length];
        //iterating through the array of pixel's height and width
        for (int i = 0; i < luminances.length; i++) {
            for (int k = 0; k < luminances[0].length; k++) {
                //calculating the new Luminance by the formula
                newLuminance[i][k] = MAX_LUMINANCE * cumulativeHistogram[luminances[i][k]] / totalPixels;
            }
        }
        return newLuminance;
    }
}

package com.shpp.p2p.cs.ylushch.assignment7.namesurfer;

/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes
 * or the window is resized.
 */

import acm.graphics.GCanvas;
import acm.graphics.GLabel;
import acm.graphics.GLine;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.List;

public class NameSurferGraph extends GCanvas
        implements NameSurferConstants, ComponentListener {

    private List<NameSurferEntry> entryList = new ArrayList<>();

    /**
     * Creates a new NameSurferGraph object that displays the data.
     */
    public NameSurferGraph() {
        addComponentListener(this);
    }


    /**
     * Clears the list of name surfer entries stored inside this class.
     */
    public void clear() {
        entryList.clear();
        update();
    }


    /* Method: addEntry(entry) */

    /**
     * Adds a new NameSurferEntry to the list of entries on the display.
     * Note that this method does not actually draw the graph, but
     * simply stores the entry; the graph is drawn by calling update.
     */
    public void addEntry(NameSurferEntry entry) {
        entryList.add(entry);
    }


    /**
     * Updates the display image by deleting all the graphical objects
     * from the canvas and then reassembling the display according to
     * the list of entries. Your application must call update after
     * calling either clear or addEntry; update is also called whenever
     * the size of the canvas changes.
     */
    public void update() {
        removeAll();
        drawGridAndDecade(getWidth(), getHeight());
        drawGraph(getWidth(), getHeight());
    }

    /**
     * Method which draws the line
     * @param x1 starting point offsetX
     * @param y1 starting point offsetY
     * @param x2 ending point offsetX
     * @param y2 ending point offsetY
     * @param color color of the line
     */
    public void line(double x1, double y1, double x2, double y2, Color color) {
        GLine grid = new GLine(x1, y1, x2, y2);
        grid.setColor(color);
        add(grid);
    }

    /**
     * @param text is the text of the label
     * @param gridX the starting point of the label offset X
     * @param gridY the starting point of the label offset Y
     * @param color color of the label
     */

    public void label(String text, double gridX, double gridY, Color color) {
        GLabel label = new GLabel(text);
        double vx = gridX;
        double vy = gridY - label.getDescent();
        label.setFont("SansSerif-plain");
        label.setColor(color);
        add(label, vx, vy);
    }

    /**
     * defining which color should have the graph
     * @param idx index of the graph
     * @return color
     */

    public Color color(int idx){
        Color[] colors = {Color.blue, Color.red, Color.magenta, Color.black};
        int colorIndex = (int) (idx % 4.0);
        return colors[colorIndex];
    }

    /**
     *Method which draws the grid and the decade label
     * @param appWidth the responsive width of the app
     * @param appHeight the responsive height of the app
     */
    public void drawGridAndDecade(int appWidth, int appHeight) {

        int maxLineY = GRAPH_MARGIN_SIZE;
        int zeroLineY = appHeight - GRAPH_MARGIN_SIZE;
        // draw horizontal lines
        line(0, maxLineY, appWidth, maxLineY, Color.BLACK);
        line(0, zeroLineY, appWidth, zeroLineY, Color.BLACK);
        //draw vertical lines and decade-labels
        for (int i = 0; i < NDECADES; i++) {
            int decade = START_DECADE + i * 10;
            double decadeX = 10 + i * (appWidth / (double) NDECADES);
            // draw vertical line
            line(decadeX, 0, decadeX, appHeight, Color.BLACK);
            label(Integer.toString(decade), decadeX, appHeight, Color.BLACK);
        }

    }

    /**
     * Method which draws the whole graph
     *  @param appWidth the responsive width of the app
     * @param appHeight the responsive height of the app
     */
    public void drawGraph(int appWidth, int appHeight){
        int yRange = appHeight - 2*GRAPH_MARGIN_SIZE;
        for (int n = 0; n < entryList.size(); n++) {
            Color color = color(n);
            NameSurferEntry entry = entryList.get(n);
            Double prevDecadeX = null;
            Integer prevEntryY = null;
            //loop over the decades
            for (int i = 0; i < NDECADES; i++) {
                int decade = START_DECADE + i * 10;
                double decadeX = 10 + i * (appWidth / (double) NDECADES);
                // draw graph
                int entryValue = entry.getRank(decade);
                int entryY = (int) (entryValue / (double) MAX_RANK * yRange) + GRAPH_MARGIN_SIZE;
                if (i > 0) {
                    line(prevDecadeX, prevEntryY, decadeX, entryY, color);
                    label( entry.getCapitalName() + " " + (entryY - 20), decadeX, entryY, color);
                }
                prevDecadeX = decadeX;
                prevEntryY = entryY;
            }

        }
    }


    /* Implementation of the ComponentListener interface */
    public void componentHidden(ComponentEvent e) {
    }

    public void componentMoved(ComponentEvent e) {
    }
    //if the window gets resized
    public void componentResized(ComponentEvent e) {
        update();
    }

    public void componentShown(ComponentEvent e) {
    }
}

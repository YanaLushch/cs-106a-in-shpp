package com.shpp.p2p.cs.ylushch.assignment7.namesurfer;

/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import com.shpp.cs.a.simple.SimpleProgram;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NameSurfer extends SimpleProgram implements NameSurferConstants {
    private JTextField babyName;
    private JButton graph;
    private JButton clear;
    private NameSurferGraph nameGraph;
    private NameSurferDataBase nameDataBase;


    /* Method: init() */


    /**
     * This method has the responsibility for reading in the data base
     * and initializing the interactors at the top of the window.
     */
    public void init() {
        babyName = new JTextField(20);
        graph = new JButton("Graph");
        clear = new JButton("Clear");
        nameGraph = new NameSurferGraph();
        nameDataBase = new NameSurferDataBase(NAMES_DATA_FILE);
        this.add(nameGraph);
        this.add(new JLabel("Name :"), "North");
        this.add(babyName, "North");
        this.add(graph, "North");
        this.add(clear, "North");
        addActionListeners();
    }

	/* Method: actionPerformed(e) */

    /**
     * This class is responsible for detecting when the buttons are
     * clicked, so you will have to define a method to respond to
     * button actions.
     */
    public void actionPerformed(ActionEvent e) {
        //if button graph gets clicked
        if (e.getActionCommand().equals("Graph")) {
            NameSurferEntry entry = nameDataBase.findEntry(babyName.getText());
            if (entry != null) {     //checks if the value entered is in the list
                nameGraph.addEntry(entry);
                nameGraph.update();
            }
            //if button clear gets clicked
        } else if (e.getActionCommand().equals("Clear")){
            nameGraph.clear();
        }

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tut.ac.za.wandi;

import eventsClass.EventsClass;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.setDefaultLookAndFeelDecorated;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Wandi Mtshali
 */
public class mySecureGUI extends JFrame {

    private JPanel inputPanel, buttonJPanel, displayJPanel;
    private JTextArea displayArea;
    private JButton saveButton, loadButton, searchButton, deleteButton, clearButton, editButton;
    private JTextField evenNameField, eventsDateField, categoryField, locationField;
    private JLabel eventNameJLabel, eventsDateJLabel, categoryJLabel, locationJLabel;

    //ArrayList<EventsClass> eventList = new ArrayList<>();
    public mySecureGUI() {

        setTitle("My Event Management System");
        setSize(500, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //panel
        inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        //labes 
        eventNameJLabel = new JLabel("Events Name: ");
        eventsDateJLabel = new JLabel(" Event Date (yyyy-MM-dd): ");
        categoryJLabel = new JLabel("Category: ");
        locationJLabel = new JLabel("Location: ");

        //textField
        evenNameField = new JTextField(20);
        eventsDateField = new JTextField(20);
        categoryField = new JTextField(20);
        locationField = new JTextField(20);

        inputPanel.add(eventNameJLabel);
        inputPanel.add(evenNameField);

        inputPanel.add(eventsDateJLabel);
        inputPanel.add(eventsDateField);

        inputPanel.add(categoryJLabel);
        inputPanel.add(categoryField);

        inputPanel.add(locationJLabel);
        inputPanel.add(locationField);

        add(inputPanel, BorderLayout.NORTH);

        //panel 
        displayJPanel = new JPanel(new BorderLayout(10, 10));

        displayArea = new JTextArea(20, 20);
        displayJPanel.add(displayArea);
        add(displayJPanel, BorderLayout.CENTER);

        //buttons
         buttonJPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
         
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");
        searchButton = new JButton("Search");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        editButton = new JButton("Edit");

        buttonJPanel.add(saveButton);
        buttonJPanel.add(loadButton);
        buttonJPanel.add(searchButton);
        buttonJPanel.add(deleteButton);
        buttonJPanel.add(clearButton);
        buttonJPanel.add(editButton);
        
       
       
        add(buttonJPanel, BorderLayout.SOUTH);

        pack();

        setVisible(true);

    }

}

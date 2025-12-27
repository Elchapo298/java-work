/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GymMebershipGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.processing.Messager;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Wandi Mtshali
 */
public class GymMebershipGUI extends JFrame {
    
    private JPanel headerPanel, namePanel, surnamePanel, idPanel, genderPanel, inputPanel, radioPanel, displayPanel, centerPanel, optionPanel, trainerPanel;
    private JLabel nameLabel, surnameLabel, idLabel, genderLabel, headerLabel, contracTypeLabel, selectCheckBoxLabel;
    private JTextField nameField, surnameField, idField;
    private JRadioButton monthToMonthRadioButton, sixMonthRadioButton, annualRadioButton;
    private JCheckBox trainerCheckBox;
    private JTextArea displayTextArea;
    private JComboBox comboBox;
    private ButtonGroup buttonGroup;
    private JScrollPane jScrollPane;
    private JMenuBar menuBar;
    private JMenu aboutMenu, fileMenu;
    private JMenuItem saveItem, readItem, contactMenuItem, displayMenuItem;
    String message;
    
    public GymMebershipGUI() {
        
        setSize(900, 950);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Gym Membership");
        
        headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerLabel = new JLabel("Membership Form");
        headerLabel.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        headerLabel.setForeground(Color.BLUE);
        headerLabel.setFont(new Font(Font.SANS_SERIF, Font.ITALIC + Font.BOLD, 20));
        
        headerPanel.add(headerLabel);
        
        add(headerPanel, BorderLayout.NORTH);
        
        inputPanel = new JPanel(new GridLayout(4, 1, 1, 1));
        inputPanel.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "Clint details"));
        namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameLabel = new JLabel("Name: ");
        nameField = new JTextField(10);
        
        surnamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        surnameLabel = new JLabel("Surname: ");
        surnameField = new JTextField(10);
        
        idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idLabel = new JLabel("id no: ");
        idField = new JTextField(10);
        
        genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderLabel = new JLabel("Gender: ");
        
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        
        surnamePanel.add(surnameLabel);
        surnamePanel.add(surnameField);
        idPanel.add(idLabel);
        idPanel.add(idField);
        genderPanel.add(genderLabel);
        
        comboBox = new JComboBox();
        comboBox.addItem("Male");
        comboBox.addItem("Female");
        genderPanel.add(comboBox);
        
        inputPanel.add(namePanel);
        inputPanel.add(surnamePanel);
        inputPanel.add(idPanel);
        inputPanel.add(genderPanel);
        
        centerPanel = new JPanel(new GridLayout(2, 1));
        
        centerPanel.add(inputPanel);
        
        radioPanel = new JPanel(new GridLayout(2, 1, 1, 1));
        radioPanel.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "Contract Options"));
        contracTypeLabel = new JLabel("Type of contract: ");
        monthToMonthRadioButton = new JRadioButton("Month-to-month");
        sixMonthRadioButton = new JRadioButton("Six months");
        annualRadioButton = new JRadioButton("Annual");
        //selectCheckBoxLabel = new JLabel("Select the checkbox if you need a personal trainer");
        trainerCheckBox = new JCheckBox("Select the checkbox if you need a personal trainer ");
        
        radioPanel.add(contracTypeLabel);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(monthToMonthRadioButton);
        buttonGroup.add(sixMonthRadioButton);
        buttonGroup.add(annualRadioButton);
        
        optionPanel = new JPanel(new GridLayout(1, 4, 0, 0));
        optionPanel.add(monthToMonthRadioButton);
        optionPanel.add(sixMonthRadioButton);
        optionPanel.add(annualRadioButton);
        
        trainerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        trainerPanel.add(trainerCheckBox);
        
        radioPanel.add(optionPanel);
        radioPanel.add(trainerPanel);
        
        centerPanel.add(radioPanel);
        
        add(centerPanel, BorderLayout.CENTER);
        displayPanel = new JPanel();
        
        displayTextArea = new JTextArea(20, 40);
        jScrollPane = new JScrollPane(displayTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        displayPanel.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "Comments"));
        
        displayPanel.add(jScrollPane);
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        aboutMenu = new JMenu("About");
        
        contactMenuItem = new JMenuItem("Contact");
        saveItem = new JMenuItem("Save");
        saveItem.addActionListener(new save());
        readItem = new JMenuItem("READ");
        readItem.addActionListener(new read());
        displayMenuItem = new JMenuItem("Display");
        displayMenuItem.addActionListener(new displayText());
        
        fileMenu.add(saveItem);
        fileMenu.add(readItem);
        fileMenu.add(displayMenuItem);
        
        aboutMenu.add(contactMenuItem);
        menuBar.add(fileMenu);
        menuBar.add(aboutMenu);
        setJMenuBar(menuBar);
        
        add(displayPanel, BorderLayout.SOUTH);
        
        setVisible(true);
        
    }
    
    private class save implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            File file = new File("C:\\Users\\Wandi Mtshali\\Desktop\\myFile.txt");
            String message = getText();
            String line = "";
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
                bw.write(message+"\n");
                JOptionPane.showMessageDialog(null, "SAVED!!");
                bw.close();
                nameField.setText("");
                surnameField.setText("");
                idField.setText("");
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "FILE NOT FOUND!!!");
            }
            
        }
        
    }
    
    private class displayText implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            displayTextArea.setText(getText());
            nameField.setText("");
            surnameField.setText("");
            idField.setText("");
            
        }
        
    }
    
    private String getText() {
        
        String name = nameField.getText();
        String surname = surnameField.getText();
        String id = idField.getText();
        String genderNumber = null;
        int gender = comboBox.getSelectedIndex();
        if (gender == 1) {
            genderNumber = "Male";
        } else {
            genderNumber = "Female";
            
        }
        String contractType = "";
        
        if (monthToMonthRadioButton.isSelected()) {
            contractType = "month-to-month";
        } else if (sixMonthRadioButton.isSelected()) {
            
            contractType = "Six-Month";
        } else if (annualRadioButton.isSelected()) {
            contractType = "Annual";
        }
        return message = " " + name + " " + surname + " " + id + " " + genderNumber + " " + contractType + " ";
    }

    private class read implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            File file = new File("C:\\Users\\Wandi Mtshali\\Desktop\\myFile.txt");
            
            String line ="";
            String nextLine ="";
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                while ((line = br.readLine())!=null) {                    
                nextLine+= line+"\n";
                displayTextArea.setText(nextLine);
                    
                
                }
                
                
            } catch (FileNotFoundException ex) {
                
            
            } catch (IOException ex) {
                Logger.getLogger(GymMebershipGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}

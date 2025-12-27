/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MetricConveterGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Wandi Mtshali
 */
public class MetricConveterGUI extends JFrame{
    
    private JPanel dispayPanel, inputButtonPanel, converPanel,optionPanel,controlPanel,convertButton,centerPanel;
    private JButton numberButton,conveButton;
    private  JLabel optionLabel;
    private JRadioButton killometerRadioButton,millRadioButton;
    private JTextArea diplayArea;
    private JTextField textField;
    
    
    public MetricConveterGUI(){
    
        
        setTitle("Metric Conveter");
        setVisible(true);
        setSize(500,350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //FIRST PENAL
        converPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5,5));
        optionLabel = new JLabel("Distanece in Miles: ");
        textField = new JTextField(5);
        
        converPanel.add(optionLabel);
        converPanel.add(textField);
        add(converPanel,BorderLayout.NORTH);
        
        //display panel
       
        dispayPanel = new JPanel(new BorderLayout(10,10));
        diplayArea = new JTextArea(5,5);
        dispayPanel.add(diplayArea);
        
        
        //KEYPAD 1
        
        inputButtonPanel = new JPanel(new GridLayout(4,3,10,10));
          for (int i = 1; i <= 9; i++) {
            inputButtonPanel.add(new JButton(String.valueOf(i)));
        }
          inputButtonPanel.add(new JButton("Clear"));
          inputButtonPanel.add(new JButton("0"));
          inputButtonPanel.add(new JButton("."));
          
          
        //convert Panel 2
        
        convertButton = new JPanel(new BorderLayout());
        conveButton = new JButton("Convert!");
        convertButton.add(conveButton, BorderLayout.SOUTH);
        
        
        
        //control panel
        controlPanel = new JPanel(new GridLayout(2, 1,10,5));
        controlPanel.add(inputButtonPanel);
        controlPanel.add(convertButton);
        
        //both center panels
        
        
        centerPanel = new JPanel(new GridLayout(1,2,10,10));
        centerPanel.add(dispayPanel,BorderLayout.WEST);
        centerPanel.add(controlPanel,BorderLayout.EAST);
        
        add(centerPanel);
        
        
        
        
        
        setVisible(true);
    }

    
    
}

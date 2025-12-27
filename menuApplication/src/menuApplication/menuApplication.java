/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuApplication;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Wandi Mtshali
 */
public class menuApplication extends JFrame {

    private JPanel mainPanel, headingPanel, customerPanel, namePanel, surnamePanel, ticketsPanel, homeTeamPanel, awaysTeamPanel, costPricePanel, numberTicketsPanel, totalAmountPanel, buttonPanel, centerPanel;
    private JLabel headingLabel, nameLabel, surnameLabel, homeTeamLabel, awayLabel, costLabel, numberOfTicketsLabel, totalAmountLabel;
    private JTextField nameTextField, surnameTextField, homeTeamTextField, awaysTextField, costTextField, totalAmountTextField;
    private JButton buyButton, clearButton, exitButton;

    public menuApplication() {

        mainPanel = new JPanel(new BorderLayout());
        headingPanel = new JPanel(new BorderLayout());
        headingLabel = new JLabel("soccer Match Tickets");
        
        customerPanel = new JPanel(new GridLayout(2,1,10,10));
        namePanel = new JPanel(new FlowLayout());
        nameLabel = new JLabel("Name");
        nameTextField = new JTextField(15);
        
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);
        
        surnamePanel = new JPanel(new FlowLayout());
        surnameLabel = new JLabel();
        surnameTextField = new JTextField(15);
        surnamePanel.add(surnameLabel);
        surnamePanel.add(surnameTextField);
        
        customerPanel.add(namePanel);
        customerPanel.add(surnamePanel);
        
        
        
        ///second
        ticketsPanel = new JPanel(new GridLayout(5,1,10,10));
        homeTeamPanel = new JPanel(new FlowLayout());
        homeTeamLabel = new JLabel("home team");
        homeTeamTextField = new JTextField(15);
        
       
        
        
        

    }

}

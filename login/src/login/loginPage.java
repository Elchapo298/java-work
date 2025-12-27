/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Wandi Mtshali
 */
public class loginPage extends JFrame {

    private JPanel headingPanel, detailsPanel, usernamePanel, passwordPanel, buttonPanel, mainPanel;
    private JLabel loginLabel, usernameLabel, passwordLabel;
    private JButton submitButton, clearButton, exitButton;
    private JTextField usernameTextField, passwordTextField;

    public loginPage() {

        setTitle("LOGIN PAGE");
        setSize(500, 500);
        JFrame.setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel = new JPanel(new BorderLayout());
        headingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        loginLabel = new JLabel("Login");
        loginLabel.setFont(new Font(Font.SANS_SERIF,Font.ITALIC+ Font.BOLD,20));
        loginLabel.setForeground(Color.red);
        loginLabel.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        headingPanel.add(loginLabel);
        mainPanel.add(headingPanel, BorderLayout.NORTH);
        
         

        usernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        usernameLabel = new JLabel("Username: ");
        usernameTextField = new JTextField(15);
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameTextField);

        passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordLabel = new JLabel("Password:  ");
        passwordTextField = new JTextField(15);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordTextField);

        detailsPanel = new JPanel(new GridLayout(2, 1, 10, 10));

        detailsPanel.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "login in"));

        detailsPanel.add(usernamePanel);
        detailsPanel.add(passwordPanel);
        mainPanel.add(detailsPanel, BorderLayout.CENTER);

        buttonPanel = new JPanel(new FlowLayout());
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
        pack();

    }

}

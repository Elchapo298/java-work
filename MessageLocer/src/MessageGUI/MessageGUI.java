/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MessageGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Wandi Mtshali
 */
public class MessageGUI extends JFrame {

    private JTextArea plainMessageArea, encryptedMessageArea;
    private JLabel messageLabel;
    private JButton encryptButton;
    private JMenuBar menuBar;
    private JPanel plainMessagePanel, encrypPanel, encryptButtonPanel, headerPanel, mainPanel;

    public MessageGUI() {

        setTitle(" Secure Message");
        setSize(450, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //header
        headerPanel = new JPanel(new BorderLayout());

        messageLabel = new JLabel("Message Encryptor");
        messageLabel.setBorder(new SoftBevelBorder(10, Color.blue, Color.blue));

        //headerPanel.setBorder(new TitledBorder(new LineBorder(Color.BLUE,3),"Message Encryptor" ));
        // messageLabel.setFont();
        // clienteJPanel.setBorder(new TitledBorder(new LineBorder(Color.black, 1), " Clinet details"));
        headerPanel.add(messageLabel, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        //plain text
        mainPanel = new JPanel(new GridLayout(1, 3, 10, 10));

        plainMessagePanel = new JPanel(new BorderLayout());
        plainMessageArea = new JTextArea(10, 20);

        plainMessagePanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Plain Message"));
        plainMessagePanel.add(plainMessageArea);

        mainPanel.add(plainMessagePanel);

        // encryption button
        encryptButtonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        //encryptButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        encryptButton = new JButton("Encryption Message>>>>>>");
        encryptButtonPanel.add(new JPanel());
        encryptButtonPanel.add(encryptButton);
        encryptButtonPanel.add(new JPanel());
        mainPanel.add(encryptButtonPanel, BorderLayout.SOUTH);

        encrypPanel = new JPanel(new BorderLayout());
        encryptedMessageArea = new JTextArea(10, 20);
        encrypPanel.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "Encryption Message"));

        encrypPanel.add(encryptedMessageArea);

        mainPanel.add(encrypPanel);

        add(mainPanel);
        setVisible(true);

    }private class convert implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           
            
            
            
        }
    
    
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fileAndGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.setDefaultLookAndFeelDecorated;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Wandi Mtshali
 */
public class fileAndGui extends JFrame {

    private JPanel headingPanel, mainPanel, detailPanel, writePanel, outPanel, buttonPanel;
    private JLabel headingLabel;
    private JButton saveButton, clearButton, displayButton,exitButton;
    private JTextArea inputTextArea, displayTextArea;

    public fileAndGui() {
        setSize(500, 500);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("DANKO!!");

        mainPanel = new JPanel(new BorderLayout());

        headingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        headingLabel = new JLabel("whats with you");
        headingLabel.setFont(new Font(Font.SANS_SERIF, Font.ITALIC + Font.BOLD, 20));
        headingLabel.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        headingLabel.setForeground(Color.red);

        mainPanel.add(headingLabel, BorderLayout.NORTH);

        detailPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        //inputaText
        inputTextArea = new JTextArea(10, 20);
        inputTextArea.setBorder(new TitledBorder(new LineBorder(Color.blue), "input data"));

        writePanel = new JPanel(new FlowLayout());
        writePanel.add(inputTextArea);
        detailPanel.add(writePanel);

        outPanel = new JPanel(new FlowLayout());
        displayTextArea = new JTextArea(10, 20);

        displayTextArea.setBorder(new TitledBorder(new LineBorder(Color.blue), "output Data"));
        outPanel.add(displayTextArea);

        detailPanel.setBorder(new LineBorder(Color.blue));
        detailPanel.add(outPanel);

        mainPanel.add(detailPanel, BorderLayout.CENTER);

        buttonPanel = new JPanel(new FlowLayout());

        saveButton = new JButton("Save");
        saveButton.addActionListener(new saveButtonFile());
        clearButton = new JButton("Clear");
        clearButton.addActionListener(new clearText());
        displayButton = new JButton("Display");
        displayButton.addActionListener(new readFromFile());
        
        exitButton = new JButton("Exit");
        exitButton.addActionListener(new exitAction());
        

        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(exitButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
        pack();

    }

    public class saveButtonFile implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String inputInfo = inputTextArea.getText();

            try {

                BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Wandi Mtshali\\Desktop\\data.txt",true));

                bw.write(inputInfo+"\n");
                JOptionPane.showMessageDialog(null, "saved to file");
                bw.flush();
                bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }

    public class clearText implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            inputTextArea.setText("");
            displayTextArea.setText("");

        }

    }

    public class readFromFile implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Wandi Mtshali\\Desktop\\data.txt"));

                String line = "";
                String text = "";

                try {
                    while ((line = br.readLine()) != null) {

                        text += line + "\n";
                        System.out.println(text);
                        displayTextArea.setText(text);

                    }
                    br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            } catch (FileNotFoundException ex) {

                ex.printStackTrace();
            }

        }

    }public class exitAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            System.exit(0);
        
        }
    
    
    
    
    }

}

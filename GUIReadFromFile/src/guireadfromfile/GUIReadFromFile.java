/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guireadfromfile;

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
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Wandi Mtshali
 */
public class GUIReadFromFile extends JFrame {

    /**
     * @param args the command line arguments
     */
    private JPanel textAreaPanel, plainMessagePanel, encryptedMessagePanel;
    private JMenu jMenuPlain, jMenuEncrption, otherMenu;
    private JMenuBar menuBar;
    private JMenuItem readMenuItem, writeMenuItem, clearMenuItem;
    private JTextArea plainTextArea, encryptionTextArea;

    public GUIReadFromFile() {
        setTitle("Secure Messages");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        setSize(500, 500);
        menuBar = new JMenuBar();

        jMenuPlain = new JMenu("plain Text");
        writeMenuItem = new JMenuItem("SAVE TO FILE");
        jMenuPlain.add(writeMenuItem);
        writeMenuItem.addActionListener(new save_to_file());

        jMenuEncrption = new JMenu("Encryption text");
        readMenuItem = new JMenuItem("GET DATA");
        readMenuItem.addActionListener(new read_to_file());

        jMenuEncrption.add(readMenuItem);

        otherMenu = new JMenu("Other");
        clearMenuItem = new JMenuItem("CLEAR");
        clearMenuItem.addActionListener(new clear_textArea());
        otherMenu.add(clearMenuItem);

        menuBar.add(jMenuPlain);
        menuBar.add(jMenuEncrption);
        menuBar.add(otherMenu);
        this.setJMenuBar(menuBar);

        textAreaPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        plainMessagePanel = new JPanel();
        plainTextArea = new JTextArea(20, 20);
        plainMessagePanel.add(plainTextArea);
        textAreaPanel.add(plainMessagePanel);

        encryptedMessagePanel = new JPanel();
        encryptionTextArea = new JTextArea(20, 20);
        encryptedMessagePanel.add(encryptionTextArea);

        textAreaPanel.add(encryptedMessagePanel);

        add(textAreaPanel);
        pack();
        setVisible(true);
    }

    public class save_to_file implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Wandi Mtshali\\Desktop\\summary.txt", true));
                String line = "";

                bw.write(plainTextArea.getText());
                bw.close();

            } catch (IOException ex) {

                ex.printStackTrace();
            }
        }

    }

    public class read_to_file implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BufferedReader br = null;
            try {

                br = new BufferedReader(new FileReader("C:\\Users\\Wandi Mtshali\\Desktop\\summary.txt"));

                String line = plainTextArea.getText();
                encryptionTextArea.setText("");

                while ((line = br.readLine()) != null) {
                    encryptionTextArea.setText(line);

                }

            } catch (FileNotFoundException ex) {

                ex.printStackTrace();

            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {

                try {
                    br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        }

    }

    public class clear_textArea implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            plainTextArea.setText("");
            encryptionTextArea.setText("");
        }

    }

}

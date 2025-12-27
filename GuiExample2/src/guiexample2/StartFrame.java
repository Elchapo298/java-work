/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiexample2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StartFrame extends JFrame {

    private JPanel jpMain, jpInfo, jpButtons;
    private JTextField jtfName, jtfAge;
    private JLabel jlName, jlAge, jlPass;
    private JPasswordField jpfPass;
    private JButton jbOk, jbClear;
    private JComboBox jcbType;
    private JRadioButton jrbMale, jrbFemale;
    private JCheckBox jcbYes;
    private ButtonGroup bgGender;

    private JTextArea jtaData;
    private JScrollPane scrollPane;

    private JMenuBar jmbMain;
    private JMenu jmFile, jmAbout;
    private JMenuItem jmiText, jmiTextPlusImage, jmiAbout;

    public void create() {

        setLayout(new BorderLayout());
        jpMain = new JPanel(new GridLayout(2, 1));

        jpInfo = new JPanel(new GridLayout(0, 2));
        jpButtons = new JPanel();

        makePanelInfo();

        makeTextArea();

        makePanelButtons();

        makeMenu();

        jpMain.add(jpInfo);
        jpMain.add(scrollPane);

        add(jpMain, BorderLayout.CENTER);
        add(jpButtons, BorderLayout.SOUTH);
		
        setJMenuBar(jmbMain);
		
        setSize(300, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public ImageIcon makeIcon(int type) {
        ImageIcon originalIcon;
        switch (type) {
            case 1:
                originalIcon = new ImageIcon("images/cool.png");
                break;
            case 2:
                originalIcon = new ImageIcon("images/sad.png");
                break;
            default:
                originalIcon = new ImageIcon("images/phone.png");
        }

        Image image = originalIcon.getImage();
        int desiredWidth = 20; // Set your desired width
        int desiredHeight = 20; // Set your desired height
        Image scaledImage = image.getScaledInstance(desiredWidth, desiredHeight, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        return scaledIcon;
    }

    private void makePanelInfo() {
        jlName = new JLabel("Name");
        jlAge = new JLabel("Age");
        jlPass = new JLabel("Password");

        jtfName = new JTextField(20);
        jtfAge = new JTextField(20);
        jpfPass = new JPasswordField(20);

        jpInfo.add(jlName);
        jpInfo.add(jtfName);

        jpInfo.add(jlAge);
        jpInfo.add(jtfAge);

        jpInfo.add(jlPass);
        jpInfo.add(jpfPass);

        jcbType = new JComboBox();
        jcbType.addItem("First");
        jcbType.addItem("Second");
        jcbType.addItem("Third");

        jpInfo.add(new JPanel());
        jpInfo.add(jcbType);

        jrbMale = new JRadioButton("Male", true);
        jrbFemale = new JRadioButton("Female");

        bgGender = new ButtonGroup();
        bgGender.add(jrbMale);
        bgGender.add(jrbFemale);

        jpInfo.add(jrbMale);
        jpInfo.add(jrbFemale);

        jcbYes = new JCheckBox("Yes");

        jpInfo.add(new JPanel());
        jpInfo.add(jcbYes);
    }

    private void makeTextArea() {
        jtaData = new JTextArea(10, 20);//int rows, int columns
        jtaData.setLineWrap(true); // Enable line wrapping
        jtaData.setWrapStyleWord(true); // Wrap at word boundaries
        scrollPane = new JScrollPane(jtaData);
    }

    private void makePanelButtons() {
        jbOk = new JButton("Ok");
        jbOk.addActionListener(new jbOKEvent());
        jbClear = new JButton("Clear");
        jbClear.addActionListener(new jbClearEvent());

        jpButtons.add(jbOk);
        jpButtons.add(jbClear);
    }

    private void makeMenu() {
        jmbMain = new JMenuBar();
        jmFile = new JMenu("File");

        jmbMain.add(jmFile);

        jmiText = new JMenuItem("A text-only menu item");
        jmiText.addActionListener(new jMenuEvent());
        jmFile.add(jmiText);

        jmiTextPlusImage = new JMenuItem("Both text and icon", makeIcon(1));
        jmiTextPlusImage.addActionListener(new jMenuEvent());
        jmFile.add(jmiTextPlusImage);

        jmAbout = new JMenu("About");
        jmbMain.add(jmAbout);
        jmiAbout = new JMenuItem("About", makeIcon(3));
        jmiAbout.addActionListener(new jMenuEvent());
        jmAbout.add(jmiAbout);
    }

    private class jbOKEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String name = jtfName.getText();
            String age = jtfAge.getText();
            String gender = "Male";
            String check = "False";
            char pass[] = jpfPass.getPassword();
            
            String type = jcbType.getSelectedItem().toString();
            if(jrbFemale.isSelected())
            {
                gender = "Female";
            }
 
            if(jcbYes.isSelected())
            {
                check = "True";
            }
               
            String data = jtaData.getText();

            JOptionPane.showMessageDialog(getContentPane(), "Hello " + name);
        }

    }

    private class jbClearEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JOptionPane.showMessageDialog(getContentPane(), "Clearing the textfields and return others to default");

            jtfAge.setText("");
            jtfName.setText("");

            jpfPass.setText("");
            jcbType.setSelectedIndex(0);
            jrbMale.setSelected(true);
            jcbYes.setSelected(false);
            
            jtaData.setText("");
        }

    }

     private class jMenuEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jmiText) {
                JOptionPane.showMessageDialog(null, "text");
            } else if (e.getSource() == jmiTextPlusImage) {
                JOptionPane.showMessageDialog(null, "icon");
            } else {
                JOptionPane.showMessageDialog(null, "about");
            }

        }

    }

}


package za.ac.tut.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Wandi Mtshali
 */
public class GymMemebershipFrame extends JFrame {

    private JPanel headinJPanel;
    private JPanel clienteJPanel;
    private JPanel nameJPanel;
    private JPanel surnameJPanel;
    private JPanel idNOJPanel;
    private JPanel genederJPanel;
    private JPanel contractorsJPanel;
    private JPanel personalTrainerOptionJPanel;
    private JPanel memebershipJPanel;
    private JPanel commentsJPanel;
    private JPanel btnsJPanel;
    private JPanel headingClintCombinedJPanel;
    private JPanel memebershipCommentsComboinedJPanel;
    private JPanel mainJPanel;

    private JLabel headingJLabell;
    private JLabel nameJLabel;
    private JLabel surnameJLabel;
    private JLabel idNOJLabel;
    private JLabel genderJLabel;
    private JLabel personalTrainerJLabel;
    private JLabel contractTypeJLabel;

    //textField
    private JTextField nameJTextField;
    private JTextField surnameJTextField;
    private JTextField idNOJTextField;

    private JComboBox genderComboBox;

    //radio buttons
    private JRadioButton monthToMonthJRadioButton;
    private JRadioButton sixMonthJRadioButton;
    private JRadioButton anaualJRadioButton;

    //checkBox
    private JCheckBox personalTrainerChkBx;

    //buttonGroup
    private ButtonGroup btnButtonGroup;

    //textArea
    private JTextArea commentArea;

    //scrollpane
    private JScrollPane scroollabltxtArea;

    //private button
    private JButton applyButton;

    public GymMemebershipFrame() {

        setTitle("Gym Memebership");
        setSize(1900, 1950);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        headinJPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        clienteJPanel = new JPanel(new GridLayout(4, 1, 1, 1));
        clienteJPanel.setBorder(new TitledBorder(new LineBorder(Color.black, 1), " Clinet details"));

        nameJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        surnameJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idNOJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genederJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        contractorsJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        personalTrainerOptionJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        memebershipJPanel = new JPanel(new GridLayout(2, 1, 1, 1));
        memebershipJPanel.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "Contract Options"));

        commentsJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        btnsJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headingClintCombinedJPanel = new JPanel(new BorderLayout());
        memebershipCommentsComboinedJPanel = new JPanel(new BorderLayout());
        mainJPanel = new JPanel(new BorderLayout());

        headingJLabell = new JLabel("Membership form");
        headingJLabell.setFont(new Font(Font.SANS_SERIF, Font.ITALIC + Font.BOLD, 20));
        headingJLabell.setForeground(Color.red);
        headingJLabell.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));

        nameJLabel = new JLabel("Name:     ");
        surnameJLabel = new JLabel("Surname:      ");
        idNOJLabel = new JLabel("Id no:        ");
        genderJLabel = new JLabel("Gender:      ");
        contractTypeJLabel = new JLabel("Type of Contract:  ");
        personalTrainerJLabel = new JLabel("Select the checkbox if you need a personal trainer  ");

        nameJTextField = new JTextField(10);
        surnameJTextField = new JTextField(10);
        idNOJTextField = new JTextField(10);

        genderComboBox = new JComboBox();
        genderComboBox.addItem("Male");
        genderComboBox.addItem("female");

        monthToMonthJRadioButton = new JRadioButton("Month-to-month");
        sixMonthJRadioButton = new JRadioButton("Six month");
        anaualJRadioButton = new JRadioButton("Annual");

        personalTrainerChkBx = new JCheckBox();

        btnButtonGroup = new ButtonGroup();
        btnButtonGroup.add(monthToMonthJRadioButton);
        btnButtonGroup.add(sixMonthJRadioButton);
        btnButtonGroup.add(anaualJRadioButton);

        commentArea = new JTextArea(20, 40);
        commentArea.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "comments"));//
        scroollabltxtArea = new JScrollPane(commentArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        applyButton = new JButton("APPLY");

        headinJPanel.add(headingJLabell);

        nameJPanel.add(nameJLabel);
        nameJPanel.add(nameJTextField);

        surnameJPanel.add(surnameJLabel);
        surnameJPanel.add(surnameJTextField);

        idNOJPanel.add(idNOJLabel);
        idNOJPanel.add(idNOJTextField);

        genederJPanel.add(genderJLabel);
        genederJPanel.add(genderComboBox);

        clienteJPanel.add(nameJPanel);
        clienteJPanel.add(surnameJPanel);
        clienteJPanel.add(idNOJPanel);
        clienteJPanel.add(genederJPanel);

        headingClintCombinedJPanel.add(headinJPanel, BorderLayout.NORTH);
        headingClintCombinedJPanel.add(clienteJPanel, BorderLayout.CENTER);

        contractorsJPanel.add(contractTypeJLabel);
        contractorsJPanel.add(monthToMonthJRadioButton);
        contractorsJPanel.add(sixMonthJRadioButton);
        contractorsJPanel.add(anaualJRadioButton);

        personalTrainerOptionJPanel.add(personalTrainerJLabel);
        personalTrainerOptionJPanel.add(personalTrainerChkBx);

        memebershipJPanel.add(contractorsJPanel);
        memebershipJPanel.add(personalTrainerOptionJPanel);

        commentsJPanel.add(scroollabltxtArea);

        memebershipCommentsComboinedJPanel.add(memebershipJPanel, BorderLayout.NORTH);
        memebershipCommentsComboinedJPanel.add(commentsJPanel, BorderLayout.CENTER);

        btnsJPanel.add(applyButton);

        mainJPanel.add(headingClintCombinedJPanel, BorderLayout.NORTH);
        mainJPanel.add(memebershipCommentsComboinedJPanel, BorderLayout.CENTER);
        mainJPanel.add(btnsJPanel, BorderLayout.SOUTH);

        add(mainJPanel);

   
        setVisible(true);

    }
}

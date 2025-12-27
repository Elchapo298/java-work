/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Wandi Mtshali
 */
public class myReaderApp {
    public static void main(String[] args) {
        
        
        File f = new File("regstats.txt");
        String line ="";
        int totalStudents =0;
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            
            while ((line =br.readLine())!= null) {                
                String[] tokens = line.split(",");
                if (tokens.length == 2) {
                    
                    int students = Integer.parseInt(tokens[1]);
                    totalStudents+=students;
                }
                
                
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null," error writing to file");
        } catch (IOException ex) {
            Logger.getLogger(myReaderApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        File filNew = new File("summary.txt");
        
        try {
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(filNew));
            bw.write("Total students registered in Computer Science is: "+totalStudents);
            bw.close();
           
            JOptionPane.showMessageDialog(null,"done writting");
        } catch (IOException ex) {
            
            Logger.getLogger(myReaderApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       // System.out.println(" total: "+totalStudents);
        
    }
}

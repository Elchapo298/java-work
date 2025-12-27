/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.exams.exception;

import javax.swing.JOptionPane;

/**
 *
 * @author Wandi Mtshali
 */
public class Mark {
    
    private double value;

    public Mark(double value) throws IncorrectMarkException{
        setValue(value);
    }

    public void setValue(double value) throws IncorrectMarkException{
       
        if ((value <0.0)|| (value > 100)) {
            
            throw new IncorrectMarkException("the value of the mark is incorrect");
            
        }else{
         
            this.value = value;
            JOptionPane.showMessageDialog(null, value +" stored");
        }
        
        
        
        

    }

    public double getValue() {
        return value;
    }
    
    
    public static void main(String[] args){
    
        
        String input =null;
        String output =null;
        String message = "Enter your mark for the test.";
        
        input = JOptionPane.showInputDialog(message);
        Mark mark = null;
        double testMark = 0.0;
        
        try {
            
             testMark = Double.parseDouble(input);
             mark = new Mark(testMark);
            
            
            
            
        } catch (IncorrectMarkException exp) {
            output = exp.getMessage();
            JOptionPane.showMessageDialog(null, output);
            
            
        }catch(Exception exp){
        
            output = exp.getMessage();
            JOptionPane.showMessageDialog(null,output);
            
        
        }
                
        
        
    }
}

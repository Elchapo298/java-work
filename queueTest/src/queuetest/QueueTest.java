/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package queuetest;

import java.awt.font.NumericShaper;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Wandi Mtshali
 */
public class QueueTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Queue<Integer> numberQueue = new LinkedList<>();
        
        if (numberQueue.isEmpty()) {
            
            System.out.println("Queue is empty.");
            
            numberQueue.add(1);
            numberQueue.add(2);
            numberQueue.add(3);
            numberQueue.add(4);
            System.out.println("added");
            
            
            for (Integer integer : numberQueue) {
                
                
                System.out.println(numberQueue+"is in this queue");
            }
                    
        }for (Integer integer : numberQueue) {
                
                
                System.out.println(numberQueue+"is in this queue");
            }
        
        
    }
    
}

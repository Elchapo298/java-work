/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package threadpractise;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wandi Mtshali
 */
public class ThreadPractise {

    /**
     * @param args the command line arguments
     */
    private static boolean isOrderValid = false;
    private static boolean isPayment = false;
    
    public static void main(String[] args) {
        // TODO code application logic here
        Thread validationThread = new  OrderValidation();
        Thread paymentThread = new paymentProcessing();
        Thread Shipping = new ShippingThread();
        
        
        validationThread.setPriority(Thread.MAX_PRIORITY);
        paymentThread.setPriority(Thread.NORM_PRIORITY);
        Shipping.setPriority(Thread.MIN_PRIORITY);
        validationThread.start();
        paymentThread.start();
        Shipping.start();
    }
    static class OrderValidation extends Thread {
        @Override
        public void run() {
            synchronized (ThreadPractise.class) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                isOrderValid = true;
                System.out.println("Order validation completed.");
                ThreadPractise.class.notify();
          }
        }
    }
     static class paymentProcessing extends Thread {
        @Override
        public void run() {
            synchronized (ThreadPractise.class) {
                try {
                    while (!isOrderValid) {
                        System.out.println("waiting for order...");
                        ThreadPractise.class.wait();
                    }
                    System.out.println("Payment processing started.");
                    Thread.sleep(1000);
                    isPayment = true;
                    System.out.println("Payment processing completed.");
                    threadpractise.ThreadPractise.class.notifyAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class ShippingThread extends Thread {
        @Override
        public void run() {
            synchronized (threadpractise.ThreadPractise.class) {
                try {
                    while (!isPayment) {
                        System.out.println("waiting for payment.....");
                        threadpractise.ThreadPractise.class.wait();
                    }
                    System.out.println("Shipping order....");
                    Thread.sleep(1000);
                    System.out.println("order shipping successfully.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

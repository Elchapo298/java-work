/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SwiftBookingSystem;

/**
 *
 * @author Wandi Mtshali
 */
public class SwiftBookingSystem {
    // Shared resources

    private static boolean isBookingValidated = false;
    private static boolean isPaymentProcessed = false;

    public static void main(String[] args) {
        // Creating and starting threads
        Thread bookingValidationThread = new BookingValidationThread();
        Thread paymentProcessingThread = new PaymentProcessingThread();
        Thread confirmationThread = new ConfirmationThread();

        bookingValidationThread.setPriority(Thread.MAX_PRIORITY);
        paymentProcessingThread.setPriority(Thread.NORM_PRIORITY);
        confirmationThread.setPriority(Thread.MIN_PRIORITY);

        bookingValidationThread.start();
        paymentProcessingThread.start();
        confirmationThread.start();

    }

    static class BookingValidationThread extends Thread {

        @Override
        public void run() {
            synchronized (SwiftBookingSystem.class) {
                System.out.println("Booking validation started.");
                try {
                    Thread.sleep(1000); // Simulate time taken for validation
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isBookingValidated = true;
                System.out.println("Booking validation completed.");
                SwiftBookingSystem.class.notifyAll(); // Notify waiting threads
            }
        }
    }

// Implement the PaymentProcessingThread class here
    static class PaymentProcessingThread extends Thread {

        @Override
        public void run() {
            // Your implementation goes here

            synchronized (SwiftBookingSystem.class) {

                try {
                    while (!isBookingValidated) {
                        System.out.println("Waiting for validation to complete");
                        SwiftBookingSystem.class.wait();

                    }

                    System.out.println("payment processing started  ");
                    Thread.sleep(1000);
                    isPaymentProcessed = true;
                    System.out.println("payment processing completed");
                    SwiftBookingSystem.class.notifyAll();

                } catch (Exception e) {
                    e.printStackTrace();
                    
                }

            }
        }
    }

    static class ConfirmationThread extends Thread {

        @Override
        public void run() {
            synchronized (SwiftBookingSystem.class) {
                try {
                    while (!isPaymentProcessed) {
                        System.out.println("Waiting for payment processing...");
                        SwiftBookingSystem.class.wait(); // Wait for payment to be processed
                    }
                    System.out.println("Sending confirmation...");
                    Thread.sleep(1000); // Simulate time taken for confirmation
                    System.out.println("Booking confirmed successfully.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

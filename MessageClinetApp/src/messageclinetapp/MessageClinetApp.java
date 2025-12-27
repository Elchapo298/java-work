/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package messageclinetapp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wandi Mtshali
 */
public class MessageClinetApp {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
            Socket socket = null;
        try {
            // TODO code application logic here

            InetAddress address = InetAddress.getByName("127.0.0.1");
           socket = new Socket(address, 8080);

            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

            for (int i = 0; i < 10; i++) {
                printWriter.println("hello,this is message number " + (i + 1));
            }
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
        
                try {
                    System.out.println("closing communication socket...");
                    socket.close();
                } catch (IOException ex) {
                
                    ex.printStackTrace();
                }
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package helloclientapp;

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
public class HelloClientApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            Socket socket =null;
        try {

            InetAddress addr = InetAddress.getByName("127.0.0.1");

            socket   = new Socket(addr, 8080);
            System.out.println("IP address: "+addr);
            
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
            
            out.println("yebo!!");

        } catch (UnknownHostException ex) {

            ex.printStackTrace();

        } catch (IOException ex) {

            ex.printStackTrace();
        }finally{
        
            //System.out.println("closing communication socket....");
                try {
                    
                    System.out.println("sbonge, closing communication socket...");
                    socket.close();
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        }
    }

}

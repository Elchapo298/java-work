/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package messagesserverapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wandi Mtshali
 */
public class MessagesServerApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket socket = null;
        BufferedReader br = null;
        try {
            
            socket = new ServerSocket(8080);
            socket.accept();
            br = new BufferedReader(new InputStreamReader(socket.getOption()));
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

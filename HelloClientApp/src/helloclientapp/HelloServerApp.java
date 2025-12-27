/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helloclientapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.standard.Severity;

/**
 *
 * @author Wandi Mtshali
 */
public class HelloServerApp {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedReader br = null;
        String data;

        try {

            serverSocket = new ServerSocket(8080);
            socket = serverSocket.accept();
            System.out.println("connection established: " + socket);

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            data = br.readLine();
            System.out.println("Message recivied from client: " + data);

        } catch (IOException ex) {

            ex.printStackTrace();
        } finally {

            System.out.println("closing....");
            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }
}

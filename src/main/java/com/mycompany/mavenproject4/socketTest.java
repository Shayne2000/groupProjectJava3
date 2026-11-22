/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject4;
import java.io.*;
import java.net.*;

/**
 *
 * @author Shayne
 */

class serverThread extends Thread{
    
    Socket soc;
    clientThread client;
    
    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(1234);
            soc = ss.accept();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            System.out.println("server is waiting");
            System.out.println("Client says: " + in.readLine());
            
        } catch (IOException ex) {
            System.getLogger(socketTest.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        System.out.println("end server thread");
    }
    
    public Socket getSocket() {
        return soc;
    }
    
    public void setClient(clientThread o) {
        client = o;
    }
}


class clientThread extends Thread{
    
    Socket socket;
    
    @Override
    public void run(){
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.getLogger(clientThread.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            
            socket = new Socket("localhost", 1234);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Send message to server");
            out.println("Hello from Client!");
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("end client thread");
    }
    
    public Socket getSocket() {
        return socket;
    }
}

public class socketTest {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        
        
        serverThread a = new serverThread();
        clientThread b = new clientThread();
        
        
        
        a.start();
        
        b.start();
        
        
        
//        BufferedReader in;
//        try {
//            in = new BufferedReader(new InputStreamReader(b.getSocket().getInputStream()));
//            System.out.println("Client says: " + in.readLine());
//        } catch (IOException ex) {
//            System.getLogger(socketTest.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
//        }
        
        
        
        
        
    }
}

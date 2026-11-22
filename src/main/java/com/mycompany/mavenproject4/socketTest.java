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

class handCheakingListener extends Thread{
    ServerSocket ss ;
    handCheakingListener() {
        try {
            ss = new ServerSocket(1234);
        } catch (IOException ex) {
            System.getLogger(handCheakingListener.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        start();
    }
    
    @Override
    public void run() {
        while (true){
            try {
                Socket socket = ss.accept();
                new serverThread(socket);
            } catch (IOException ex) {
                System.getLogger(handCheakingListener.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
            
    }
}

class serverThread extends Thread{
    
    Socket soc;
    
    serverThread(Socket s){
        soc = s;
        System.out.println("Server is constructed");
        start();
        
    }
    
    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            System.out.println("server is waiting");
            System.out.println("Client says: " + in.readLine());
            
        } catch (IOException ex) {
            System.getLogger(socketTest.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        System.out.println("end server thread");
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
    
}

public class socketTest {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        new handCheakingListener();
        
        clientThread a = new clientThread();
        clientThread b = new clientThread();
        
        
        
        a.start();
        
        b.start();
        
        
        
        
        
    }
}

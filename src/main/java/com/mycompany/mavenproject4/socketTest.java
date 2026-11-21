/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject4;
import java.io.IOException;
import java.net.*;

/**
 *
 * @author Shayne
 */
public class socketTest {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        
        try {
            ServerSocket ss = new ServerSocket(1234);
            Socket soc = ss.accept();
            System.out.println("pass");
        } catch (IOException ex) {
            System.getLogger(socketTest.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }
}

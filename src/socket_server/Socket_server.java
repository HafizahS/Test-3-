/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Socket_server {

   private static final long MEGABYTE = 1048576; //1024 x 1024 = 1048576

    public static long bytesToMegabytes(long memory) {
        return memory / MEGABYTE;
    }
    
    public static void main(String[] args) {
        
        try
        {
            ServerSocket ser = new ServerSocket(8080);
            Socket sock = ser.accept();
            
           BufferedReader ed = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String tmp = ed.readLine();
            System.out.print("I Received :"+tmp);
            
      
       
              Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
            PrintStream pr = new PrintStream(sock.getOutputStream());
            String str = "Memory Use:"+memory+" bytes";
            pr.println(str);
           
            
    
       
        }catch(Exception ex){}
               
        
    
                    
            
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.io.*;
import java.net.*;

/**
 *
 * @author Nicolo'
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    ServerSocket server=null;
    Socket socketClient=null;
    
    int porta=6789;
    
    DataInputStream in;
    DataOutputStream out;
    
    public Socket attendi() throws IOException{
    
        System.out.println("connessione");
        server=new ServerSocket(porta);
        System.out.println("server attivo");
        socketClient=server.accept();
        
        server.close();
        
        in=new DataInputStream(socketClient.getInputStream());
        out=new DataOutputStream(socketClient.getOutputStream());
        
        return socketClient;
    }
    
    public static void main(String[] args) throws IOException {
        Server s=new Server();
        s.attendi();
    }
    
}

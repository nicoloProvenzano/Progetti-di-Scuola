/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import java.io.*;
import java.net.*;
//https://www.youtube.com/watch?v=yEh_VVqzLNU
/**
 *
 * @author Nicolo'
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    
    Socket mioSocket=null;
    int porta= 6789;
    DataInputStream in;
    DataOutputStream out;
    
    public Socket connetti() throws IOException{
    
        try {
            mioSocket=new Socket(InetAddress.getLocalHost(),porta);
        } catch (UnknownHostException ex) {
            System.out.println("host sconosciuto");
        }
        
        in=new DataInputStream(mioSocket.getInputStream());
        out=new DataOutputStream(mioSocket.getOutputStream());
        
        System.out.println("connessione eseguita");
        //System.out.println(""+in.readLine());
        
        return mioSocket;
    }
    
    public static void main(String[] args) throws IOException {
        Client s=new Client();
        s.connetti();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototypeDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Nicolo'
 */

//questa e' la classe dove provo il programma, essenzialmente e' presente
//la richiesta delle informazioni solo una volta per oggetto (in questo caso uno studente)
//e la clonazione dell'oggetto senza dover richiedere all'utente nessuna infomazione
public class PrototypeDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{

        //ero indeciso tra lo scanner e il bufferReader ma con quest ultimo avrei
        //dovuto fare i parse per la media e l'id
        //mnetre con lo scanner no, devo tenere in cosiderazione che
        //lo scanner legge stringhe meno lunghe del buffer ma fa da solo il parse
        
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner tastiera=new Scanner(System.in);
        
        //prendo il nome
        System.out.println("dimmi il nome dello studente");
        String nome=tastiera.next();
        
        //prendo l'id'
        System.out.println("dimmi l'id");
        int id=tastiera.nextInt();
        
        //prendo la media
        System.out.println("dimmi la media");
        double media=tastiera.nextDouble();
        
        InformazioniAlunno rs1=new InformazioniAlunno(id,nome,media);
        
        rs1.mostraRegistro();
        System.out.println("");
        
        //registro alunni tra le parentesi e' un cast al tipo ResgistroAlunni
         InformazioniAlunno rs2 = (InformazioniAlunno) rs1.getClone();
         
         //questo e' il clone del primo registro
         rs2.mostraRegistro();
    }
    
}
//una futura evoluzione del programma potrebbe consistere nel
//modificare solo certi aspetti dell'oggetto clonato
//o avere una copia di backup

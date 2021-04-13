/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototypeDemo;

/**
 *
 * @author Nicolo'
 */
//classe dell'oggetto, si possono aggiungere altri attributi come
//l'indirizzo di casa o il numero telefonico
public class InformazioniAlunno implements Prototype{
    
    protected int id;
    protected String nome;
    protected double media;

    public InformazioniAlunno(int id, String nome, double media) {
        this.id = id;
        this.nome = nome;
        this.media = media;
    }

    public InformazioniAlunno() {
        
        System.out.println("informazione alunno");
    }
    
    //mostra gli attributi
    public void mostraRegistro(){
    
        System.out.println("id:"+id+" nome:"+nome+" media:"+media);
    }
    
    //metodo implementato dall'interfaccia,
    //clona gli attributi dell'oggeto su cui e' chiamato
    //non clona l'oggetto in se 
    public Prototype getClone(){
        
        return new InformazioniAlunno(id,nome,media);
    }
    
}
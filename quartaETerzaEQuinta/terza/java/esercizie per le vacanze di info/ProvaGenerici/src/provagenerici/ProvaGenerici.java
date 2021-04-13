/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provagenerici;

/**
 *
 * @author Nicolo'
 */
public class ProvaGenerici <K,V>{
    
    private K key;
    private V value;
    
    public ProvaGenerici(K key,V value){
    
    this.key=key;
    this.value=value;
    
    
    
    }

    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        ProvaGenerici<Integer,String> prova= new ProvaGenerici<Integer,String>(8,"ciao");
        System.out.println("la chiave e' "+prova.getKey()+" e il contenuto e' "+prova.getKey());
    }
    
}

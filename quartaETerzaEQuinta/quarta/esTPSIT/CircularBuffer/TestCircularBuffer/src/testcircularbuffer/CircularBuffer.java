/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcircularbuffer;

/**
 *
 * @author Nicolo'
 */
public class CircularBuffer<T> implements MultipleBuffer {
    
    protected int lunghezza;
    protected String msg;
    protected int contatore;//count
    protected int posPrimo;//first
    protected String[] buffer;
    
    protected Object consumer= new Object();
    protected Object producer= new Object();

    public CircularBuffer(int i) {
        
        this.lunghezza=i;
        posPrimo=contatore=0;
        buffer=((String[]) new Object[lunghezza]);
    }

    @Override
    public Object take() throws InterruptedException {
        
        synchronized (consumer){
        
            while(contatore==0){
            
                try{
                
                    consumer.wait();
                } catch(InterruptedException e){ System.out.println("interrotto"); }
            }
            msg=buffer[posPrimo];
            contatore-=1;
            posPrimo=(posPrimo+1)%buffer.length;
        }
        synchronized (producer) {
        
            producer.notify();
        }
        
        return msg;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void put(Object e) throws InterruptedException {
        
        synchronized (producer){
        
            while(contatore==lunghezza){
            
                try{
                
                    producer.wait();
                }catch(InterruptedException d){ System.out.println("interrotto"); }
            }
            int next=(posPrimo+contatore)%lunghezza;
            buffer[next]=(String) e;
            contatore+=1;
        }
        
        synchronized(consumer){
        
            consumer.notify();
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

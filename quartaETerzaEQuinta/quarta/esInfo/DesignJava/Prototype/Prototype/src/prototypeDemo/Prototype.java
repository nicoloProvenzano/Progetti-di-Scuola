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
//interfaccia minimale
public interface Prototype {
    
    //il metodo che viene implementato nella classe Informazioni alunno
    public Prototype getClone();
}
//quando usare questo design pattern:
//- quando si vogliono istanziare le classi a runtime(durante l'esecuzione)
//- quando il costo per creare un oggetto e' costoso o complicato
//- quando vuoi tenere il numer di classi il piu' basso possibile in una applicazione
//- quando l'applicazione del client deve 
//  essere ignara della ceazione degli oggetti e della loro rappresentazione
//
//vantaggi:
//- riduce il bisogno di sotto classi
//- nasconde le colplessita' della creazione degi oggetti
//- il client puo' avere nuovi oggetti senza sapere quale tipo di oggetto sara'
//- ti permette di aggiungere o togliere oggetti durante l'esecuzione
// (quest'ultima per me e' il vantaggio piu' grande visto che permette una flessibilta' elevata)
//
//
//svantaggi:
//- ecessivo per un progetto che usa pochissimi oggeti o che non ha un'enfasi marcata sull'estensione della catena dei prototipi
//- nascone al client classi di podotti reali
//- ogni sottoclasse di protype deve implementare il metodo clone() 
//che puo' essere particolarmente difficile quando le clasi in considerazione esistono gia'
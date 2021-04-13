/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Competizioni;

import static Competizioni.Utilities.readFromFile;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author francesco.barsotti
 */
public class Competizione {

    /**
     * @param args the command line arguments
     */
    public static final int CODICE = 0;
    public static final int NOME = 1;
    public static final int TIPO = 2;

    protected String codice;
    protected String nome;
    protected String tipo;
    protected ArrayList<String> elencoCompetizioni;
    protected ArrayList<String> elencoIncontri;

    public Competizione(String[] a) throws FileNotFoundException {
        this.codice = a[CODICE];
        this.nome = a[NOME];
        this.tipo = a[TIPO];
        this.elencoCompetizioni=new ArrayList<>();
        for (int i = 3; i < a.length; i++) {
            this.elencoCompetizioni.add(a[i]);
        }
        this.elencoIncontri=new ArrayList<>();
        readIncontri(this.codice);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.codice);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Competizione other = (Competizione) obj;
        if (!Objects.equals(this.codice, other.codice)) {
            return false;
        }
        return true;
    }

    public String getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public ArrayList<String> getElencoCompetizioni() {
        return elencoCompetizioni;
    }

    public ArrayList<String> getElencoIncontri() {
        return elencoIncontri;
    }

    public boolean addData(String data) {
        if (!elencoCompetizioni.contains(data)) {
            elencoCompetizioni.add(data);
            return true;
        }
        return false;
    }

    public boolean addIncontro(String incontro) {
        if (!elencoIncontri.contains(incontro)) {
            elencoIncontri.add(incontro);
            return true;
        }
        return false;
    }

    public void readIncontri(String id) throws FileNotFoundException {
        for (String[] s : readFromFile("Incontri.csv")) {
            if (s[0] == id) {
                for (int i = 1; i < s.length; i++) {
                    elencoIncontri.add(s[i]);
                }
            }
        }
    }

    public ArrayList<String> getCalendario() {
        ArrayList<String> ris = elencoCompetizioni;
        for (String s : elencoIncontri) {
            ris.add(s);
        }
        return ris;
    }

    @Override
    public String toString() {
        return "Competizione{" + "codice=" + codice + ", nome=" + nome + ", tipo=" + tipo + ", elencoCompetizioni=" + elencoCompetizioni + '}';
    }

    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        System.out.println("ciao");
        
        Competizioni c=new Competizioni("Competizioni.csv");
        
        System.out.println(c);
        System.out.println(c.getCompetizioneById("OII"));
        System.out.println(c.sovrapposizioneDate("OPS", "OPS"));
        System.out.println(c.sovrapposizioneDate("OII", "OII"));
        System.out.println(c.sovrapposizioneDate("OM", "OII"));
        System.out.println(c.sovrapposizioneDate("OII", "OPS"));
        System.out.println(c.tab.get(3));
        System.out.println(c.tab.get(1));
    }
    
}

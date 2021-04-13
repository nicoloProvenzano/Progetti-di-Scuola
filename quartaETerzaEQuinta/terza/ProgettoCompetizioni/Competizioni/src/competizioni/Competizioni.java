/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Competizioni;

import static Competizioni.Utilities.readFromFile;
    import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author francesco.barsotti
 */
public class Competizioni {

    protected ArrayList<Competizione> tab;
    protected String pathname;
    
    public Competizioni(String filename) throws FileNotFoundException {
        pathname=filename;
        tab=new ArrayList<>();
        ArrayList<String[]> arr=readFromFile(pathname);
        convert(arr);
    }

    protected void convert(ArrayList<String[]> arr) throws FileNotFoundException {
        for (String[] s : arr) {
            Competizione c = new Competizione(s);
            this.tab.add(c);
        }
    }

    public Competizione getCompetizioneById(String id) {
        for (Competizione cp : tab) {
            if (cp.getCodice().equals(id)) {
                return cp;
            }
        }
        return null;
    }

    public boolean sovrapposizioneDate(String c1, String c2) {
        Competizione cc1 = getCompetizioneById(c1);
        Competizione cc2 = getCompetizioneById(c2);
        for (String data : cc1.getCalendario()) {
            if (cc2.getCalendario().contains(data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Competizioni{" + "tab=" + tab + '}';
    }

    
}

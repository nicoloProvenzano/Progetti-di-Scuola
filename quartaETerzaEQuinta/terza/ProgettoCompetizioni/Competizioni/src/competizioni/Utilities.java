/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Competizioni;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author antor
 */
public abstract class Utilities {

    public static ArrayList<String[]> readFromFile(String fileName) throws FileNotFoundException {
        Scanner scan = new Scanner(new FileReader(fileName));
        String[] row = null;
        ArrayList<String[]> ret = new ArrayList<>();

        while (scan.hasNextLine()) {
            row = scan.nextLine().split(",");
            ret.add(row);

        }
        return ret;
    }

}

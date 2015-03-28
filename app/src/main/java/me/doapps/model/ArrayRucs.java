package me.doapps.model;

import java.util.ArrayList;

/**
 * Created by william on 28/03/2015.
 */
public class ArrayRucs {
    ArrayList<String> rucs = new ArrayList<String>();

    public void addRuc(String ruc){
        rucs.add(ruc);
    }

    public ArrayList<String> getRucs(){
        return rucs;
    }
}

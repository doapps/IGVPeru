package me.doapps.model;

import java.util.ArrayList;

/**
 * Created by william on 28/03/2015.
 */
public class ArrayRucs {
    ArrayList<String> rucs = new ArrayList<String>();

    public void addRuc(String ruc){
        boolean exists = false;
        for(int i=0;i<rucs.size();i++){
            if(ruc.equalsIgnoreCase(rucs.get(i))){
                exists = true;
            }
        }
        if(!exists){
            rucs.add(ruc);
        }
    }

    public ArrayList<String> getRucs(){
        return rucs;
    }
}

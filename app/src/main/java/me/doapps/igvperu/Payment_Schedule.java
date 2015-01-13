package me.doapps.igvperu;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class Payment_Schedule extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment__schedule);
        String[] show;
        show=Buscar(" ");
        ArrayAdapter<String> adapter;
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,show);
        GridView lv=(GridView)findViewById(R.id.gridViewResultado);
        lv.setAdapter(adapter);
    }

    public String[] Buscar(String ruc){
        char CharRuc;
        String[] show=null;
        if(!ruc.equals(" ")){
            CharRuc=ruc.charAt(ruc.length()-1);
            Toast.makeText(this,"Resultado de la búsqueda, parámetro último número del RUC: "+CharRuc,Toast.LENGTH_LONG).show();
            Toast.makeText(this,"Resultado de la búsqueda, parámetro último número del RUC: "+CharRuc,Toast.LENGTH_LONG).show();
        }else{
            show=new String[]{"SUNAT","RUC","-",
                    "MES","NORMAL","BUEN CONTRIBUYENTE",
                    "ENERO","-","-","FEBRERO","-","-","MARZO","-","-",
                    "ABRIL","-","-","MAYO","-","-","JUNIO","-","-",
                    "JULIO","-","-","AGOSTO","-","-","SEPTIEMBRE","-","-",
                    "OCTUBRE","-","-","NOVIEMBRE","-","-","DICIEMBRE","-","-"};
        }
        return show;
    }
}

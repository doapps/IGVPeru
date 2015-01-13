package me.doapps.igvperu;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

public class Payment_Schedule extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronograma__pago);
        Mensaje();
    }

    public void Mensaje(){
        Toast.makeText(this,"HOLA",Toast.LENGTH_SHORT).show();
    }
}

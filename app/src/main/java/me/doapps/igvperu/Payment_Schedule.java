package me.doapps.igvperu;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import me.doapps.model.OpenHelper;

public class Payment_Schedule extends ActionBarActivity{
    EditText editTextRuc;
    Button buttonSearchRuc;
    OpenHelper ObjSqlite=new OpenHelper(this,"IGVPeru",null,3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment__schedule);
        try {
            String[] show;
            show=Search(" ");
            ArrayAdapter<String> adapter;
            adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,show);
            GridView lv=(GridView)findViewById(R.id.gridViewResultado);
            lv.setAdapter(adapter);
            editTextRuc=(EditText)findViewById(R.id.editTextRuc);
            buttonSearchRuc=(Button)findViewById(R.id.buttonBuscarRuc);
            buttonSearchRuc.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String Ruc=editTextRuc.getText().toString();
                    if(Ruc.length()==11){
                        Search(Ruc);
                    }else{
                        Toast.makeText(Payment_Schedule.this,"Wrong Format!\nEnter again please!  ",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }catch (Exception e){
            Log.d(null,"ERROR Payment_Schedule onCreate: "+e.getMessage());
        }

    }

    public String[] Search(String ruc){
        try {
            String[] show=null;
            Log.d(null,"RUC"+ruc);
            if(!ruc.equals(" ")){
                Object[][] Result=ObjSqlite.Search("schedule",new String[]{"Period","RegularPayment","SpecialPayment"}," lastNumRuc='"+ruc.charAt(10)+"' AND status=1");
                if(Result!=null){
                    Toast.makeText(this,"i=0 j=0 => "+Result[0][0].toString(),Toast.LENGTH_LONG).show();
                    Toast.makeText(this,"i=0 j=1 => "+Result[0][1].toString(),Toast.LENGTH_LONG).show();
                    Toast.makeText(this,"i=0 j=2 => "+Result[0][2].toString(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this,"Not Data",Toast.LENGTH_LONG).show();
                }
            }else{
                show=new String[]{"SUNAT","RUC","-",
                        "MES","NORMAL","BUEN CONTRIBUYENTE",
                        "ENERO","-","-","FEBRERO","-","-","MARZO","-","-",
                        "ABRIL","-","-","MAYO","-","-","JUNIO","-","-",
                        "JULIO","-","-","AGOSTO","-","-","SEPTIEMBRE","-","-",
                        "OCTUBRE","-","-","NOVIEMBRE","-","-","DICIEMBRE","-","-"};
            }
            return show;
        }catch(Exception e){
            Log.d(null,"ERROR Payment_schedule Search: "+e.getMessage());
            return null;
        }
    }
}

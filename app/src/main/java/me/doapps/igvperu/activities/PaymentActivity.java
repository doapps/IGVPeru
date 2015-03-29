package me.doapps.igvperu.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import me.doapps.igvperu.model.OpenHelper;
import me.doapps.igvperu.R;

public class PaymentActivity extends ActionBarActivity{
    EditText editTextRuc;
    Button buttonSearchRuc;
    OpenHelper ObjSqlite=new OpenHelper(this,"IGVPeru",null,3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_schedule);
        try {
            //ArrayAdapter<String> adapter;
            //adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,show);
            //GridView lv=(GridView)findViewById(R.id.gridViewResultado);
           // lv.setAdapter(adapter);
            editTextRuc=(EditText)findViewById(R.id.editTextRuc);
            buttonSearchRuc=(Button)findViewById(R.id.buttonSearchRuc);
            //buttonSearchRuc.setText("HOLA");
            /*
            buttonSearchRuc.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String Ruc=editTextRuc.getText().toString();
                    if(Ruc.length()==11){
                        Search(Ruc);
                    }else{
                        Toast.makeText(PaymentActivity.this,"Wrong Format!\nEnter again please!  ",Toast.LENGTH_LONG).show();
                    }
                }
            });
            */
        }catch (Exception e){
            Log.d(null,"ERROR Payment_Schedule onCreate: "+e.getMessage());
        }

    }

    public String[] Search(String ruc){
        try {
            String[] show=null;
            if(!ruc.equals(" ")){
                Object[][] Result=ObjSqlite.Search("schedule",new String[]{"Period","RegularPayment","SpecialPayment"}," lastNumRuc='"+ruc.charAt(10)+"' AND status=1");
                if(Result!=null){
                    Toast.makeText(this,"i=0 j=0 => "+Result[0][0].toString(),Toast.LENGTH_LONG).show();
                    Toast.makeText(this,"i=0 j=1 => "+Result[0][1].toString(),Toast.LENGTH_LONG).show();
                    Toast.makeText(this,"i=0 j=2 => "+Result[0][2].toString(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this,"Not Found!",Toast.LENGTH_LONG).show();
                }
            }
            return show;
        }catch(Exception e){
            Log.d(null,"ERROR Payment_schedule Search: "+e.getMessage());
            return null;
        }
    }
}

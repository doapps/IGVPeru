package me.doapps.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class OpenHelper extends SQLiteOpenHelper {

    public OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("create table schedule(" +
                    "_id integer primary key autoincrement," +
                    "lastNumRuc integer NOT NULL,"+
                    "period text NOT NULL,"+
                    "regularPayment text NOT NULL,"+
                    //"specialPayment text NOT NULL,"+
                    "status integer NOT NULL)");
            db.execSQL("create table history(" +
                    "_id integer primary key autoincrement," +
                    "ruc integer NOT NULL,"+
                    "company text NOT NULL,"+
                    "date text NOT NULL,"+
                    "status integer NOT NULL)");

            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'Ene-15','13 Feb',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'Feb-15','13 Mar',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'Mar-15','16 Abr',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'Abr-15','15 May',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'May-15','12 Jun',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'Jun-15','14 Jul',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'Jul-15','14 Ago',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'Ago-15','14 Set',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'Set-15','15 Oct',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'Oct-15','13 Nov',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'Nov-15','15 Dic',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'Dic-15','15 Ene',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'Ene-15','16 Feb',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'Feb-15','16 Mar',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'Mar-15','17 Abr',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'Abr-15','18 May',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'May-15','15 Jun',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'Jun-15','15 Jul',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'Jul-15','17 Ago',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'Ago-15','15 Set',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'Set-15','16 Oct',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'Oct-15','16 Nov',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'Nov-15','16 Dic',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'Dic-15','18 Ene',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'Ene-15','17 Feb',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'Feb-15','17 Mar',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'Mar-15','20 Abr',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'Abr-15','19 May',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'May-15','16 Jun',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'Jun-15','16 Jul',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'Jul-15','18 Ago',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'Ago-15','16 Set',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'Set-15','19 Oct',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'Oct-15','17 Nov',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'Nov-15','17 Dic',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'Dic-15','19 Ene',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'Ene-15','18 Feb',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'Feb-15','18 Mar',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'Mar-15','21 Abr',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'Abr-15','20 May',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'May-15','17 Jun',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'Jun-15','17 Jul',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'Jul-15','19 Ago',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'Ago-15','17 Set',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'Set-15','20 Oct',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'Oct-15','18 Nov',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'Nov-15','18 Dic',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'Dic-15','20 Ene',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'Ene-15','19 Feb',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'Feb-15','19 Mar',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'Mar-15','22 Abr',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'Abr-15','21 May',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'May-15','18 Jun',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'Jun-15','20 Jul',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'Jul-15','20 Ago',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'Ago-15','18 Set',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'Set-15','21 Oct',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'Oct-15','19 Nov',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'Nov-15','21 Dic',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'Dic-15','21 Ene',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'Ene-15','20 Feb',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'Feb-15','20 Mar',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'Mar-15','23 Abr',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'Abr-15','22 May',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'May-15','19 Jun',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'Jun-15','21 Jul',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'Jul-15','21 Ago',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'Ago-15','21 Set',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'Set-15','22 Oct',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'Oct-15','20 Nov',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'Nov-15','22 Dic',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'Dic-15','22 Ene',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'Ene-15','09 Feb',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'Feb-15','09 Mar',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'Mar-15','10 Abr',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'Abr-15','11 May',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'May-15','08 Jun',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'Jun-15','08 Jul',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'Jul-15','10 Ago',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'Ago-15','08 Set',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'Set-15','09 Oct',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'Oct-15','09 Nov',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'Nov-15','09 Dic',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'Dic-15','11 Ene',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'Ene-15','10 Feb',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'Feb-15','10 Mar',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'Mar-15','13 Abr',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'Abr-15','12 May',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'May-15','09 Jun',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'Jun-15','09 Jul',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'Jul-15','11 Ago',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'Ago-15','09 Set',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'Set-15','12 Oct',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'Oct-15','10 Nov',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'Nov-15','10 Dic',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'Dic-15','12 Ene',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'Ene-15','11 Feb',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'Feb-15','11 Mar',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'Mar-15','14 Abr',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'Abr-15','13 May',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'May-15','10 Jun',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'Jun-15','10 Jul',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'Jul-15','12 Ago',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'Ago-15','10 Set',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'Set-15','13 Oct',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'Oct-15','11 Nov',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'Nov-15','11 Dic',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'Dic-15','13 Ene',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'Ene-15','12 Feb',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'Feb-15','12 Mar',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'Mar-15','15 Abr',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'Abr-15','14 May',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'May-15','11 Jun',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'Jun-15','13 Jul',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'Jul-15','13 Ago',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'Ago-15','11 Set',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'Set-15','14 Oct',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'Oct-15','12 Nov',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'Nov-15','14 Dic',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'Dic-15','14 Ene',"+1+")");
            //Log.e("SQL ","Registros insertados: "+countTable());
            //db.close();
        } catch (Exception e) {
            Log.e(null, "ERROR OpenHelper onCreate " + e.getMessage());
        }
    }

    public int countTable() {
        int temp_count = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT count(*) FROM schedule",null);
        while (c.moveToNext()) {
            temp_count = c.getInt(0);
        }
        c.close();
        db.close();
        return temp_count;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists schedule");
        this.onCreate(db);
    }

    public String[] getPeriods(){
        try {
            String[] Result;
            SQLiteDatabase SQLiteDB=this.getReadableDatabase();
            Cursor c=SQLiteDB.rawQuery("SELECT DISTINCT(period) FROM schedule ORDER BY _id ASC",null);
            Result=new String[c.getCount()];
            for(int i=0;i<c.getCount();i++){
                c.moveToNext();
                Result[i]=c.getString(0);
            }
            c.close();
            SQLiteDB.close();
            return Result;
        }catch(Exception e){
            Log.e(null,"EROR: OpenHelper getPeriod");
            return null;
        }
    }

    public Object[][] Search(String table, String[] fields, String condition) {
        try {
            Object[][] Result;
            SQLiteDatabase SQLiteDB=this.getReadableDatabase();
            Cursor c =SQLiteDB.query(table, fields, condition, null, null, null, null);
            Result = new Object[c.getCount()][c.getColumnCount()];
            int i = 0;
            while (c.moveToNext()) {
                for (int j = 0; j < c.getColumnCount(); j++) {
                    Result[i][j] = c.getString(j);
                }
                i++;
            }
            c.close();
            SQLiteDB.close();
            return Result;
        } catch (Exception e) {
            Log.e(null, "ERROR OpenHelper Search: " + e.getMessage());
            return null;
        }
    }

    /****/
    public void insertHistory(int ruc, String company, String date, int status) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.insert("history", null, contentValuesHistory(ruc, company, date, status));
    }
    private ContentValues contentValuesHistory(int ruc, String company, String date, int status) {
        ContentValues values = new ContentValues();
        values.put("ruc", ruc);
        values.put("company", company);
        values.put("date", date);
        values.put("status", status);
        return values;
    }

    public Cursor selectHistory() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = new String[]{"ruc","company","date","status"};
        return db.query("history", columns, "status" + "=?", new String[]{"1"}, null, null, null);
    }

    public void updateHistory(String id, String state) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("status", state);
        db.update("history", values, "_id" + "=?", new String[]{id});
    }

}

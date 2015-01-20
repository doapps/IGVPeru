package me.doapps.model;

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
                    "specialPayment text NOT NULL,"+
                    "status integer NOT NULL)");

            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(0,'Ene-14','Feb-13','Feb-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(0,'Feb-14','Mar-13','Mar-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(0,'Mar-14','Abr-11','Abr-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(0,'Abr-14','May-14','May-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(0,'May-14','Jun-12','Jun-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(0,'Jun-14','Jul-11','Jul-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(0,'Jul-14','Ago-13','Ago-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(0,'Ago-14','Sep-11','Sep-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(0,'Sep-14','Oct-14','Oct-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(0,'Oct-14','Nov-13','Nov-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(0,'Nov-14','Dic-12','Dic-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(0,'Dic-14','Dic-14','Ene-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(1,'Ene-14','Feb-14','Feb-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(1,'Feb-14','Mar-14','Mar-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(1,'Mar-14','Abr-14','Abr-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(1,'Abr-14','May-15','May-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(1,'May-14','Jun-13','Jun-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(1,'Jun-14','Jul-14','Jul-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(1,'Jul-14','Ago-14','Ago-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(1,'Ago-14','Sep-12','Sep-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(1,'Sep-14','Oct-15','Oct-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(1,'Oct-14','Nov-14','Nov-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(1,'Nov-14','Dic-15','Dic-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(1,'Dic-14','Ene-15','Ene-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(2,'Ene-14','Feb-17','Feb-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(2,'Feb-14','Mar-17','Mar-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(2,'Mar-14','Abr-15','Abr-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(2,'Abr-14','May-16','May-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(2,'May-14','Jun-16','Jun-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(2,'Jun-14','Jul-15','Jul-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(2,'Jul-14','Ago-15','Ago-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(2,'Ago-14','Sep-15','Sep-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(2,'Sep-14','Oct-16','Oct-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(2,'Oct-14','Nov-17','Nov-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(2,'Nov-14','Dic-16','Dic-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(2,'Dic-14','Ene-16','Ene-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(3,'Ene-14','Feb-18','Feb-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(3,'Feb-14','Mar-18','Mar-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(3,'Mar-14','Abr-16','Abr-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(3,'Abr-14','May-19','May-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(3,'May-14','Jun-17','Jun-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(3,'Jun-14','Jul-16','Jul-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(3,'Jul-14','Ago-18','Ago-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(3,'Ago-14','Sep-16','Sep-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(3,'Sep-14','Oct-17','Oct-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(3,'Oct-14','Nov-18','Nov-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(3,'Nov-14','Dic-17','Dic-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(3,'Dic-14','Ene-19','Ene-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(4,'Ene-14','Feb-19','Feb-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(4,'Feb-14','Mar-19','Mar-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(4,'Mar-14','Abr-21','Abr-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(4,'Abr-14','May-20','May-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(4,'May-14','Jun-18','Jun-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(4,'Jun-14','Jul-17','Jul-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(4,'Jul-14','Ago-19','Ago-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(4,'Ago-14','Sep-17','Sep-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(4,'Sep-14','Oct-20','Oct-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(4,'Oct-14','Nov-19','Nov-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(4,'Nov-14','Dic-18','Dic-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(4,'Dic-14','Ene-20','Ene-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(5,'Ene-14','Feb-20','Feb-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(5,'Feb-14','Mar-20','Mar-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(5,'Mar-14','Abr-22','Abr-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(5,'Abr-14','May-21','May-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(5,'May-14','Jun-19','Jun-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(5,'Jun-14','Jul-18','Jul-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(5,'Jul-14','Ago-20','Ago-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(5,'Ago-14','Sep-18','Sep-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(5,'Sep-14','Oct-21','Oct-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(5,'Oct-14','Nov-20','Nov-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(5,'Nov-14','Dic-19','Dic-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(5,'Dic-14','Ene-21','Ene-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(6,'Ene-14','Feb-21','Feb-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(6,'Feb-14','Mar-21','Mar-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(6,'Mar-14','Abr-23','Abr-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(6,'Abr-14','May-22','May-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(6,'May-14','Jun-20','Jun-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(6,'Jun-14','Jul-21','Jul-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(6,'Jul-14','Ago-21','Ago-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(6,'Ago-14','Sep-19','Sep-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(6,'Sep-14','Oct-22','Oct-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(6,'Oct-14','Nov-21','Nov-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(6,'Nov-14','Dic-22','Dic-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(6,'Dic-14','Ene-22','Ene-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(7,'Ene-14','Feb-10','Feb-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(7,'Feb-14','Mar-10','Mar-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(7,'Mar-14','Abr-08','Abr-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(7,'Abr-14','May-09','May-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(7,'May-14','Jun-09','Jun-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(7,'Jun-14','Jul-08','Jul-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(7,'Jul-14','Ago-08','Ago-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(7,'Ago-14','Sep-08','Sep-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(7,'Sep-14','Oct-09','Oct-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(7,'Oct-14','Nov-10','Nov-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(7,'Nov-14','Dic-09','Dic-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(7,'Dic-14','Ene-09','Ene-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(8,'Ene-14','Feb-11','Feb-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(8,'Feb-14','Mar-11','Mar-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(8,'Mar-14','Abr-09','Abr-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(8,'Abr-14','May-12','May-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(8,'May-14','Jun-10','Jun-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(8,'Jun-14','Jul-09','Jul-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(8,'Jul-14','Ago-11','Ago-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(8,'Ago-14','Sep-09','Sep-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(8,'Sep-14','Oct-10','Oct-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(8,'Oct-14','Nov-11','Nov-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(8,'Nov-14','Dic-10','Dic-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(8,'Dic-14','Ene-12','Ene-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(9,'Ene-14','Feb-12','Feb-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(9,'Feb-14','Mar-12','Mar-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(9,'Mar-14','Abr-10','Abr-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(9,'Abr-14','May-13','May-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(9,'May-14','Jun-11','Jun-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(9,'Jun-14','Jul-10','Jul-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(9,'Jul-14','Ago-12','Ago-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(9,'Ago-14','Sep-10','Sep-22',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(9,'Sep-14','Oct-13','Oct-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(9,'Oct-14','Nov-12','Nov-24',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(9,'Nov-14','Dic-11','Dic-23',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,specialPayment,status) VALUES(9,'Dic-14','Ene-13','Ene-23',"+1+")");

        } catch (Exception e) {
            Log.e(null, "ERROR OpenHelper onCreate " + e.getMessage());
        }

    }

    public int countTable() {
        int temp_count = 0;
        Cursor c = this.getReadableDatabase().rawQuery("SELECT count(*) FROM schedule", null);
        while (c.moveToNext()) {
            temp_count = c.getInt(0);
        }
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


}

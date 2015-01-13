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
                    "lastNumRuc text NOT NULL," +
                    "Period text NOT NULL," +
                    "RegularPayment text NOT NULL," +
                    "SpecialPayment text NOT NULL," +
                    "Status int NOT NULL" +
                    ")");


            /*insertBook("0","Ene-14","Feb-13","Feb-24");
            insertBook("0","Feb-14","Mar-13","Mar-24");*/

            ContentValues values = new ContentValues();
            values.put("lastNumRuc", "0");
            values.put("Period", "Ene-14");
            values.put("RegularPayment", "Feb-13");
            values.put("SpecialPayment", "Feb-24");
            values.put("Status", 1);
            db.insert("schedule", null, values);

            ContentValues values_ = new ContentValues();
            values_.put("lastNumRuc", "1");
            values_.put("Period", "Ene-14");
            values_.put("RegularPayment", "Feb-13");
            values_.put("SpecialPayment", "Feb-24");
            values_.put("Status", 1);
            db.insert("schedule", null, values_);



        } catch (Exception e) {
            Log.d(null, "ERROR OpenHelper onCreate " + e.getMessage());
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

    public void insertBook(String lastNumRuc, String Period, String RegularPayment, String SpecialPayment){
        ContentValues values = new ContentValues();
        values.put("lastNumRuc", lastNumRuc);
        values.put("Period", Period);
        values.put("RegularPayment", RegularPayment);
        values.put("SpecialPayment", SpecialPayment);
        values.put("Status", 1);
        this.getWritableDatabase().insert("schedule", null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists schedule");
        this.onCreate(db);
    }

    public Object[][] Search(String table, String[] fields, String condition) {
        try {
            Object[][] Result;
            Cursor c = this.getReadableDatabase().query(table, fields, condition, null, null, null, null);
            Result = new Object[c.getCount()][c.getColumnCount()];
            while (c.moveToNext()) {
                int i = 0;
                for (int j = 0; j < c.getColumnCount(); j++) {
                    Result[i][j] = c.getString(j);
                }
            }
            return Result;
        } catch (Exception e) {
            Log.d(null, "ERROR OpenHelper Search: " + e.getMessage());
            return null;
        }
    }


}

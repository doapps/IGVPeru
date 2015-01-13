package me.doapps.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OpenHelper extends SQLiteOpenHelper{

    public OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table schedule(" +
                "schudeleId int PRIMARY KEY NOT NULL," +
                "lastNumRuc text NOT NULL," +
                "Period text NOT NULL," +
                "RegularPayment text NOT NULL," +
                "SpecialPayment text NOT NULL," +
                "Status int NOT NULL" +
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists schedule");
        this.onCreate(db);
    }

}

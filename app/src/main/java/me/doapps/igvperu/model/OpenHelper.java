package me.doapps.igvperu.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class OpenHelper extends SQLiteOpenHelper {

    public static final int BD_VERSION = 4;

    private final String CREATE_TABLE_SCHEDULE = ("create table schedule(" +
            "_id integer primary key autoincrement," +
            "lastNumRuc integer NOT NULL,"+
            "period text NOT NULL,"+
            "regularPayment text NOT NULL,"+
            "status integer NOT NULL)");
    private final String CREATE_TABLE_HISTORY = ("create table history(" +
            "_id integer primary key autoincrement," +
            "ruc text NOT NULL,"+
            "company text NOT NULL,"+
            "date text NOT NULL,"+
            "status integer NOT NULL)");
    private final String DROP_TABLE_SCHEDULE = "drop table if exists schedule";
    private final String DROP_TABLE_HISTORY = "drop table if exists history";

    public OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE_SCHEDULE);
            db.execSQL(CREATE_TABLE_HISTORY);

            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'ENERO 2016','17 de Febrero',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'FEBRERO 2016','17 de Marzo',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'MARZO 2016','19 de Abril',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'ABRIL 2016','18 de Mayo',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'MAYO 2016','17 de Junio',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'JUNIO 2016','19 de Julio',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'JULIO 2016','17 de Agosto',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'AGOSTO 2016','19 de Septiembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'SEPTIEMBRE 2016','19 de Octubre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'OCTUBRE 2016','18 de Noviembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'NOVIEMBRE 2016','20 de Diciembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(0,'DICIEMBRE 2016','18 de Enero',"+1+")");

            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'ENERO 2016','18 de Febrero',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'FEBRERO 2016','18 de Marzo',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'MARZO 2016','20 de Abril',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'ABRIL 2016','19 de Mayo',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'MAYO 2016','20 de Junio',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'JUNIO 2016','20 de Julio',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'JULIO 2016','18 de Agosto',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'AGOSTO 2016','20 de Septiembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'SEPTIEMBRE 2016','20 de Octubre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'OCTUBRE 2016','21 de Noviembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'NOVIEMBRE 2016','21 de Diciembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(1,'DICIEMBRE 2016','19 de Enero',"+1+")");

            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'ENERO 2016','19 de Febrero',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'FEBRERO 2016','21 de Marzo',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'MARZO 2016','21 de Abril',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'ABRIL 2016','20 de Mayo',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'MAYO 2016','21 de Junio',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'JUNIO 2016','21 de Julio',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'JULIO 2016','19 de Agosto',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'AGOSTO 2016','21 de Septiembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'SEPTIEMBRE 2016','21 de Octubre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'OCTUBRE 2016','22 de Noviembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'NOVIEMBRE 2016','22 de Diciembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(2,'DICIEMBRE 2016','20 de Enero',"+1+")");

            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'ENERO 2016','19 de Febrero',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'FEBRERO 2016','21 de Marzo',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'MARZO 2016','21 de Abril',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'ABRIL 2016','20 de Mayo',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'MAYO 2016','21 de Junio',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'JUNIO 2016','21 de Julio',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'JULIO 2016','19 de Agosto',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'AGOSTO 2016','21 de Septiembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'SEPTIEMBRE 2016','21 de Octubre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'OCTUBRE 2016','22 de Noviembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'NOVIEMBRE 2016','22 de Diciembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(3,'DICIEMBRE 2016','20 de Enero',"+1+")");

            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'ENERO 2016','12 de Febrero',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'FEBRERO 2016','14 de Marzo',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'MARZO 2016','14 de Abril',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'ABRIL 2016','13 de Mayo',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'MAYO 2016','14 de Junio',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'JUNIO 2016','14 de Julio',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'JULIO 2016','12 de Agosto',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'AGOSTO 2016','14 de Septiembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'SEPTIEMBRE 2016','14 de Octubre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'OCTUBRE 2016','15 de Noviembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'NOVIEMBRE 2016','15 de Diciembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(4,'DICIEMBRE 2016','13 de Enero',"+1+")");

            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'ENERO 2016','12 de Febrero',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'FEBRERO 2016','14 de Marzo',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'MARZO 2016','14 de Abril',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'ABRIL 2016','13 de Mayo',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'MAYO 2016','14 de Junio',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'JUNIO 2016','14 de Julio',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'JULIO 2016','12 de Agosto',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'AGOSTO 2016','14 de Septiembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'SEPTIEMBRE 2016','14 de Octubre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'OCTUBRE 2016','15 de Noviembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'NOVIEMBRE 2016','15 de Diciembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(5,'DICIEMBRE 2016','13 de Enero',"+1+")");

            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'ENERO 2016','15 de Febrero',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'FEBRERO 2016','15 de Marzo',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'MARZO 2016','15 de Abril',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'ABRIL 2016','16 de Mayo',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'MAYO 2016','15 de Junio',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'JUNIO 2016','15 de Julio',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'JULIO 2016','15 de Agosto',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'AGOSTO 2016','15 de Septiembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'SEPTIEMBRE 2016','17 de Octubre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'OCTUBRE 2016','16 de Noviembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'NOVIEMBRE 2016','16 de Diciembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(6,'DICIEMBRE 2016','16 de Enero',"+1+")");

            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'ENERO 2016','15 de Febrero',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'FEBRERO 2016','15 de Marzo',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'MARZO 2016','15 de Abril',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'ABRIL 2016','16 de Mayo',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'MAYO 2016','15 de Junio',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'JUNIO 2016','15 de Julio',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'JULIO 2016','15 de Agosto',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'AGOSTO 2016','15 de Septiembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'SEPTIEMBRE 2016','17 de Octubre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'OCTUBRE 2016','16 de Noviembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'NOVIEMBRE 2016','16 de Diciembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(7,'DICIEMBRE 2016','16 de Enero',"+1+")");

            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'ENERO 2016','16 de Febrero',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'FEBRERO 2016','16 de Marzo',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'MARZO 2016','18 de Abril',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'ABRIL 2016','17 de Mayo',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'MAYO 2016','16 de Junio',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'JUNIO 2016','18 de Julio',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'JULIO 2016','16 de Agosto',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'AGOSTO 2016','16 de Septiembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'SEPTIEMBRE 2016','18 de Octubre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'OCTUBRE 2016','17 de Noviembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'NOVIEMBRE 2016','19 de Diciembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(8,'DICIEMBRE 2016','17 de Enero',"+1+")");

            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'ENERO 2016','16 de Febrero',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'FEBRERO 2016','16 de Marzo',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'MARZO 2016','18 de Abril',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'ABRIL 2016','17 de Mayo',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'MAYO 2016','16 de Junio',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'JUNIO 2016','18 de Julio',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'JULIO 2016','16 de Agosto',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'AGOSTO 2016','16 de Septiembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'SEPTIEMBRE 2016','18 de Octubre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'OCTUBRE 2016','17 de Noviembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'NOVIEMBRE 2016','19 de Diciembre',"+1+")");
            db.execSQL("INSERT INTO schedule (lastNumRuc,period,regularPayment,status) VALUES(9,'DICIEMBRE 2016','17 de Enero',"+1+")");
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
        db.execSQL(DROP_TABLE_SCHEDULE);
        db.execSQL(DROP_TABLE_HISTORY);
        onCreate(db);
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
    public void insertHistory(String ruc, String company, String date, int status) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.insert("history", null, contentValuesHistory(ruc, company, date, status));
    }

    private ContentValues contentValuesHistory(String ruc, String company, String date, int status) {
        ContentValues values = new ContentValues();
        values.put("ruc", ruc);
        values.put("company", company);
        values.put("date", date);
        values.put("status", status);
        return values;
    }

    public Cursor selectHistory() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = new String[]{"_id", "ruc","company","date","status"};
        return db.query("history", columns, "status" + "=?", new String[]{"1"}, null, null, null);
    }

    public void updateHistory(String id, String state) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("status", state);
        db.update("history", values, "_id" + "=?", new String[]{id});
    }

    public int existRuc(String ruc) {
        int temp_count = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT count(*) FROM history WHERE status='1' AND ruc="+ruc,null);
        while (c.moveToNext()) {
            temp_count = c.getInt(0);
        }
        c.close();
        db.close();
        return temp_count;
    }
}

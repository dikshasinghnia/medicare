package com.example.hp.medicare;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;


public class DatabaseHistory extends SQLiteOpenHelper {
    public DatabaseHistory(Context context) {
        super(context, "History.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL("create table med(opd text primary key ,medical_history text,notes text,ccomplaint text not null,FOREIGN KEY(opd) REFERENCES patient(opdno))");


    }
    @Override
    public void onUpgrade(SQLiteDatabase d, int oldVersion, int newVersion)
    {


        d.execSQL("drop table if exists med");


    }
    public boolean insert (String opd,String medical_history, String notes, String ccomplaint)
    {
        SQLiteDatabase d =getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("opd",opd);
        contentValues.put("medical_history", medical_history);
        contentValues.put("notes", notes);
        contentValues.put("ccomplaint", ccomplaint);
        long ins = d.insert("med",null, contentValues);
        if (ins == -1) return false;
        else return true;

    }
    public Cursor getpatients(String opdno)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cu =db.rawQuery("select * from med where opd='"+opdno+"'",null);
        if (cu!=null)
        {
            cu.moveToFirst();
        }
        return cu;


    }
}

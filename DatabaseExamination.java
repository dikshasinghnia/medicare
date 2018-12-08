package com.example.hp.medicare;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseExamination extends SQLiteOpenHelper
{
    public DatabaseExamination(Context context)
    {
        super(context, "e.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table e(opd text primary key,cf text not null,pd text not null,inv text not null,fd text not null)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase d, int oldVersion, int newVersion)
    {
        d.execSQL("drop table if exists e");
    }
    public boolean insert (String opd,String cf, String pd, String inv,String fd)
    {
        SQLiteDatabase d =getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("opd",opd);
        contentValues.put("cf", cf);
        contentValues.put("pd", pd);
        contentValues.put("inv",inv);
        contentValues.put("fd", fd);
        long ins = d.insert("e",null, contentValues);
        if (ins == -1) return false;
        else return true;

    }
    public Cursor getpatients(String opdno)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cu = db.rawQuery("select * from e where opd='" + opdno + "'", null);
        if (cu != null) {
            cu.moveToFirst();
        }
        return cu;


    }
}

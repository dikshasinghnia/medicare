package com.example.hp.medicare;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseAppointment extends SQLiteOpenHelper
{
    public DatabaseAppointment(Context context)
    {
        super(context, "appointment.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table appointment(opd text primary key,name text not null,date text not null,time text not null)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase d, int oldVersion, int newVersion)
    {
        d.execSQL("drop table if exists appointment");
    }
    public boolean insert (String opd,String name, String date, String time)
    {
        SQLiteDatabase d =getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("opd",opd);
        contentValues.put("name", name);
        contentValues.put("date", date);
        contentValues.put("time",time);
        long ins = d.insert("appointment",null, contentValues);
        if (ins == -1) return false;
        else return true;
    }
    public Cursor getappo(String dated)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cu = db.rawQuery("select * from appointment where date='" + dated + "'", null);
        return cu;
    }
}

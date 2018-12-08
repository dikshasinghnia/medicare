package com.example.hp.medicare;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
public class DatabasePatient extends SQLiteOpenHelper
{
    public DatabasePatient(Context context) {
        super(context, "Patient.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table patient(opdno text primary key,name text not null,age text not null,sex text not null,address text not null,email text not null,mobile text not null)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase d, int oldVersion, int newVersion)
    {
       d.execSQL("drop table if exists patient");
    }
    public boolean insert(String opdno,String name, String age, String sex, String address, String email,String mobile)
    {
        SQLiteDatabase d =getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("opdno",opdno);
        contentValues.put("name", name);
        contentValues.put("age", age);
        contentValues.put("sex", sex);
        contentValues.put("address", address);
        contentValues.put("email", email);
        contentValues.put("mobile", mobile);
        long ins = d.insert("patient", null, contentValues);
        if (ins == -1) return false;
        else return true;
    }
    public Cursor getpatients(String opdno)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cu =db.rawQuery("select * from patient where opdno='"+opdno+"'",null);
        if (cu!=null)
        {
            cu.moveToFirst();
        }
        return cu;


    }

}

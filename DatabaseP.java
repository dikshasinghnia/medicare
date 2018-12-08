package com.example.hp.medicare;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseP extends SQLiteOpenHelper
{

    public DatabaseP(Context context)
    {
        super(context, "p.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table p(name text not null,dated text not null,opd text primary key,age text not null,comp text not null,med text not null,tests text,doc text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase d, int oldVersion, int newVersion) {
        d.execSQL("drop table if exists p");
    }

    public boolean insert(String name, String dated, String opd, String age, String comp, String med, String tests, String doc) {
        SQLiteDatabase d = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("dated", dated);
        contentValues.put("opd", opd);
        contentValues.put("age", age);
        contentValues.put("comp", comp);
        contentValues.put("med", med);
        contentValues.put("tests", tests);
        contentValues.put("doc", doc);
        long ins = d.insert("p", null, contentValues);
        if (ins == -1) return false;
        else return true;

    }


    public Cursor getpatients(String opdno)
    {
        SQLiteDatabase d = this.getWritableDatabase();
        Cursor cu = d.rawQuery("select * from p where opd='" + opdno + "'", null);
        if (cu != null)
        {
            cu.moveToFirst();
        }
        return cu;
    }
}
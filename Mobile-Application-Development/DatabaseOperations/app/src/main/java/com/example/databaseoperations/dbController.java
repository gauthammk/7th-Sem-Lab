package com.example.databaseoperations;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class dbController extends SQLiteOpenHelper {
    public dbController(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Test1.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE STUDENT(FNAME TEXT, LNAME TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS STUDENT");
        onCreate(db);
    }

    public void insert(String a, String b)
    {
        ContentValues cv = new ContentValues();
        cv.put("FNAME",a);
        cv.put("LNAME",b);
        this.getWritableDatabase().insertOrThrow("STUDENT","",cv);
    }

    public void delete(String a)
    {
        this.getWritableDatabase().delete("STUDENT","FNAME='"+a+"'",null);
    }

    public void update(String a, String aa){
        this.getWritableDatabase().execSQL("UPDATE STUDENT SET FNAME='"+aa+"' WHERE FNAME='"+a+"';");
    }

    public void list(TextView tv){
        tv.setText("");
        Cursor c = this.getReadableDatabase().rawQuery("SELECT * FROM STUDENT",null);
        while(c.moveToNext())
        {
            tv.append(c.getString(0)+" "+c.getString(1)+"\n");
        }
    }
}

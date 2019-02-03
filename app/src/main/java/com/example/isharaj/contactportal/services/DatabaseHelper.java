package com.example.isharaj.contactportal.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.isharaj.contactportal.entities.Person;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String TABLE_NAME = "contacts";
    private static final String COL2 = "first_name";
    private static final String COL3 = "last_name";
    private static final String COL4 = "mobile_no";

    public DatabaseHelper(Context context){
        super(context, TABLE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE "+ TABLE_NAME + " (ID INTEGER PRIMARY KEY, " +
                   COL2 + " TEXT, " + COL3 + " TEXT, "+ COL4 +" TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean addContact(Person person){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, person.getFirstName());
        contentValues.put(COL3,person.getLastName());
        contentValues.put(COL4,person.getMobileNumber());

        long result =  db.insert(TABLE_NAME,null,contentValues);
        return result != -1;
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = " SELECT * FROM "+TABLE_NAME;
        return db.rawQuery(query,null);
    }
}

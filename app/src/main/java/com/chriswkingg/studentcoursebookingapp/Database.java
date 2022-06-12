package com.chriswkingg.studentcoursebookingapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper{
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_USERNAMES = "username";
    private static final String COLUMN_PASSWORDS = "password";
    private static final String COLUMN_ACCOUNT_TYPE =  "type";
    private static final String DATABASE_NAME = "courseapp.db";
    private static final int DATABASE_VERSION = 1;

    public Database(Context ctx) {
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //create the database
        db.execSQL("CREATE TABLE " + TABLE_USERS +
                "(" + "id" + "INTEGER PRIMARY KEY, " +
                COLUMN_USERNAMES + " TEXT, " +
                COLUMN_PASSWORDS + " TEXT, " +
                COLUMN_ACCOUNT_TYPE + " TEXT" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //if version mismatch, recreate the database
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
            onCreate(db);
        }
    }
}

package com.chriswkingg.studentcoursebookingapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

public class Database extends SQLiteOpenHelper{
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_USERNAMES = "username";
    private static final String COLUMN_PASSWORDS = "password";
    private static final String COLUMN_ACCOUNT_TYPE =  "type";
    private static final String DATABASE_NAME = "courseapp.db";
    private static final int DATABASE_VERSION = 2;

    public Database(Context ctx) {
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //create the database
        db.execSQL("CREATE TABLE " + TABLE_USERS +
                " (" + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAMES + " TEXT, " +
                COLUMN_PASSWORDS + " TEXT, " +
                COLUMN_ACCOUNT_TYPE + " TEXT" +
                ")");
        //add admin account
        db.execSQL("INSERT INTO " + TABLE_USERS + "(" +
                COLUMN_USERNAMES + ", " +
                COLUMN_PASSWORDS + ", " +
                COLUMN_ACCOUNT_TYPE +
                ") VALUES (admin, admin123, 0)", null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //if version mismatch, recreate the database
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
            onCreate(db);
        }
    }

    public void addUser(User u) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();

        val.put(COLUMN_USERNAMES, u.getUsername());
        val.put(COLUMN_PASSWORDS, u.getPassword());
        val.put(COLUMN_ACCOUNT_TYPE, u.getType());

        db.insert(TABLE_USERS, null, val);
        db.close();
    }

    public User authUser(String username, String password) {
        Cursor users = this.getReadableDatabase().rawQuery("SELECT " + COLUMN_USERNAMES + " FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAMES + "=" + username, null);
        if(users.getString(2).equals(password)) {
            //auth successful return a user
            users.close();
            return new User(username, password, Integer.parseInt(users.getString(3)));
        }
        //user doesnt exist
        users.close();
        return null;
    }
}

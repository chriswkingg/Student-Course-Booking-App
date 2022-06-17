package com.chriswkingg.studentcoursebookingapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.util.Log;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper{
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_USERNAMES = "username";
    private static final String COLUMN_PASSWORDS = "password";
    private static final String COLUMN_ACCOUNT_TYPE =  "accountType";
    private static final String DATABASE_NAME = "courseapp.db";
    private static final int DATABASE_VERSION = 4;

    private static final String TABLE_COURSES = "courses";
    private static final String COLUMN_COURSECODE = "courseCode";
    private static final String COLUMN_COURSENAME = "courseName";

    public Database(Context ctx) {
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        //create the users table
        db.execSQL("CREATE TABLE " + TABLE_USERS +
                " (" + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAMES + " TEXT, " +
                COLUMN_PASSWORDS + " TEXT, " +
                COLUMN_ACCOUNT_TYPE + " TEXT" +
                ")");

        //add admin account
        ContentValues val = new ContentValues();
        val.put(COLUMN_USERNAMES, "admin");
        val.put(COLUMN_PASSWORDS, "admin123");
        val.put(COLUMN_ACCOUNT_TYPE, "0");

        db.insert(TABLE_USERS, null, val);

        //create the courses table
        db.execSQL("CREATE TABLE " + TABLE_COURSES +
                " (" + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_COURSECODE + " TEXT, " +
                COLUMN_COURSENAME + " TEXT " +
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

    public void addUser(User u) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();

        val.put(COLUMN_USERNAMES, u.getUsername());
        val.put(COLUMN_PASSWORDS, u.getPassword());
        val.put(COLUMN_ACCOUNT_TYPE, u.getType());

        db.insert(TABLE_USERS, null, val);
        db.close();
    }

    public void deleteUser(User u) {
        //TODO: check if the user actually exists first
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, COLUMN_USERNAMES + "=?", new String[]{u.getUsername()});
        db.close();
    }

    public ArrayList<User> getUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<User> userList = new ArrayList<User>();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_USERS, null);
        while(c.moveToNext()) {
            //-1 user type represents the user is NOT logged in
            userList.add(new User(c.getString(1), c.getString(2), -1));
        }
        db.close();
        return userList;
    }

    public void addCourse (Course course){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();

        val.put(COLUMN_COURSECODE, course.getCode());
        val.put(COLUMN_COURSENAME, course.getDescription());

        db.insert(TABLE_COURSES, null, val);
        db.close();
    }

    public void deleteCourse(Course c) {
        //TODO: check if the course exists first
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_COURSES, COLUMN_COURSECODE + "=?", new String[]{c.getCode()});
        db.close();
    }

    public User authUser(String username, String password) {
        Cursor users = this.getReadableDatabase().rawQuery("SELECT " + " * " + " FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAMES + "='" + username + "'", null);
        if(users.getCount() == 0) {
            return null;
        }
        users.moveToFirst();
        if(users.getString(2).equals(password)) {
            //auth successful return a user
            return new User(username, password, Integer.parseInt(users.getString(3)));
        }
        //user doesnt exist
        return null;
    }
}

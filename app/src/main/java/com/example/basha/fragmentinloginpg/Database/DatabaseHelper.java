package com.example.basha.fragmentinloginpg.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by basha on 2/1/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
        public static  final int DATABASE_VERSION=1;
        public static final String DATABASE_NAME="register.db";
        public static final String TABLE_USER="user_info";
        public static final String COL_ID="ID";
        public static final String COL_NAME="Name";
        public static final String COL_EMAIL="Email";
        public static final String COL_PASSWORD="Password";

    String CREATE_TABLE_USER =" CREATE TABLE " + TABLE_USER +
            " ( " + COL_ID + " INTEGER PRIMARY KEY,"
            + COL_NAME + " TEXT," +
            COL_EMAIL + " TEXT," +
            COL_PASSWORD + " TEXT )";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


package com.example.basha.fragmentinloginpg.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.basha.fragmentinloginpg.User;

import java.util.ArrayList;

/**
 * Created by basha on 2/3/2018.
 */

public class UserManager {

    private User user;
    private DatabaseHelper helper;
    private SQLiteDatabase database;

    public UserManager(Context context) {

        helper = new DatabaseHelper(context);
    }
    private void open() {
        database = helper.getWritableDatabase();

    }

    private void close() {
        helper.close();
    }

    public boolean addUser(User user) {
        this.open();

        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseHelper.COL_NAME, user.getUserName());
        contentValues.put(DatabaseHelper.COL_EMAIL, user.getEmail());
        contentValues.put(DatabaseHelper.COL_PASSWORD, user.getPassword());


        long inserted = database.insert(DatabaseHelper.TABLE_USER, null, contentValues);
        this.close();

        if (inserted > 0) {
            return true;
        } else return false;


    }
    public User getUser(int id) {

        this.open();

        Cursor cursor = database.query(DatabaseHelper.TABLE_USER, new String[]{DatabaseHelper.COL_ID, DatabaseHelper.COL_NAME, DatabaseHelper.COL_EMAIL,DatabaseHelper.COL_PASSWORD}, DatabaseHelper.COL_ID + "= " + id, null, null, null, null);

        cursor.moveToFirst();

        int mid = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_ID));
        String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
        String email = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_EMAIL));
        String password = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PASSWORD));

        user = new User( name, email, password);
        this.close();

        return user;
    }

    public ArrayList<String> getAllUser() {

        this.open();
        ArrayList<String> userList = new ArrayList<>();
        Cursor cursor = database.query(DatabaseHelper.TABLE_USER, null, null, null, null, null, null);

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {


                String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));

                userList.add(name);
                cursor.moveToNext();
            }

        }
        this.close();
        return userList;

    }
}

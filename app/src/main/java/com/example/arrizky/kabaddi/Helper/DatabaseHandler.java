package com.example.arrizky.kabaddi.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    protected static final String DATABASE_NAME = "kabaddiDB";
    protected static final String TABLE_NAME = "login";
    protected static final String KOLOM_ID = "id";
    protected static final String KOLOM_USER = "usename";
    protected static final String KOLOM_PASS = "password";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " " +
                "( " + KOLOM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "" + KOLOM_USER+ " TEXT, " +
                "" + KOLOM_PASS+ " TEXT ) ";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS login";
        db.execSQL(sql);

        onCreate(db);
    }

    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KOLOM_ID, user.getId());
        values.put(KOLOM_USER, user.getUsername());
        values.put(KOLOM_PASS, user.getPassword());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public boolean checkUser(User user){
        String[] kolom = {
                KOLOM_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = KOLOM_USER + " = ? " + " AND " + KOLOM_PASS + " = ?";
        String[] selectionargs = {user.getUsername(), user.getPassword()};

        Cursor cursor = db.query(TABLE_NAME, kolom, selection, selectionargs, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if(cursorCount > 0){
            return true;
        }
        return false;
    }
}

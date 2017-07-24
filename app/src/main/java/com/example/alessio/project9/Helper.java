package com.example.alessio.project9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Helper extends SQLiteOpenHelper {

    /* constants declaration */
    private static final String DB_NAME = "HabitTracker.db";
    private static final int DB_VERSION = 1;

    public Helper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_JOURNAL = "CREATE TABLE " + Contract.HabitEntry.TAB_NAME +
                "(" + Contract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Contract.HabitEntry.COL_DATE + " INTEGER NOT NULL," +
                Contract.HabitEntry.COL_HABIT + " INTEGER NOT NULL," +
                Contract.HabitEntry.COL_NOTES + " STRING);";
        Log.v("Helper", "create table: " + CREATE_TABLE_JOURNAL);
        sqLiteDatabase.execSQL(CREATE_TABLE_JOURNAL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int j) {

    }

    /* insert new row */
    public void insertRow(int date, int habit, String notes) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contract.HabitEntry.COL_DATE, date);
        values.put(Contract.HabitEntry.COL_HABIT, habit);
        values.put(Contract.HabitEntry.COL_NOTES, notes);
        db.insert(Contract.HabitEntry.TAB_NAME, null, values);
    }

    /* parse row */
    public Cursor readRow() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                Contract.HabitEntry._ID,
                Contract.HabitEntry.COL_DATE,
                Contract.HabitEntry.COL_HABIT,
                Contract.HabitEntry.COL_NOTES
        };
        /* query method retrieves columns */
        Cursor cursor = db.query(
                Contract.HabitEntry.TAB_NAME, projection, null, null, null, null, null
        );
        return cursor;
    }
}
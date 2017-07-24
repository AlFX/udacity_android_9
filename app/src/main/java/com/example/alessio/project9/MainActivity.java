package com.example.alessio.project9;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Helper helper = new Helper(this);

        /* date acquisition */
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String dateStr = format.format(date);
        int dateInt = Integer.parseInt(dateStr);

        /* new habits input */
        helper.insertRow(dateInt, Contract.HabitEntry.HABIT_PROGRAMMING, "Python");
        helper.insertRow(dateInt, Contract.HabitEntry.HABIT_COOKING, "Vegetarian Lasagne");
        helper.insertRow(dateInt, Contract.HabitEntry.HABIT_SPORT, "Aerobic workout");
        helper.insertRow(dateInt, Contract.HabitEntry.HABIT_HIKING, "Isle of Skye in Scotland");

        /* parsing habits */
        Cursor cursor = helper.readRow();
        while (cursor.moveToNext()) {
            Log.v(TAG, "habit: " + cursor.getInt(0) + " " + cursor.getInt(1) + " " + cursor.getInt(2) + " " + cursor.getString(3));
        }

    }
}

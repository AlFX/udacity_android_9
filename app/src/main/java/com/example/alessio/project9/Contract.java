package com.example.alessio.project9;

import android.provider.BaseColumns;

public class Contract {

    public Contract() {
    }

    public class HabitEntry implements BaseColumns {
        public final static String TAB_NAME = "journal";
        public final static String _ID = BaseColumns._ID;
        public final static String COL_DATE = "date";
        public final static String COL_HABIT = "habit";
        public final static String COL_NOTES = "notes";

        public final static int HABIT_PROGRAMMING = 3;
        public final static int HABIT_COOKING = 0;
        public final static int HABIT_SPORT = 2;
        public final static int HABIT_HIKING = 1;
    }

}
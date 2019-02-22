package com.example.sqliteasync;

public final class ShaContract {
    private ShaContract() {

    }

    public static abstract class shaCont {
        public static final String TABLE_NAME = "student_data";
        public static final String ID = "stud_id";
        public static final String NAME = "stud_name";
        public static final String DEPARTMENT = "std_dept";
    }
}

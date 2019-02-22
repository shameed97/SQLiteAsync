package com.example.sqliteasync;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    private EditText ed_id, ed_name, ed_dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);
        ed_id = findViewById(R.id.editText);
        ed_name = findViewById(R.id.editText2);
        ed_dept = findViewById(R.id.editText3);


    }

    public void Insert_data(View view) {
        String id = ed_id.getText().toString();
        String name = ed_name.getText().toString();
        String dept = ed_dept.getText().toString();
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute("add_info", id, name, dept);
        finish();
    }
}

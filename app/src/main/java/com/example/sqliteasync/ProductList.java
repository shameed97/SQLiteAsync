package com.example.sqliteasync;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProductList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute("get_Info");
    }
}

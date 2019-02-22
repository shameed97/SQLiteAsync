package com.example.sqliteasync;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

public class BackgroundTask extends AsyncTask<String, product, String> {
    Context ctx;
    ProductAdapter productAdapter;
    Activity activity;
    ListView listView;

    BackgroundTask(Context ctx) {
        this.ctx = ctx;
        activity = (Activity) ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {


        String method = params[0];
        Shameeddp shameeddp = new Shameeddp(ctx);
        if (method.equals("add_info")) {
            String id = params[1];
            String name = params[2];
            String dept = params[3];
            SQLiteDatabase database = shameeddp.getWritableDatabase();
            shameeddp.addContacts(Integer.parseInt(id), name, dept, database);
            shameeddp.close();

            return "One row inserted";
        } else if (method.equals("get_Info")) {
            listView = activity.findViewById(R.id.list_pro);
            SQLiteDatabase db = shameeddp.getReadableDatabase();
            Cursor cursor = shameeddp.readContacts(db);
            productAdapter = new ProductAdapter(ctx, R.layout.product_list);
            String name, dept;
            int id;
            while ((cursor.moveToNext())) {
                id = cursor.getInt(cursor.getColumnIndex(ShaContract.shaCont.ID));
                name = cursor.getString(cursor.getColumnIndex(ShaContract.shaCont.NAME));
                dept = cursor.getString(cursor.getColumnIndex(ShaContract.shaCont.DEPARTMENT));
                product pro = new product(id, name, dept);
                publishProgress(pro);
            }
            return "get_Info";
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(product... values) {

        productAdapter.add(values[0]);
    }

    @Override
    protected void onPostExecute(String ret) {

        if (ret.equals("get_Info")) {
            listView.setAdapter(productAdapter);
        } else {
            Toast.makeText(ctx, ret, Toast.LENGTH_SHORT).show();
        }


    }


}
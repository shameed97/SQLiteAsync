package com.example.sqliteasync;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public ProductAdapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(product object) {
        list.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ProductHolder productHolder;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.product_list, parent, false);
            productHolder = new ProductHolder();
            productHolder.tx_id = row.findViewById(R.id.t_id);
            productHolder.tx_name = row.findViewById(R.id.t_name);
            productHolder.tx_dept = row.findViewById(R.id.t_dept);
            row.setTag(productHolder);
        } else {
            productHolder = (ProductHolder) row.getTag();
        }

        product pro = (product) getItem(position);
        productHolder.tx_id.setText(Integer.toString(pro.getId()));
        productHolder.tx_name.setText(pro.getName());
        productHolder.tx_dept.setText(pro.getDept());
        return row;


    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    static class ProductHolder {
        TextView tx_id, tx_name, tx_dept;
    }
}

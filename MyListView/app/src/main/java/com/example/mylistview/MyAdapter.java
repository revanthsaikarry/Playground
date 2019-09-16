package com.example.mylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class MyAdapter extends BaseAdapter {
    TextView Item_id;
    TextView Item_status;
    TextView Item_order_date;


    private Context context;
    ArrayList<String> Items_id;
    ArrayList<String> Items_status;
    ArrayList<String> Items_order_date;

    public MyAdapter(Context context, ArrayList<String> item_id, ArrayList<String> item_name, ArrayList<String> item_order_date) {
        this.Items_id= item_id;
        this.Items_status = item_name;
        this.Items_order_date = item_order_date;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View view1= LayoutInflater.from(context).inflate(R.layout.activity_main, viewGroup, false);

        Item_id= view1.findViewById(R.id.Item_id);
        Item_status = view1.findViewById(R.id.ItemStatus);
        Item_order_date = view1.findViewById(R.id.ItemOrderDate);

//        Item_id.setText();
        return view1;
    }
}

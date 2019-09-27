package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class MyListAdapterFragment extends BaseAdapter {
    ArrayList Item_desc, Item_qty, Item_date, Item_Cost;
    private Context context;

    public MyListAdapterFragment(Context context, ArrayList<String> item_desc, ArrayList<Integer> item_qty, ArrayList<String> item_date, ArrayList<Integer> item_cost) {
           this.Item_Cost = item_cost;
           this.Item_date = item_date;
           this.Item_desc = item_desc;
           this.Item_qty = item_qty;
           this.context = context;
    }

    @Override
    public int getCount() {
        return Item_desc.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.item_list,viewGroup, false);
        TextView Item_desc, Item_date, Item_qty, Item_cost;

        Item_desc = view1.findViewById(R.id.Item_desc);
        Item_qty = view1.findViewById(R.id.Item_qty);
        Item_cost = view1.findViewById(R.id.Item_cost);
        Item_date = view1.findViewById(R.id.Item_date);

        return view1;
    }
}

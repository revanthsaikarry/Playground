package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.login.Model.RequestModel;

import java.util.ArrayList;

class MyListAdapterFragment extends BaseAdapter {
    ArrayList Items;
    private Context context;

    public MyListAdapterFragment(Context context, ArrayList<String> item_desc) {
           this.Items = item_desc;
           this.context = context;
    }

    @Override
    public int getCount() {
        return Items.size();
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

        RequestModel requestModel = (RequestModel) this.Items.get(i);
        Item_desc.setText(String.valueOf(requestModel.getItems_desc()));
        Item_cost.setText(String.valueOf(requestModel.getItems_cost()));
        Item_date.setText(String.valueOf(requestModel.getItems_date()));
        Item_qty.setText(String.valueOf(requestModel.getItems_qty()));

        return view1;
    }
}

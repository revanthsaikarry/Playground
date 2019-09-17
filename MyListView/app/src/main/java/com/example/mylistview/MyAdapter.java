package com.example.mylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class MyAdapter extends BaseAdapter {
//    TextView Item_id;
//    TextView Item_status;
//    TextView Item_order_date;
//    ImageView imageView;


    private Context context;
//    ArrayList<String> Items_id, Items_status, Items_order_date;
    ArrayList<String> Items_id,Items_status,Items_order_date;

    public MyAdapter(Context context, ArrayList<String> item_id, ArrayList<String> item_name, ArrayList<String> item_order_date) {
        this.Items_id= item_id;
        this.Items_status = item_name;
        this.Items_order_date = item_order_date;
        this.context = context;
    }

    @Override
    public int getCount() {
        return Items_status.size();
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


        View view1= LayoutInflater.from(context).inflate(R.layout.listview, viewGroup, false);
        TextView Item_id, Item_status, Item_order_date, status_button;
        ImageView imageView;

        Item_id = view1.findViewById(R.id.Item_id);
        Item_status = view1.findViewById(R.id.ItemStatus);
        Item_order_date = view1.findViewById(R.id.ItemOrderDate);
        imageView=view1.findViewById(R.id.notification);
        status_button = view1.findViewById(R.id.notification_button);

        Item_id.setText(Items_id.get(position));
        Item_order_date.setText(Items_order_date.get(position));
        Item_status.setText(Items_status.get(position));
        imageView.setImageResource(R.drawable.notification);

        return view1;
    }
}

package com.example.mylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

class MyAdapter extends BaseAdapter {
//    TextView Item_id;
//    TextView Item_status;
//    TextView Item_order_date;
//    ImageView imageView;

    public static String request_list= "{ \"request_data\" :[{\"title\":\"PUR-122-007\",\"status\":\"APPROVED\",\"date\":\"10-jul\"}] }";

    String strJson="{ \"Employee\" :[{\"id\":\"101\",\"name\":\"Sonoo Jaiswal\",\"salary\":\"50000\"},{\"id\":\"102\",\"name\":\"Vimal Jaiswal\",\"salary\":\"60000\"}] }";


    private Context context;
//    ArrayList<String> Items_id, Items_status, Items_order_date;
    ArrayList<String> Items_id,Items_status,Items_order_date;
    JSONObject requestObject;
    JSONArray requestList;


    public MyAdapter(Context context, ArrayList<String> item_id, ArrayList<String> item_name, ArrayList<String> item_order_date) {
        this.Items_id= item_id;
        this.Items_status = item_name;
        this.Items_order_date = item_order_date;
        this.context = context;
    }

//    public MyAdapter(Context applicationContext, JSONObject jsonObject) {
//        this.context = applicationContext;
//        this.requestObject = jsonObject;
////        requestList.optJSONArray(Integer.parseInt("request_data"));
//        requestList = requestObject.optJSONArray("request_data");
//    }

    @Override
    public int getCount() {
        return Items_id.size();
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
//
//        String title = requestObject.optString("title").toString();
//        Item_id.setText(title);
//        Item_order_date.setText(requestObject.optString("date"));
//        Item_status.setText(requestObject.optString("status"));
//        imageView.setImageResource(R.drawable.notification);

        Item_id.setText(String.valueOf(Items_id.get(position)));
        Item_status.setText(String.valueOf(Items_status.get(position)));
        Item_order_date.setText(String.valueOf(Items_order_date.get(position)));

        return view1;
    }
}

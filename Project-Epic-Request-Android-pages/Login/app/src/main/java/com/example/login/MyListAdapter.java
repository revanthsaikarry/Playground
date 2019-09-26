package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.login.Model.RequestModel;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {


    private Context context;
    ArrayList<RequestModel> requestList;


    public MyListAdapter(Context context, ArrayList<RequestModel> requestList) {
        this.context = context;
        this.requestList = requestList;
    }

    @Override
    public int getCount() {
        return requestList.size();
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
    public View getView(int i, View convertView, ViewGroup parent) {


        View view = LayoutInflater.from(context).inflate(R.layout.orderlist_content, parent, false);
        TextView title, date, statusText;

//        titles.add(requestModel.getReq_no());
//        dates.add(requestModel.getReq_date());
//        status.add(requestModel.getRequestStatus());

        title = view.findViewById(R.id.orederId);
        date = view.findViewById(R.id.orderDate);
        statusText = view.findViewById(R.id.orderStatus);
        ImageView imageView = view.findViewById(R.id.imageView3);

            RequestModel requestModel = this.requestList.get(i);
            title.setText(String.valueOf(requestModel.getReq_no()));
            date.setText(String.valueOf(requestModel.getReq_date()));
            statusText.setText(String.valueOf(requestModel.getRequestStatus()));
            imageView.setImageResource(R.drawable.notification);
            return view;
    }
}